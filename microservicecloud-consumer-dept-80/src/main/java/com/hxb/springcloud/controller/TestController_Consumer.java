package com.hxb.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hxb.springcloud.entites.RespEntity;
import com.hxb.springcloud.service.TestClientService;

@RestController
public class TestController_Consumer {

	@Autowired
	private TestClientService testClientService;
	
	@GetMapping("/consumer/test")
	public RespEntity test() {
		RespEntity result = testClientService.test();
		return result;
	}
	
	
}
