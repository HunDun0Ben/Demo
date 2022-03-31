package com.hundun.demo.service.facade.impl.user;

import com.hundun.demo.entity.user.entity.Userinfo;
import com.hundun.demo.entity.user.mapper.UserinfoMapper;
import com.hundun.demo.service.facade.user.UserinfoService;
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
