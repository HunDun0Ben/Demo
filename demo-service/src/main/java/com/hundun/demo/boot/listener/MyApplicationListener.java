package com.hundun.demo.boot.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

@Slf4j
public class MyApplicationListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        log.error("Trigger Application Listener. This through \"spring.factories\" add to Application.\n" +
                "\t[Listener]={}, Application trigger event={}, ", this.getClass().getName(), event);
    }
}
