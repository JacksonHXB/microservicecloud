package com.hxb.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hxb.springcloud.entites.Knowledge;
import com.hxb.springcloud.entites.RespEntity;
import com.hxb.springcloud.service.KnowledgeClientService;

@RestController
public class KnowledgeController_Consumer {
	
	@Autowired
	private KnowledgeClientService knowledgeClientService;		//通过公共的知识库服务，对Fegin接口进行查询
	
	/*删除知识*/
	@RequestMapping(value="/consumer/knowledge/del/{id}", method=RequestMethod.DELETE)
	public RespEntity delKnowledge(@RequestParam("id") String id) {
		RespEntity result = knowledgeClientService.delKnowledge(id);
		return result;
	}
	
	
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
	@PutMapping("/consumer/knowledge/addOrUpdate")
	public RespEntity addOrdUpdateKnowledge(@ModelAttribute("knowledge") Knowledge knowledge) {
		RespEntity result = knowledgeClientService.addOrUpdate(knowledge);
		return result;
	}
	

}























