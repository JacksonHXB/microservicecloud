package com.hxb.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxb.springcloud.dao.DictDao;
import com.hxb.springcloud.dao.DictItemDao;
import com.hxb.springcloud.entites.DictItem;
import com.hxb.springcloud.entites.Dictionary;
import com.hxb.springcloud.entites.RespEntity;
import com.hxb.springcloud.service.DictService;


@Service
public class DictServiceImpl implements DictService{
	
	@Autowired
	private DictDao dictDao;
	
	@Autowired
	private DictItemDao dictItemDao;


	@Override
	public RespEntity findDictDetail(Integer dictId) {
		List<DictItem> dictItemList = dictItemDao.queryDictItems(dictId);
		System.out.println(dictItemList);
		return null;
	}

	@Override
	public RespEntity getDictWithDictItem(Integer id) {
		Dictionary dict = dictDao.queryDictWithItems(id);
		System.out.println(dict);
		return null;
	}
}
