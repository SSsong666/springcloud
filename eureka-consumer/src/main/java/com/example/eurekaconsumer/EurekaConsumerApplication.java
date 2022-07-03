package com.example.eurekaconsumer;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EurekaConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerApplication.class, args);
    }

    @Bean
    @LoadBalanced
    private static RestTemplate restTemplate(){
        return new RestTemplate();
    }

    //优先级大于配置文件里的配置
    @Bean
    public IRule myRule(){
        //lb的随机策略
        return new RetryRule();
    }
}
