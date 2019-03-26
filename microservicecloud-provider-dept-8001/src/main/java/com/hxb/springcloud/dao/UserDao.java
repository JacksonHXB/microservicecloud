package com.hxb.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hxb.springcloud.entites.User;

@Mapper
public interface UserDao {
	
	/*查询用户*/
	public List<User> queryAllUsers(@Param("keyword")String keyword, @Param("page")int page, @Param("size")int size, @Param("sort")String sort);
	
	/*删除用户*/
	public Integer deleteUser(Integer id);
	
	/*更新用户*/
	public Integer updateUser(User user);
	
	/*插入用户*/
	public Integer insertUser(User user);
}
