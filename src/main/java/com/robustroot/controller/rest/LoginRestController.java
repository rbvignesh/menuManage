package com.robustroot.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robustroot.service.dto.UserDTO;

@RestController
public class LoginRestController {
	
	@RequestMapping("/login")
	public UserDTO authenticate(String userName,String passWord){
		System.out.println("Login Rest called..........."+userName+":"+passWord);
		UserDTO userDTO =UserDTO.builder().userName(userName).build();
		return userDTO;
	}

}
