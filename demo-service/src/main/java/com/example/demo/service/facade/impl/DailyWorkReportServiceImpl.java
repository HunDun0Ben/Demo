package com.example.demo.service.facade.impl;

import com.example.demo.service.facade.DailyWorkReportService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(version = "1.0.0", group = "test", interfaceClass = DailyWorkReportService.class )
public class DailyWorkReportServiceImpl implements DailyWorkReportService {

    @Override
    public String login(String username, String passwd) {

        return null;
    }
}
