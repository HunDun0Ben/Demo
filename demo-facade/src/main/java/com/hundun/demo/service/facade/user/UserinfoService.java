package com.hundun.demo.service.facade.user;

import com.hundun.demo.entity.user.entity.Userinfo;

/**
 * <p>
 * users 服务类
 * </p>
 *
 * @author Ben
 * @since 2021-12-07
 */
public interface UserinfoService {

    Userinfo getById(String id);
}
