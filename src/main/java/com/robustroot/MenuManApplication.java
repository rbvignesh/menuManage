package com.robustroot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.robustroot.domain.entitity.Tenant;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.robustroot"})
@EntityScan(basePackageClasses = Tenant.class)
@EnableJpaRepositories("com.robustroot.domain.repository")
public class MenuManApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(MenuManApplication.class, args);
	}
}
