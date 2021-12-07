package com.hundun.demo.user.service.facade.impl;

import com.hundun.demo.user.entity.Userinfo;
import com.hundun.demo.user.mapper.UserinfoMapper;
import com.hundun.demo.user.service.facade.IUserinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * users 服务实现类
 * </p>
 *
 * @author Ben
 * @since 2021-12-07
 */
@Service
public class UserinfoServiceImpl extends ServiceImpl<UserinfoMapper, Userinfo> implements IUserinfoService {

}
