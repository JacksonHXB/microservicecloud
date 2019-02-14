package com.hxb.springcloud.service;

import java.util.List;

import com.hxb.springcloud.entites.Dept;

public interface DeptService {
	
	public boolean addDept(Dept dept);
	
	public Dept get(Long id);
	
	public List<Dept> list();
}
