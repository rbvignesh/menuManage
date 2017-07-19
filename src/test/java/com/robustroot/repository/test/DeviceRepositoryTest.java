package com.robustroot.repository.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.robustroot.domain.entitity.Device;
import com.robustroot.domain.repository.DeviceRepository;



@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
@ActiveProfiles("junit")
@AutoConfigureTestDatabase(replace=Replace.NONE)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
public class DeviceRepositoryTest {
	@Autowired
	DeviceRepository repo;
	@Test
	@DatabaseSetup(value="/device_dataset.xml",type=DatabaseOperation.CLEAN_INSERT)
	@DatabaseTearDown(value="/device_dataset.xml", type=DatabaseOperation.DELETE_ALL)
	public void testFindByStatus() throws Exception {
		List<Device> entityList = repo.findAll();
		Assert.assertEquals(1, entityList.size());
	}

}
