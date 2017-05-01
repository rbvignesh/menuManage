package com.robustroot.controller.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.robustroot.MenuManApplication;
import com.robustroot.service.TenantService;
import com.robustroot.service.dto.TenantDTO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MenuManApplication.class})
@WebAppConfiguration
public class TenantRestControllerTest {

	private MockMvc mockMvc;
	@Mock
	TenantService tenantService;
	@Test
	public void test() throws Exception {
		TenantRestController tenantRestController = new TenantRestController();
		tenantRestController.tenantService = tenantService;
		Mockito.when(tenantService.fetchAll()).thenReturn(new ArrayList<TenantDTO>());
		mockMvc =
				standaloneSetup(tenantRestController).build();
				mockMvc.perform(get("/fetchAllTenants"))
				.andExpect(status().isOk());
		
	}

}
