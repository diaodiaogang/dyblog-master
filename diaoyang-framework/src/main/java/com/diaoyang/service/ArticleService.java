package com.diaoyang.service;

import com.diaoyang.common.ResponseResult;
import com.diaoyang.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 13038
* @description 针对表【dy_article(文章表)】的数据库操作Service
* @createDate 2023-04-25 20:53:48
*/
public interface ArticleService extends IService<Article> {

    ResponseResult hotArticleList();

    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    ResponseResult getArticleDetail(Long id);
}
