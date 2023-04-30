package com.diaoyang.service;

import com.diaoyang.common.ResponseResult;
import com.diaoyang.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 13038
* @description 针对表【dy_category(分类表)】的数据库操作Service
* @createDate 2023-04-26 16:06:48
*/
public interface CategoryService extends IService<Category> {

    ResponseResult getCategoryList();
}
