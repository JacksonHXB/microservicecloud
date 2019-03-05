package com.hxb.springcloud.dao;


import org.apache.ibatis.annotations.Mapper;

import com.hxb.springcloud.entites.Dept;

@Mapper
public interface DeptDao {
	public Dept findById(Long id);
}
































