package com.diaoyang.service.impl;

import com.alibaba.fastjson.JSON;
import com.diaoyang.common.JwtUtil;
import com.diaoyang.common.ResponseResult;
import com.diaoyang.entity.LoginUser;
import com.diaoyang.entity.User;
import com.diaoyang.service.BlogLoginService;
import com.diaoyang.utils.BeanCopyUtils;
import com.diaoyang.utils.RedisCache;
import com.diaoyang.vo.BlogUserLoginVo;
import com.diaoyang.vo.UserInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.config.ScheduledTaskHolder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.http.SecurityHeaders;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @Author : 重庆车银优
 * @Date : 2023/4/29 0:21
 * @Version : V1.0
 * @Description :
 */
@Slf4j
@Service
public class BlogLoginServiceImpl implements BlogLoginService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //判断是否认证通过
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("用户名或密码错误");
        }
        //获取userid 生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        log.info("jwt==={}",jwt);
        //把用户信息存入redis
//        redisCache.setCacheObject("bloglogin:"+userId,loginUser);
            stringRedisTemplate.opsForValue().set("bloglogin:"+userId, JSON.toJSONString(loginUser),30L, TimeUnit.MINUTES);
        //把token和userinfo封装 返回
        //把User转换成UserInfoVo
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(loginUser.getUser(), UserInfoVo.class);
        BlogUserLoginVo vo = new BlogUserLoginVo(jwt,userInfoVo);
        return ResponseResult.okResult(vo);
    }

    @Override
    public ResponseResult logout() {
        //获取token 解析获取userid
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //获取userid
        LoginUser loginUser =(LoginUser) authentication.getPrincipal();
        Long id = loginUser.getUser().getId();
        //删除redis中的用户信息
        stringRedisTemplate.delete("bloglogin:"+id);
        return ResponseResult.okResult();
    }
}
