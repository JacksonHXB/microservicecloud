package com.hxb.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hxb.springcloud.entites.DictItem;

@Mapper
public interface DictItemDao {
	
	public List<DictItem> queryDictItems(Integer id);
}
