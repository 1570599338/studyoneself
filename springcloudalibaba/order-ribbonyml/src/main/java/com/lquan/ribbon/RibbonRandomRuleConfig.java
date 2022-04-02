package com.lquan.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springcloudalibaba
 * @description: 随机策略
 * @author: lquan
 * @create: 2022-04-02 17:34
 **/
@Configuration
public class RibbonRandomRuleConfig {

    @Bean
    public IRule iRule(){

        return  new RandomRule();
    }


}
