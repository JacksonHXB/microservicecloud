package com.hxb.springcloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.hxb.springcloud.entites.RespEntity;

@FeignClient(value="MICROSERVICECLOUD-ECONOMY")
public interface TestClientService {

	@GetMapping("/test")
	public RespEntity test();
	
}



































