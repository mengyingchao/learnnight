package com.ypp.springcloud.cfgbeans;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class ConfigBean {//boot -->spring   applicationContext.xml --- @Configuration配置

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}

