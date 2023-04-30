package com.diaoyang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.diaoyang.entity.Article;
import com.diaoyang.service.ArticleService;
import com.diaoyang.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

/**
* @author 13038
* @description 针对表【dy_article(文章表)】的数据库操作Service实现
* @createDate 2023-04-25 20:52:13
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService{

}




