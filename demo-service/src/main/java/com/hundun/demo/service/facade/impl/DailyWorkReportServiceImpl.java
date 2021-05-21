package com.hundun.demo.service.facade.impl;

import com.hundun.demo.service.facade.DailyWorkReportService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(version = "1.0.0", group = "test", interfaceClass = DailyWorkReportService.class )
public class DailyWorkReportServiceImpl implements DailyWorkReportService {

    public DailyWorkReportServiceImpl() {
        System.out.println("【DailyWorkReportServiceImpl】Init class is directory java file.");
    }

    @Override
    public String login(String username, String passwd) {

        return null;
    }
}
