package com.hundun.demo.web.controller;


import com.hundun.demo.entity.user.entity.Userinfo;
import com.hundun.demo.service.facade.user.UserinfoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * users 前端控制器
 * </p>
 *
 * @author Ben
 * @since 2021-12-07
 */
@RestController
@RequestMapping("/user/userinfo")
public class UserinfoController {

    @DubboReference(version = "1.0.0", group = "test", interfaceClass = UserinfoService.class)
    UserinfoService userinfoService;

    @RequestMapping("/{id}")
    public Userinfo xxx(@PathVariable String id) {
        return userinfoService.getById(id);
    }
}

