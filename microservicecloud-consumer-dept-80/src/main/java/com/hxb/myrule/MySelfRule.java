package com.hxb.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;

/*这个类不能放在启动类所在的包或者子包下面的位置，因为@ComponetScan会扫描到*/
@Configuration
public class MySelfRule {

	@Bean
	public IRule myRule(){
		//return new RandomRule();  使用随机算法
		return new RandomRule_ZY();  //执行自定义每台机器3次之后再轮询
	}
	
}
