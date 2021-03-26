package com.example.demo.web.config.dubbo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = DubboProperties.DUBBO_PREFIX)
@Component
public class DubboProperties {
    public static final String DUBBO_PREFIX = "dubbo";
}
