package com.diaoyang.service;

import com.diaoyang.common.ResponseResult;
import com.diaoyang.entity.User;

/**
 * @Author : 重庆车银优
 * @Date : 2023/4/29 0:20
 * @Version : V1.0
 * @Description :
 */
public interface BlogLoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}
