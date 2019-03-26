package com.hxb.springcloud.config;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.hxb.springcloud.dao.DictDao;
import com.hxb.springcloud.entites.DictItem;

@Component("LoadDictionary")
public class LoadDictionary implements ApplicationListener<ContextRefreshedEvent> {
	
	public static HashMap<String, String> dictMap = new HashMap<String, String>();
	
	@Autowired
	DictDao dictDao;
	
	/*当一个ApplicationContext被初始化或刷新触发*/
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		if (event.getApplicationContext().getParent() == null) {//root application context 没有parent，他就是老大.
			List<DictItem> dictItems = dictDao.getDictItems();
			for(DictItem item : dictItems) {
				dictMap.put(item.getValue(), item.getName());
			}
			for(String index: dictMap.keySet()) {
				System.out.println(dictMap.get(index));
			}
		} else {
		    
		}
	}

}
