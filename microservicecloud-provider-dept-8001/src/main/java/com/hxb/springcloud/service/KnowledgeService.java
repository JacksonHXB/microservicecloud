package com.hxb.springcloud.service;

import com.hxb.springcloud.entites.Knowledge;
import com.hxb.springcloud.entites.RespEntity;

public interface KnowledgeService {
	
	/*删除知识*/
	public RespEntity delKnowledge(String id);
	
	/*搜索知识*/
	public RespEntity getKnowledges(String key, String page, String size, String sort);
	
	/*添加或者是更新知识*/
	public RespEntity addOrUpdate(Knowledge knowledge);
}
