package com.hxb.springcloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hxb.springcloud.entites.RespEntity;


//针对MICROSERVICECLOUD-ECONOMY该微服务，进行面向Fegin的接口的编码,  该接口与provider的接口进行对接
@FeignClient(value="MICROSERVICECLOUD-ECONOMY")
public interface DictionaryClientService {
	
	
	@RequestMapping(value="/dict/dictItems", method=RequestMethod.GET)
	public RespEntity getDictsWithDictItems();

}





















