package com.diaoyang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.diaoyang.entity.Category;
import com.diaoyang.service.CategoryService;
import com.diaoyang.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

/**
* @author 13038
* @description 针对表【dy_category(分类表)】的数据库操作Service实现
* @createDate 2023-04-26 16:05:46
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

}




