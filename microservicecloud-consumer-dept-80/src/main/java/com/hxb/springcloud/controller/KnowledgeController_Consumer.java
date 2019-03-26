package com.hxb.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hxb.springcloud.entites.Knowledge;
import com.hxb.springcloud.entites.RespEntity;
import com.hxb.springcloud.service.KnowledgeClientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "/consumer", description = "知识库操作")
@CrossOrigin(origins = "http://localhost:4000", maxAge = 3600)    //简单的设置跨域请求
public class KnowledgeController_Consumer {
	
	@Autowired
	private KnowledgeClientService knowledgeClientService;		//通过公共的知识库服务，对Fegin接口进行查询
	
	/*删除知识*/
	@RequestMapping(value="/consumer/knowledge/del/{id}", method=RequestMethod.GET)
	public RespEntity delKnowledge(@PathVariable(value="id", required=true) String id) {
		System.out.println(id);
		RespEntity result = knowledgeClientService.delKnowledge(id);
		return result;
	}
	
	
	
	
	@ApiOperation(value="获取知识库列表")
	@ApiImplicitParams({
        @ApiImplicitParam(paramType="path", name = "page", value = "页码", required = false, dataType = "String"),
        @ApiImplicitParam(paramType="query", name = "size", value = "返回条数,当为0时查询全部", required = false, dataType = "String"),
        @ApiImplicitParam(paramType="query", name = "sort", value = "排序", required = false, dataType = "String"),
        @ApiImplicitParam(paramType="query", name = "keywords", value = "关键字", required = false, dataType = "String"),
    })
	@RequestMapping(value="/consumer/knowledge/search/{page}", method=RequestMethod.GET)
	public RespEntity getKnowledges(
			@PathVariable(value="page", required=true) String page, 
			@RequestParam(value="size", required=false) String size, 
			@RequestParam(value="sort", required=false) String sort, 
			@RequestParam(value="keywords", required=false) String keywords) {
		System.out.println(page);
		System.out.println(size);
		System.out.println(sort);
		System.out.println(keywords);
		RespEntity result = knowledgeClientService.getKnowledges(page, size, sort, keywords);
		return result;
	}
	
	
	
	
	/*添加或更新知识*/
	@ApiOperation(value="添加或更新知识")
	@RequestMapping(value="/consumer/knowledge/addOrUpdate", method=RequestMethod.POST)
	public RespEntity addOrdUpdateKnowledge(@RequestBody Knowledge knowledge) {
		RespEntity result = knowledgeClientService.addOrUpdate(knowledge);
		return result;
	}
	

}























