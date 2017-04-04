package com.robustroot.controller.springmvc;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TenantManagementController {

	
	@RequestMapping("/tenantManagement")
	public String home(Map<String, Object> model) {
		System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
		return "tenantManagement";
	}

}