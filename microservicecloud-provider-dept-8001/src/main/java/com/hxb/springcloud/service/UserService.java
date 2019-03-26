package com.hxb.springcloud.service;


import com.hxb.springcloud.entites.RespEntity;
import com.hxb.springcloud.entites.User;

public interface UserService {
	
	/*用户登陆*/
	public User login(String username, String password);
	
	/*获取用户列表*/
	public RespEntity getUsers(String keyword, String page, String size, String sort);
	
	/*删除用户*/
	public RespEntity delUser(String id);
	
	/*添加或者是更新用户*/
	public RespEntity addOrUpdateUser(User user);
	
}
