package com.hxb.springcloud.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import com.hxb.springcloud.entites.Dictionary;

@Mapper
@CacheConfig(cacheNames="users")
public interface DictDao {

//	@CachePut，指定key，将更新的结果同步到redis中
//　　@CacheEvict，指定key，删除缓存数据，allEntries=true,方法调用后将立即清除缓存
	
	
	@Cacheable(key="#p0")  //@Cacheable将查询结果缓存到redis中，（key="#p0"）指定传入的第一个参数作为redis的key。
	public Dictionary queryDictWithItems(Integer id);
	
	public List<Dictionary> queryDictsWithItems();
	
	
}
