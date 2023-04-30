package com.diao.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.util.Date;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

/**
* 文章表
* @TableName dy_article
*/
public class Article implements Serializable {

    /**
    * 
    */
    @NotNull(message="[]不能为空")
    @ApiModelProperty("")
    private Long id;
    /**
    * 标题
    */
    @Size(max= 256,message="编码长度不能超过256")
    @ApiModelProperty("标题")
    @Length(max= 256,message="编码长度不能超过256")
    private String title;
    /**
    * 文章内容
    */
    @Size(max= -1,message="编码长度不能超过-1")
    @ApiModelProperty("文章内容")
    @Length(max= -1,message="编码长度不能超过-1")
    private String content;
    /**
    * 文章摘要
    */
    @Size(max= 1024,message="编码长度不能超过1024")
    @ApiModelProperty("文章摘要")
    @Length(max= 1,024,message="编码长度不能超过1,024")
    private String summary;
    /**
    * 所属分类id
    */
    @ApiModelProperty("所属分类id")
    private Long categoryId;
    /**
    * 缩略图
    */
    @Size(max= 256,message="编码长度不能超过256")
    @ApiModelProperty("缩略图")
    @Length(max= 256,message="编码长度不能超过256")
    private String thumbnail;
    /**
    * 是否置顶（0否，1是）
    */
    @ApiModelProperty("是否置顶（0否，1是）")
    private String isTop;
    /**
    * 状态（0已发布，1草稿）
    */
    @ApiModelProperty("状态（0已发布，1草稿）")
    private String status;
    /**
    * 访问量
    */
    @ApiModelProperty("访问量")
    private Long viewCount;
    /**
    * 是否允许评论 1是，0否
    */
    @ApiModelProperty("是否允许评论 1是，0否")
    private String isComment;
    /**
    * 
    */
    @ApiModelProperty("")
    private Long createBy;
    /**
    * 
    */
    @ApiModelProperty("")
    private Date createTime;
    /**
    * 
    */
    @ApiModelProperty("")
    private Long updateBy;
    /**
    * 
    */
    @ApiModelProperty("")
    private Date updateTime;
    /**
    * 删除标志（0代表未删除，1代表已删除）
    */
    @ApiModelProperty("删除标志（0代表未删除，1代表已删除）")
    private Integer delFlag;

    /**
    * 
    */
    private void setId(Long id){
    this.id = id;
    }

    /**
    * 标题
    */
    private void setTitle(String title){
    this.title = title;
    }

    /**
    * 文章内容
    */
    private void setContent(String content){
    this.content = content;
    }

    /**
    * 文章摘要
    */
    private void setSummary(String summary){
    this.summary = summary;
    }

    /**
    * 所属分类id
    */
    private void setCategoryId(Long categoryId){
    this.categoryId = categoryId;
    }

    /**
    * 缩略图
    */
    private void setThumbnail(String thumbnail){
    this.thumbnail = thumbnail;
    }

    /**
    * 是否置顶（0否，1是）
    */
    private void setIsTop(String isTop){
    this.isTop = isTop;
    }

    /**
    * 状态（0已发布，1草稿）
    */
    private void setStatus(String status){
    this.status = status;
    }

    /**
    * 访问量
    */
    private void setViewCount(Long viewCount){
    this.viewCount = viewCount;
    }

    /**
    * 是否允许评论 1是，0否
    */
    private void setIsComment(String isComment){
    this.isComment = isComment;
    }

    /**
    * 
    */
    private void setCreateBy(Long createBy){
    this.createBy = createBy;
    }

    /**
    * 
    */
    private void setCreateTime(Date createTime){
    this.createTime = createTime;
    }

    /**
    * 
    */
    private void setUpdateBy(Long updateBy){
    this.updateBy = updateBy;
    }

    /**
    * 
    */
    private void setUpdateTime(Date updateTime){
    this.updateTime = updateTime;
    }

    /**
    * 删除标志（0代表未删除，1代表已删除）
    */
    private void setDelFlag(Integer delFlag){
    this.delFlag = delFlag;
    }


    /**
    * 
    */
    private Long getId(){
    return this.id;
    }

    /**
    * 标题
    */
    private String getTitle(){
    return this.title;
    }

    /**
    * 文章内容
    */
    private String getContent(){
    return this.content;
    }

    /**
    * 文章摘要
    */
    private String getSummary(){
    return this.summary;
    }

    /**
    * 所属分类id
    */
    private Long getCategoryId(){
    return this.categoryId;
    }

    /**
    * 缩略图
    */
    private String getThumbnail(){
    return this.thumbnail;
    }

    /**
    * 是否置顶（0否，1是）
    */
    private String getIsTop(){
    return this.isTop;
    }

    /**
    * 状态（0已发布，1草稿）
    */
    private String getStatus(){
    return this.status;
    }

    /**
    * 访问量
    */
    private Long getViewCount(){
    return this.viewCount;
    }

    /**
    * 是否允许评论 1是，0否
    */
    private String getIsComment(){
    return this.isComment;
    }

    /**
    * 
    */
    private Long getCreateBy(){
    return this.createBy;
    }

    /**
    * 
    */
    private Date getCreateTime(){
    return this.createTime;
    }

    /**
    * 
    */
    private Long getUpdateBy(){
    return this.updateBy;
    }

    /**
    * 
    */
    private Date getUpdateTime(){
    return this.updateTime;
    }

    /**
    * 删除标志（0代表未删除，1代表已删除）
    */
    private Integer getDelFlag(){
    return this.delFlag;
    }

}
