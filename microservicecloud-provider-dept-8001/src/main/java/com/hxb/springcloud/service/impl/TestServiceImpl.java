package com.hxb.springcloud.service.impl;

import org.springframework.stereotype.Service;

import com.hxb.springcloud.entites.RespEntity;
import com.hxb.springcloud.service.TestService;
import com.hxb.springcloud.utils.RespCode;

@Service
public class TestServiceImpl implements TestService{
	

	@Override
	public RespEntity getUsers() {
		return new RespEntity(RespCode.SUCCESS);
	}

}
