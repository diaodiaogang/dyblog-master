package com.diaoyang.service;

import com.diaoyang.common.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author : 重庆车银优
 * @Date : 2023/4/30 19:39
 * @Version : V1.0
 * @Description :
 */
public interface UploadService {
    ResponseResult upload(MultipartFile img);
}
