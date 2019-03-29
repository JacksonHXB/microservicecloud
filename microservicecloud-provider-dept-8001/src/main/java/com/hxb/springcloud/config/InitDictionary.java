package com.hxb.springcloud.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.hxb.springcloud.dao.DictDao;
import com.hxb.springcloud.entites.Dictionary;

@Component
@Order(value=1)		//第一优先级启动
public class InitDictionary implements CommandLineRunner{
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private DictDao dictDao;
	
	@Override
	public void run(String... args) throws Exception {
		logger.info("开始加载数据字典");
		Dictionary queryDictWithItems = dictDao.queryDictWithItems(1);
		System.out.println(queryDictWithItems);
		
	}
}
