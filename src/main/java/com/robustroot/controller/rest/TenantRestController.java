package com.robustroot.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		//return tenantService.fetchAll();
		return null;
	}

	@RequestMapping(value="/createTenant",method = RequestMethod.POST, consumes = "application/json")
	public Long createTenant(@RequestBody final TenantDTO newTenantdto){
		System.out.println("Rest called...........");
		//return tenantService.create(newTenantdto);
		return null;
	}

}
