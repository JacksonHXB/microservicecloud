package com.hxb.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hxb.springcloud.entites.RespEntity;
import com.hxb.springcloud.service.DictionaryClientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "/consumer", description = "字典操作")
@CrossOrigin(origins = "http://localhost:4000", maxAge = 3600)    //简单的设置跨域请求
public class DictionaryController_Consumer {
	
	@Autowired
	private DictionaryClientService dictionaryClientService;
	
	
	@ApiOperation(value="获取字典及详情列表")
	@RequestMapping(value="/consumer/dict/dictItems", method=RequestMethod.GET)
	public RespEntity getDictsWithDictItems() {
		RespEntity result = dictionaryClientService.getDictsWithDictItems();
		return result;
	}

}























