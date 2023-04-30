package com.diaoyang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.diaoyang.common.ResponseResult;
import com.diaoyang.entity.User;
import com.diaoyang.service.UserService;
import com.diaoyang.mapper.UserMapper;
import com.diaoyang.utils.BeanCopyUtils;
import com.diaoyang.utils.SecurityUtils;
import com.diaoyang.vo.UserInfoVo;
import org.springframework.stereotype.Service;

/**
* @author 13038
* @description 针对表【sys_user(用户表)】的数据库操作Service实现
* @createDate 2023-04-29 21:34:39
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Override
    public ResponseResult userInfo() {
        //获取当前用户id
        Long userId = SecurityUtils.getUserId();
        //根据用户id查询用户信息
        User user = getById(userId);
        //封装成UserInfoVo
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(user, UserInfoVo.class);
return ResponseResult.okResult(userInfoVo);
    }
}




