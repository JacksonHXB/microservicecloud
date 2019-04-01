package com.hxb.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hxb.springcloud.entites.RespEntity;
import com.hxb.springcloud.service.DictService;

@RestController
public class DictController {
	
	@Autowired
	DictService dictService;
	
	/*根据字典分类ID，查询字典并携带字典详情*/
	@GetMapping("/dict/{id}")
	public RespEntity getDictWithDictItems(@PathVariable("id") Integer id) {
		return dictService.getDictWithDictItem(id);
	}
	
	/*根据字典分类ID查询字典详情集合*/
	@GetMapping("/dict/dictItems/{dictId}")
	public RespEntity getDictDetail(@PathVariable("dictId")Integer dictId) {
		return dictService.findDictDetail(1);
	}
	
	@GetMapping("/dict/dictItems")
	public RespEntity getDictsWithDictItems() {
		return dictService.getDictsWithItems();
	}
	
}

































