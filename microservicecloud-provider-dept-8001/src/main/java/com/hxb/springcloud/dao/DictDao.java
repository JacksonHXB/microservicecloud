package com.hxb.springcloud.dao;


import org.apache.ibatis.annotations.Mapper;

import com.hxb.springcloud.entites.Dictionary;

@Mapper
public interface DictDao {

	public Dictionary queryDictWithItems(Integer id);
	
	
}
