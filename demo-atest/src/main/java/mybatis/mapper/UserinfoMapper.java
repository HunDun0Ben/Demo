package mybatis.mapper;

import mybatis.entity.Userinfo;
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
    Userinfo selectUserinfo();
    Userinfo getById(@Param("id") String id);
}
