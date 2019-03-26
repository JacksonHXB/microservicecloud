package com.hxb.springcloud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hxb.springcloud.entites.RespEntity;
import com.hxb.springcloud.entites.User;
import com.hxb.springcloud.service.UserService;

/*用户控制层*/
@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	/*获取用户列表*/
	@GetMapping("/user/getUsers/{page}")
	public RespEntity getUsers(@PathVariable("page")String page, String size, String sort, String keyword) {
		RespEntity result = userService.getUsers(keyword, page, size, sort);
		return result;
	}
	
	
	/*添加或更新用户
	 * id: 传递，表示更新，不传递，表示添加
	 * */
	@PutMapping("/user/addOrUpdate")
	public RespEntity addOrdUpdateKnowledge(@ModelAttribute("user") User user) {
		System.out.println(user);
		RespEntity result = userService.addOrUpdateUser(user);
		return result;
	}
	
	/*删除用户*/
	@DeleteMapping("/user/del/{id}")
	public RespEntity delKnowledge(@PathVariable("id")String id) {
		RespEntity result = userService.delUser(id);
		return result;
	}
	
	
	
	/*用户登陆*/
//	@PostMapping("/user/login")
//	public User login(String username, String password, HttpSession httpSession){
//		User user = userService.login(username, password);
//		if(user != null){
//			httpSession.setAttribute("currentUser", user);	//将当前用户存入session中
//			if(user.getPassword().equals(password)){//判断和密码是否相等
//				return user;
//			}
//		}
//		return null;
//	}
}












































































