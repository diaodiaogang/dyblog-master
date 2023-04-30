package com.diaoyang.service;

import com.diaoyang.common.ResponseResult;
import com.diaoyang.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 13038
* @description 针对表【sys_user(用户表)】的数据库操作Service
* @createDate 2023-04-29 21:34:39
*/
public interface UserService extends IService<User> {

    ResponseResult userInfo();
}
