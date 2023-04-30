package com.diaoyang.controller;

import com.diaoyang.common.ResponseResult;
import com.diaoyang.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : 重庆车银优
 * @Date : 2023/4/27 12:17
 * @Version : V1.0
 * @Description :
 */
@RestController
@RequestMapping("link")
public class LinkController {
    @Autowired
    private LinkService linkService;

    @GetMapping("/getAllLink")
    public ResponseResult getAllLink(){
        return linkService.getAllLink();
    }
}
