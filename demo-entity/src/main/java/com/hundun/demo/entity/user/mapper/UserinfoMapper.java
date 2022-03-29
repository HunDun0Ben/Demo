package com.hundun.demo.entity.user.mapper;

import com.hundun.demo.entity.user.entity.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * users Mapper 接口
 * </p>
 *
 * @author Ben
 * @since 2021-12-07
 */
@Mapper
public interface UserinfoMapper {
    Userinfo getById(@Param("id") String id);
}
