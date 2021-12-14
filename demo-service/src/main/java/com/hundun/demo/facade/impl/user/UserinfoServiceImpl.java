package com.hundun.demo.facade.impl.user;

import com.hundun.demo.user.entity.Userinfo;
import com.hundun.demo.user.mapper.UserinfoMapper;
import com.hundun.demo.user.service.facade.UserinfoService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * users 服务实现类
 * </p>
 *
 * @author Ben
 * @since 2021-12-07
 */
@DubboService(version = "1.0.0", group = "test", interfaceClass = UserinfoService.class)
public class UserinfoServiceImpl implements UserinfoService {

    @Autowired
    UserinfoMapper userinfoMapper;

    @Override
    public Userinfo getById(String id) {
        return userinfoMapper.getById(id);
    }
}
