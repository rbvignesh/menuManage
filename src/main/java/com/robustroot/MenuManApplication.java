package com.robustroot;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.robustroot.domain.entitity.Tenant;
import com.robustroot.domain.repository.TenantRepository;
import com.robustroot.service.TenantService;
import com.robustroot.service.dto.TenantDTO;

@SpringBootApplication
@ComponentScan(basePackages = {"com.robustroot"})
@EntityScan(basePackageClasses = Tenant.class)
@EnableJpaRepositories("com.robustroot.domain.repository")
public class MenuManApplication {
	@Autowired
	TenantService tenantService;

	public static void main(String[] args) {
		SpringApplication.run(MenuManApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(TenantRepository repository) {
		return (args) -> {
			//Data setup Code - Comment after executing once
			TenantDTO t = TenantDTO.builder().name("TestDTO").billingAddress("Chennai").email("test@vignesh.com").telNumber("0441111111").logoImageId(123L).status("P").createdBy("bv").createdOn(new Timestamp(System.currentTimeMillis())).lastUpdatedBy("bv").lastUpdatedOn(new Timestamp(System.currentTimeMillis())).build();

			System.out.println(tenantService.createTenant(t));
			/*List<Tenant> returnList = repository.findByStatus("P");
			System.out.println(returnList.size());
			System.out.println(returnList.get(0).getName());*/
		};
	}
}
