package com.hxb.springcloud.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxb.springcloud.dao.DeptDao;
import com.hxb.springcloud.entites.Dept;
import com.hxb.springcloud.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService{
	
	@Autowired
	private DeptDao dao;

	@Override
	public Dept get(Long id) {
		return dao.findById(id);
	}
}












































