package com.diaoyang.controller;

import com.diaoyang.common.ResponseResult;
import com.diaoyang.entity.Article;
import com.diaoyang.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author : 重庆车银优
 * @Date : 2023/4/25 21:00
 * @Version : V1.0
 * @Description :
 */
@RestController
@RequestMapping("article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
@GetMapping("/hotArticle")
  public ResponseResult<Article> hotArticleList(){
    return articleService.hotArticleList();

}
@GetMapping("/articleList")
public ResponseResult articleList(Integer pageNum,Integer pageSize,Long categoryId){
    return articleService.articleList(pageNum,pageSize,categoryId);
}
@GetMapping("/{id}")
public ResponseResult getArticleDetail(@PathVariable ("id") Long id){

    return articleService.getArticleDetail(id);
}
}
