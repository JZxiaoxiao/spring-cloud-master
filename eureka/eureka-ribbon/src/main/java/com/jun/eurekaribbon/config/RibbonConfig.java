package com.jun.eurekaribbon.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 第一种方式（不推荐）
 * 全局配置
 */
//@RibbonClient(configuration = RibbonConfig.DefaultRibbonConfig.class)
public class RibbonConfig {

    //@Configuration
    class DefaultRibbonConfig {
        //@Bean
        public IRule ribbonRule() {
            return new RandomRule();
        }
    }
}
