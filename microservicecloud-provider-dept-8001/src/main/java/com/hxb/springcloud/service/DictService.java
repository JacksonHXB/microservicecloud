package com.hxb.springcloud.service;

import com.hxb.springcloud.entites.RespEntity;

public interface DictService {
	public RespEntity getDictWithDictItem(Integer id);			//获取字典类型并携带字典详情
	
	public RespEntity findDictDetail(Integer dictId);		//根据字典类型ID获取字典详情
}
