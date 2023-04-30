package com.diaoyang.service;

import com.diaoyang.common.ResponseResult;
import com.diaoyang.entity.Link;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 13038
* @description 针对表【dy_link(友链)】的数据库操作Service
* @createDate 2023-04-27 12:18:53
*/
public interface LinkService extends IService<Link> {

    ResponseResult getAllLink();
}
