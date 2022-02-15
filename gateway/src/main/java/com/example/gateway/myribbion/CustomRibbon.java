package com.example.gateway.myribbion;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;

import java.util.List;

//自定义负载均衡
public class CustomRibbon extends AbstractLoadBalancerRule {

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }

    @Override
    public Server choose(Object key) {
        // TODO Auto-generated method stub
        List<Server> list = this.getLoadBalancer().getReachableServers();

        System.out.println(list);
        // 各种逻辑~~~~
        System.out.println("xxoo");
        return list.get(0);
    }
}
