package com.hxb.springcloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hxb.springcloud.entites.Knowledge;
import com.hxb.springcloud.entites.RespEntity;

//针对MICROSERVICECLOUD-ECONOMY该微服务，进行面向Fegin的接口的编码,  该接口与provider的接口进行对接
@FeignClient(value="MICROSERVICECLOUD-ECONOMY")
public interface KnowledgeClientService {
	
	/*删除知识*/
	@DeleteMapping("/knowledge/del/{id}")
	public RespEntity delKnowledge(String id);
	
	/*查询知识
	 * page: 当前页数
	 * size: 显示条数
	 * sort: 排序字段
	 * key: 搜索的关键字(传递则表示模糊查询，不传递表示普通查询)
	 * */
	@RequestMapping(value="/knowledge/search/{page}", method=RequestMethod.GET)//使用Fegin的时候，需要使用RequestParam
	public RespEntity getKnowledges(
			@RequestParam("page") final String page, 
			@RequestParam("size") final String size, 
			@RequestParam("sort") final String sort, 
			@RequestParam("keyword") final String keyword);
	
	
	/*添加或更新知识
	 * id: 传递，表示更新，不传递，表示添加
	 * */
	@PutMapping("/knowledge/addOrUpdate")
	public RespEntity addOrUpdate(Knowledge knowledge);
}





















