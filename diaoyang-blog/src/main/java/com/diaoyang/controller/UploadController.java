package com.diaoyang.controller;

import com.diaoyang.common.ResponseResult;
import com.diaoyang.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author : 重庆车银优
 * @Date : 2023/4/30 19:39
 * @Version : V1.0
 * @Description :
 */
@RestController
public class UploadController {
    @Autowired
    private UploadService uploadService;

    @PostMapping("/upload")
    public ResponseResult uploadImg(MultipartFile img){
        return uploadService.upload(img);
    }
}
