package com.hxb.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hxb.springcloud.entites.Knowledge;
import com.hxb.springcloud.entites.RespEntity;
import com.hxb.springcloud.service.KnowledgeClientService;

@RestController
public class KnowledgeController_Consumer {
	
	@Autowired
	private KnowledgeClientService knowledgeService;		//通过公共的知识库服务，对Fegin接口进行查询
	
	@GetMapping(value="/consumer/knowledge/search/{page}")//使用Fegin的时候，需要使用RequestParam
	public RespEntity getKnowledges(@PathVariable("page") String page, String size, String sort, String keyword) {
		RespEntity result = knowledgeService.getKnowledges(keyword, page, size, sort);
		return result;
	}
	
	/*添加或更新知识*/
	@PutMapping("/consumer/knowledge/addOrUpdate")
	public RespEntity addOrdUpdateKnowledge(@ModelAttribute("knowledge") Knowledge knowledge) {
		RespEntity result = knowledgeService.addOrUpdate(knowledge);
		return result;
	}
	
	/*删除知识*/
	@DeleteMapping("/consumer/knowledge/del/{id}")
	public RespEntity delKnowledge(@PathVariable("id")String id) {
		RespEntity result = knowledgeService.delKnowledge(id);
		return result;
	}
}
