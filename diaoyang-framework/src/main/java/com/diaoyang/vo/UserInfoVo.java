package com.diaoyang.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author : 重庆车银优
 * @Date : 2023/4/29 0:33
 * @Version : V1.0
 * @Description :
 */
@Data
@Accessors(chain = true)
public class UserInfoVo {
    /**
     * 主键
     */
    private Long id;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String avatar;

    private String sex;

    private String email;
}
