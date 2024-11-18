package com.MS_gateway.MS.gateway.config;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GWConfig {
    @Bean
    public GlobalFilter MycustomFilter() {
        return new MyCustomFilter();
    }
}
