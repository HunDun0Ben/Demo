package com.hundun.demo.facade.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class MyConverter implements Converter<String, UrlPropertiesTable> {

    public MyConverter() {
        System.out.println("MyConverter");
    }

    @Override
    public UrlPropertiesTable convert(String source) {
        System.out.println(source);
        UrlPropertiesTable a = new UrlPropertiesTable();
        return a;
    }
}
