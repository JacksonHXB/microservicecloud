package com.hxb.myrule;

import java.util.List;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

/*轮询，每访问三次轮询一次,自定义负载均衡算法*/
public class RandomRule_ZY extends AbstractLoadBalancerRule{
	
	private int total = 0;
	private int currentIndex = 0;
	
	public Server choose(ILoadBalancer lb, Object key){
		if(lb == null){
			return null;
		}
		Server server = null;
		
		while(server == null){
			if(Thread.interrupted()){
				return null;
			}
			List<Server> upList = lb.getReachableServers();//获取可用的机器列表
			List<Server> alList = lb.getAllServers();
			
			int serverCount = alList.size();
			if(serverCount == 0){
				return null;
			}
			
			if(total < 3){
				server = upList.get(currentIndex);
				total ++;
			}else{
				total = 0;
				currentIndex ++ ;
				if(currentIndex >= upList.size()){
					currentIndex = 0;
				}
			}
			
			if(server == null){
				Thread.yield();
				continue;
			}
			
			if(server.isAlive()){
				return (server);
			}
			server = null;
			Thread.yield();
		}
		return server;
	}
	
	
	@Override
	public Server choose(Object key) {
		return choose(getLoadBalancer(), key);
	}

	@Override
	public void initWithNiwsConfig(IClientConfig arg0) {}
}





























