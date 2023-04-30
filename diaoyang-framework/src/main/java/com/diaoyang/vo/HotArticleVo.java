package com.diaoyang.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author : 重庆车银优
 * @Date : 2023/4/26 15:24
 * @Version : V1.0
 * @Description : 返回前端热门文章结果
 */
@Data
public class HotArticleVo implements Serializable {
    private Long id;
    //标题
    private String title;

    //访问量
    private Long viewCount;
}
