package com.diaoyang.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Author : 重庆车银优
 * @Date : 2023/4/27 11:14
 * @Version : V1.0
 * @Description :
 */
@Data
public class ArticleListVo {
    private Long id;
    //标题
    private String title;
    //文章摘要
    private String summary;
    //所属分类名
    private String categoryName;
    //缩略图
    private String thumbnail;


    //访问量
    private Long viewCount;

    private Date createTime;
}
