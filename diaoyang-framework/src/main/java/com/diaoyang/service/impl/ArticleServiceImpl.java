package com.diaoyang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.diaoyang.common.ResponseResult;
import com.diaoyang.entity.Article;
import com.diaoyang.entity.Category;
import com.diaoyang.service.ArticleService;
import com.diaoyang.mapper.ArticleMapper;

import com.diaoyang.service.CategoryService;
import com.diaoyang.utils.BeanCopyUtils;
import com.diaoyang.utils.SystemConstants;
import com.diaoyang.vo.ArticleDetailVo;
import com.diaoyang.vo.ArticleListVo;
import com.diaoyang.vo.HotArticleVo;
import com.diaoyang.vo.PageVo;
import lombok.extern.slf4j.Slf4j;
import org.jcp.xml.dsig.internal.dom.ApacheData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
* @author 13038
* @description 针对表【dy_article(文章表)】的数据库操作Service实现
* @createDate 2023-04-25 20:53:48
*/
@Slf4j
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService{

    @Autowired
    private CategoryService categoryService;
    @Override
    public ResponseResult hotArticleList() {
        //1.查询热门前十文章并封装返回
        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<>();

        Page<Article> page = new Page(1, 10);
        //2.必须正式文章
        wrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);

        //3.按浏览量排序
        wrapper.orderByAsc(Article::getViewCount);
        Page<Article> articlePage = page(page, wrapper);
        List<Article> records = articlePage.getRecords();
        if (records==null){
            return ResponseResult.queryNull();
        }
        List<HotArticleVo> hotArticleVos = BeanCopyUtils.copyBeanList(records, HotArticleVo.class);

        return ResponseResult.okResult(hotArticleVos);

    }

    @Override
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {
        //查询条件
        LambdaQueryWrapper<Article> articleLambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 如果 有categoryId 就要 查询时要和传入的相同
        articleLambdaQueryWrapper.eq(Objects.nonNull(categoryId)&&categoryId>0,Article::getCategoryId,categoryId);

        // 状态是正式发布的
        articleLambdaQueryWrapper.eq(Article::getStatus,SystemConstants.ARTICLE_STATUS_NORMAL);
        // 对isTop进行降序
        articleLambdaQueryWrapper.orderByDesc(Article::getIsTop);
        //分页查询
        Page<Article> articlePage = new Page<>(pageNum,pageSize);
        page(articlePage,articleLambdaQueryWrapper);

        //查询categoryName
        List<Article> articles = articlePage.getRecords();

         articles.stream().map(article -> article.setCategoryName(categoryService.getById(article.getCategoryId()).getName()))
                .collect(Collectors.toList());


        List<ArticleListVo> articleListVos = BeanCopyUtils.copyBeanList(articles, ArticleListVo.class);
        long total = articlePage.getTotal();
        PageVo pageVo = new PageVo(articleListVos,total);




        //封装查询结果
        return ResponseResult.okResult(pageVo);
    }

    @Override
    public ResponseResult getArticleDetail(Long id) {
        //根据id查询文章
        Article article = getById(id);
//        if (article==null){
//            return ResponseResult.queryNull();
//        }
        //转换成VO
        ArticleDetailVo articleDetailVo = BeanCopyUtils.copyBean(article, ArticleDetailVo.class);
        //根据分类id查询分类名
        String categoryName = categoryService.getById(articleDetailVo.getCategoryId()).getName();
        if (categoryName!=null){
            articleDetailVo.setCategoryName(categoryName);
        }
        //封装响应返回
        return ResponseResult.okResult(articleDetailVo);
    }


}




