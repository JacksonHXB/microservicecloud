package com.hxb.springcloud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hxb.springcloud.entites.Dept;

import feign.hystrix.FallbackFactory;

/*专门用来处理请求出现异常给用户的返回*/
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>{
	
	
	/*面向切面编程*/
	@Override
	public DeptClientService create(Throwable arg0) {
		return new DeptClientService(){

			@Override
			public Dept get(Long id) {
				return new Dept().setDeptno(id).setDname("该ID:"+id+"客户端服务已经降级").setDb_source("MySQL中没有这样的数据库");
			}

			@Override
			public List<Dept> list() {
				List<Dept> arrList = new ArrayList<Dept>();
				return arrList;
			}

			@Override
			public boolean add(Dept dept) {
				// TODO Auto-generated method stub
				return false;
			}
			
		};
	}

}
