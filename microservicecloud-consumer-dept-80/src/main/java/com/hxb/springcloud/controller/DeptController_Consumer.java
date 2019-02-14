package com.hxb.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hxb.springcloud.entites.Dept;

@RestController
public class DeptController_Consumer {
	//private static final String REST_URL_PREFIX = "http://localhost:8001";         //直接指定微服务的地址
	private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";   //通过访问微服务名称（通过Eureka）找到该服务

	@Autowired
	private RestTemplate restTemplate;//RestTemplate提供了多种便捷访问远程HTTP服务的方法
	
	/*添加部门*/
	@RequestMapping(value="/consumer/dept/add")
	public boolean add(Dept dept){
		return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add;", dept, Boolean.class);
	}
	
	/*根据ID查询部门*/
	@RequestMapping(value="/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id){
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
	}
	
	/*查询所有部门*/
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/consumer/dept/list")
	public List<Dept> list(){
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
	}
	
	/*测试@EnableDiscoveryClient,消费端可以调用服务发现*/
	@RequestMapping(value="/consumer/dept/discovery")
	public Object discovery(){
		return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery", Object.class);
	}
}





































































