package com.robustroot.controller.springmvc;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManageTenantsController {

	
	@RequestMapping("/manageTenants")
	public String manageTenants(Map<String, Object> model) {
		System.out.println("Inside ManageTenants Controller");
		return "manageTenants";
	}

}