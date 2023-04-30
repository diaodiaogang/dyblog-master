package com.diaoyang.utils;

/**
 * @Author : 重庆车银优
 * @Date : 2023/4/26 15:27
 * @Version : V1.0
 * @Description : 字面值处理
 */
public class SystemConstants {
    /**
     *  文章是草稿
     */
    public static final int ARTICLE_STATUS_DRAFT = 1;
    /**
     *  文章是正常分布状态
     */
    public static final int ARTICLE_STATUS_NORMAL = 0;
    /**
     * 判断文章分类状态值
     */
    public static final String STATUS_NORMAL = "0";
    /**
     * 友链状态为审核通过
     */
    public static final String  LINK_STATUS_NORMAL = "0";
    /**
     * 判断跟评论id
     */
    public static final Long ROOT_ID = -1L;


    /**
     * 评论类型为：文章评论
     */
    public static final String ARTICLE_COMMENT = "0";
    /**
     * 评论类型为：友联评论
     */
    public static final String LINK_COMMENT = "1";
}
