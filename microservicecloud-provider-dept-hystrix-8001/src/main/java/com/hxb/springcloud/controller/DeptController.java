package com.hxb.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hxb.springcloud.entites.Dept;
import com.hxb.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class DeptController {
	
	@Autowired
	private DeptService service;
	
	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping(value="/dept/add",method=RequestMethod.POST)
	public boolean add(@RequestBody Dept dept){
		return service.addDept(dept);
	}
	
	/*服务熔断处理*/
	@RequestMapping(value="/dept/get/{id}", method=RequestMethod.GET)
	//一旦调用服务方法失败并抛出错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
	@HystrixCommand(fallbackMethod = "processHystrix_Get")
	public Dept get(@PathVariable("id") Long id){
		Dept dept = this.service.get(id);
		if(null == dept){
			throw new RuntimeException("该ID:"+ id + "没有对应的信息");
		}
		return dept;
	}
	
	public Dept processHystrix_Get(@PathVariable("id") Long id){
		return new Dept().setDeptno(id).setDname("该ID:"+id+"没有对应的信息@HystrixCommand").setDb_source("MySQL中没有这样的数据库");
	}
	
	@RequestMapping(value="/dept/list", method=RequestMethod.GET)
	public List<Dept> list(){
		return service.list();
	}
	
	/*服务的发现*/
	@RequestMapping(value="/dept/discovery",method=RequestMethod.GET)
	public Object discovery(){
		List<String> list = client.getServices();//获取所有的微服务列表
		System.out.println("client.getServices():"+ list);
		
		List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT"); //获取DEPT部门的微服务
		for(ServiceInstance element: srvList){
			System.out.println(element.getServiceId() + "\t"+element.getHost()+"\t"+element.getPort()+"\t"+element.getUri());
		}
		return this.client;
	}
}
































































