package com.hundun.demo.user.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * users
 * </p>
 *
 * @author Ben
 * @since 2021-12-07
 */
@Getter
@Setter
public class Userinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * Email 地址通过验证的时间
     */
    private LocalDateTime emailVerifiedAt;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 微信用户唯一标示码
     */
    private String openid;

    /**
     * 性别 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     */
    private Boolean sex;

    /**
     * 省份 用户个人资料填写的省份
     */
    private String province;

    /**
     * 城市 普通用户个人资料填写的城市
     */
    private String city;

    /**
     * 国家 国家代码
     */
    private String country;

    /**
     * 用户头像 最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，	    0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效
     */
    private String headimgurl;

    /**
     * 是否关注公众号 0是未关注1是已关注
     */
    private Boolean subscribe;

    /**
     * 会员等级id 用户等级id
     */
    private Integer levelId;

    /**
     * 累计充值金额 用户累计充值金额作为提升vip等级的
     */
    private BigDecimal deposit;

    /**
     * 用户手机号 用户手机号
     */
    private String phone;

    /**
     * 是否解封 是否冻结默认0正常1冻结
     */
    private Boolean isFrz;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 更新时间
     */
    private LocalDateTime updatedTime;


}
