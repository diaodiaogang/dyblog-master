package com.diaoyang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.diaoyang.common.ResponseResult;
import com.diaoyang.entity.Article;
import com.diaoyang.entity.Category;
import com.diaoyang.service.ArticleService;
import com.diaoyang.service.CategoryService;
import com.diaoyang.mapper.CategoryMapper;
import com.diaoyang.utils.BeanCopyUtils;
import com.diaoyang.utils.SystemConstants;
import com.diaoyang.vo.CategoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
* @author 13038
* @description 针对表【dy_category(分类表)】的数据库操作Service实现
* @createDate 2023-04-26 16:06:48
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

    @Autowired
    private ArticleService articleService;
    /**
     * 要求只展示发布正式文章的分类
     * 必须是正常状态的分类
     * @return
     */
    @Override
    public ResponseResult getCategoryList() {
        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        List<Article> articleList = articleService.list(wrapper);
        Set<Long> categoryIds = articleList.stream()
                .map(article -> article.getCategoryId())
                .collect(Collectors.toSet());
        List<Category> categories = this.listByIds(categoryIds);
        categories = categories
                .stream().filter(category -> SystemConstants.STATUS_NORMAL.equals(category.getStatus()))
                .collect(Collectors.toList());
//        封装vo
        List<CategoryVO> categoryVOS = BeanCopyUtils.copyBeanList(categories, CategoryVO.class);
        return ResponseResult.okResult(categoryVOS);
    }
}




