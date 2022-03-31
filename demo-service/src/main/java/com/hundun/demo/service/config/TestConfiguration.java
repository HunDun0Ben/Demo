package com.hundun.demo.service.config;

import com.google.common.base.Splitter;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.*;

import java.util.Objects;


@Slf4j
@Configuration
@PropertySource(factory = YamlPropertySourceFactory.class,
        value = "classpath:config/dubbo.yml",
        name = "mars-caller")
public class TestConfiguration {

    @Autowired
    Environment env;

    @Value("${idealx.forgot-change-pin}")
    private String url;
    @Bean
    public UrlPropertiesTable urlPorpertiesTable() {
        Table<String, String, String> table = getTable("idealx.mars.url", "mars-caller");
        log.error("===== {} ==== {}",url, table);
        UrlPropertiesTable urlPropertiesTable = new UrlPropertiesTable();
        urlPropertiesTable.setTable(table);
        return urlPropertiesTable;
    }


    public Table<String, String, String> getTable(String prefix, String name) {
        MutablePropertySources propertySources = ((AbstractEnvironment) env).getPropertySources();
        Table<String, String, String> urlTable = HashBasedTable.create();
        Splitter splitter = Splitter.on('.').trimResults().omitEmptyStrings();
        propertySources.forEach(propertySource -> {
            if(StringUtils.equalsIgnoreCase(propertySource.getName(), name)) {
                MapPropertySource source = (MapPropertySource)propertySource;
                for (String key : source.getPropertyNames()) {
                    if(!key.startsWith(prefix)) {
                        continue;
                    }
                    try {
                        String value = Objects.requireNonNull(source.getProperty(key)).toString();
                        String res = key.substring(prefix.length(), key.length() - 1);
                        Iterable<String> iterable = splitter.split(res);
                        final String[] values = new String[2];
                        int i = 0;
                        while (iterable.iterator().hasNext() && i < 2) {
                            if(i < value.length()) {
                                values[i] = iterable.iterator().next();
                            }
                            i++;
                        }
                        if(i > 2) {
                            continue;
                        }
                        urlTable.put(values[0], values[1], value);
                    } catch (NullPointerException ex) {
                        log.error("Can not find properties key={} on source {}", key, source.getName());
                    }
                }
            }
        });
        return urlTable;
    }

}
