package com.hxb.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hxb.springcloud.entites.RespEntity;
import com.hxb.springcloud.service.TestService;

@RestController
public class TestController {
	
	@Autowired
	TestService testService;
	
	
	@GetMapping("/test")
	public RespEntity test() {
		RespEntity result = testService.getUsers();
		return result;
	}
	
	
}












































