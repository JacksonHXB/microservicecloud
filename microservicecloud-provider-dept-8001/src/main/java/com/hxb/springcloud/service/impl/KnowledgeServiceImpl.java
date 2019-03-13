package com.hxb.springcloud.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxb.springcloud.dao.KnowledgeDao;
import com.hxb.springcloud.entites.Knowledge;
import com.hxb.springcloud.entites.RespEntity;
import com.hxb.springcloud.service.KnowledgeService;
import com.hxb.springcloud.utils.RespCode;

@Service
public class KnowledgeServiceImpl implements KnowledgeService{
	
	@Autowired
	KnowledgeDao knowledgeDao;

	/*删除知识*/
	@Override
	public RespEntity delKnowledge(String id) {
		Integer result = knowledgeDao.deleteKnowledge(Integer.parseInt(id));
		if(result == 1) {
			return new RespEntity(RespCode.SUCCESS, "删除成功！");
		}
		return new RespEntity(RespCode.SUCCESS, "删除失败！");
	}

	
	/*搜索知识*/
	@Override
	public RespEntity getKnowledges(String key, String page, String size, String sort) {
		List<Knowledge> knowledgeList = new ArrayList<Knowledge>();
		int start = 0;
		int size2 = 0;
		if(key != null) { //模糊查询
			if(size!=null && page!=null) {
				start = Integer.parseInt(page)*Integer.parseInt(size);
				size2 = Integer.parseInt(size);
				//当传递的参数包含page和size时，则使用limit
				 knowledgeList = knowledgeDao.queryAllKnowledge(key, start, size2, sort);
			}else {
				//当传递的参数size=0时，则时查询全部
				knowledgeList = knowledgeDao.queryAllKnowledge(key, 0, 0, sort);
			}
		}else { //查询所有
			if(size!=null && page!=null) {
				start = Integer.parseInt(page)*Integer.parseInt(size);
				size2 = Integer.parseInt(size);
				//当传递的参数包含page和size时，则使用limit
				knowledgeList = knowledgeDao.queryAllKnowledge(null, start, size2, sort);
			}else {
				//当传递的参数size=0时，则时查询全部
				knowledgeList = knowledgeDao.queryAllKnowledge(null, 0, 0, sort);
			}
		}
		return new RespEntity(RespCode.SUCCESS, knowledgeList);
	}

	/*添加或更新知识*/
	@Override
	public RespEntity addOrUpdate(Knowledge knowledge) {
		/*添加知识*/
		if(knowledge.getId() == null) {
			//将java时间转为sql的时间戳
//			Timestamp time =  new Timestamp((new Date()).getTime());
			//将sql的时间戳转为JAVA的时间
			Timestamp time = new Timestamp(System.currentTimeMillis());
			Date currentTime = new Date(time.getTime());
			
			knowledge.setTime(currentTime);
			knowledgeDao.insertKnowledge(knowledge);					//这里不接收数据
			
			Map<String, String> data = new HashMap<String, String>();
			data.put("id", knowledge.getId().toString());				//根据原有的对象就可以获取被插入的数据ID
			return new RespEntity(RespCode.SUCCESS, data);
		/*更新知识*/
		}else {
			Integer result = knowledgeDao.updateKnowledge(knowledge);
			if(result == 1) {
				return new RespEntity(RespCode.SUCCESS, "更新成功！");
			}
			return new RespEntity(RespCode.SUCCESS, "更新失败！");
		}
	}

}
