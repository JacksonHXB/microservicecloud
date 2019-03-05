package com.hxb.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hxb.springcloud.entites.Knowledge;

@Mapper
public interface KnowledgeDao {

	/*插入知识*/
	public Integer insertKnowledge(Knowledge knowledge);
	
	/*根据关键字分页获取知识列表*/
	public List<Knowledge> queryAllKnowledge(@Param("key")String key, @Param("page")int page, @Param("size")int size, @Param("sort")String sort);
	
	/*删除知识*/
	public Integer deleteKnowledge(Integer id);
	
	/*更新知识*/
	public Integer updateKnowledge(Knowledge knowledge);

}
