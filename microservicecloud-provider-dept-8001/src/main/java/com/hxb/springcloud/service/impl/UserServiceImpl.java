package com.hxb.springcloud.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxb.springcloud.dao.DictDao;
import com.hxb.springcloud.dao.UserDao;
import com.hxb.springcloud.entites.RespEntity;
import com.hxb.springcloud.entites.User;
import com.hxb.springcloud.service.UserService;
import com.hxb.springcloud.utils.RespCode;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;

	@Autowired
	DictDao dictDao;
	

	/*用户登陆*/
	@Override
	public User login(String username, String password) {	
		List<User> userList = userDao.queryAllUsers(username, 0, 1, null);
		return userList.get(0);
	}

	
	
	
	/*获取用户列表*/
	@Override
	public RespEntity getUsers(String keyword, String page, String size, String sort) {
		System.out.println(page);
		List<User> userList = new ArrayList<User>();
		int start = 0;
		int size2 = 0;
		if(keyword != null) {	//模糊查询
			if(size!=null && page!=null) {
				start = Integer.parseInt(page)*Integer.parseInt(size);
				size2 = Integer.parseInt(size);
				//当传递的参数包含page和size时，则使用limit
				userList = userDao.queryAllUsers(keyword, start, size2, sort);
			}else {
				//当传递的参数size=0时，则时查询全部
				userList = userDao.queryAllUsers(keyword, 0, 0, sort);
			}
		}else { //查询所有
			if(size!=null && page!=null) {
				start = Integer.parseInt(page)*Integer.parseInt(size);
				size2 = Integer.parseInt(size);
				//当传递的参数包含page和size时，则使用limit
				userList = userDao.queryAllUsers(null, start, size2, sort);
			}else {
				//当传递的参数size=0时，则时查询全部
				userList = userDao.queryAllUsers(null, 0, 0, sort);
			}
		}
		return new RespEntity(RespCode.SUCCESS, userList);
	}




	@Override
	public RespEntity delUser(String id) {
		Integer result = userDao.deleteUser(Integer.parseInt(id));
		if(result == 1) {
			return new RespEntity(RespCode.SUCCESS, "删除成功！");
		}
		return new RespEntity(RespCode.SUCCESS, "删除失败！");
	}




	@Override
	public RespEntity addOrUpdateUser(User user) {
		/*添加用户*/
		if(user.getId() == null) {
			//将java时间转为sql的时间戳
//			Timestamp time =  new Timestamp((new Date()).getTime());
			//将sql的时间戳转为JAVA的时间
			Timestamp time = new Timestamp(System.currentTimeMillis());
			Date currentTime = new Date(time.getTime());
			
			user.setBirth(currentTime);
			userDao.insertUser(user);					//这里不接收数据
			
			Map<String, String> data = new HashMap<String, String>();
			data.put("id", user.getId().toString());				//根据原有的对象就可以获取被插入的数据ID
			return new RespEntity(RespCode.SUCCESS, data);
		/*更新用户*/
		}else {
			Integer result = userDao.updateUser(user);
			if(result == 1) {
				return new RespEntity(RespCode.SUCCESS, "更新成功！");
			}
			return new RespEntity(RespCode.SUCCESS, "更新失败！");
		}
	}
}















































