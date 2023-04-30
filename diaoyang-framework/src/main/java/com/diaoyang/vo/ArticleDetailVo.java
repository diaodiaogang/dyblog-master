package com.diaoyang.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Author : 重庆车银优
 * @Date : 2023/4/27 11:54
 * @Version : V1.0
 * @Description :
 */
@Data
public class ArticleDetailVo {
    private Long categoryId;
    private String content;
    private Long viewCount;
    private Date createTime;
    private String categoryName;
    private String isComment;
    private String title;
    private Long id;
}
