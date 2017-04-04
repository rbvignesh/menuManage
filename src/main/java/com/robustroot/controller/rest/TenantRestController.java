package com.robustroot.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robustroot.service.TenantService;
import com.robustroot.service.dto.TenantDTO;

@RestController
public class TenantRestController {
	@Autowired
	TenantService tenantService;
	
	@RequestMapping("/fetchAllTenants")
	public List<TenantDTO> fetchAllTenants(){
		System.out.println("Rest called...........");
		return tenantService.fetchAllTenants();
	}

}
