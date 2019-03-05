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
import com.hxb.springcloud.service.KnowledgeService;

@RestController
public class KnowledgeController {
	
	@Autowired
	KnowledgeService knowledgeService;
	
	/*添加或更新知识
	 * id: 传递，表示更新，不传递，表示添加
	 * */
	@PutMapping("/knowledge/addOrUpdate")
	public RespEntity addOrdUpdateKnowledge(@ModelAttribute("knowledge") Knowledge knowledge) {
		RespEntity result = knowledgeService.addOrUpdate(knowledge);
		return result;
	}
	
	/*删除知识*/
	@DeleteMapping("/knowledge/del/{id}")
	public RespEntity delKnowledge(@PathVariable("id")String id) {
		RespEntity result = knowledgeService.delKnowledge(id);
		return result;
	}
	
	
	/*查询知识
	 * page: 当前页数
	 * size: 显示条数
	 * sort: 排序字段
	 * key: 搜索的关键字(传递则表示模糊查询，不传递表示普通查询)
	 * */
	@GetMapping("/knowledge/search/{page}")
	public RespEntity getKnowledges(@PathVariable("page")String page, String size, String sort, String keyword) {
		RespEntity result = knowledgeService.getKnowledges(keyword, page, size, sort);
		return result;
	}
	
	
}




































