package com.hxb.springcloud.service.impl;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxb.springcloud.dao.DictDao;
import com.hxb.springcloud.entites.RespEntity;
import com.hxb.springcloud.service.DictService;
import com.hxb.springcloud.utils.RespCode;

@Service
public class DictServiceImpl implements DictService {

	@Autowired
	DictDao dictDao;
	
	@Resource 
//	private RedisTemplate redisTemplate;
	
	@Override
	public RespEntity findAllDicts() {
//		redisTemplate.boundValueOps("name").set("itcast");
//		String str = (String) redisTemplate.boundValueOps("name").get();
//		System.out.println(str);
//
//		List<DictItem> dictItemList = dictDao.getDictItems();
		return new RespEntity(RespCode.SUCCESS, new ArrayList());
	}

}
































