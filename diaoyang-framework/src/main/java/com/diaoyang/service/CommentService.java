package com.diaoyang.service;

import com.diaoyang.common.ResponseResult;
import com.diaoyang.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 13038
* @description 针对表【dy_comment(评论表)】的数据库操作Service
* @createDate 2023-04-29 21:32:35
*/
public interface CommentService extends IService<Comment> {

    ResponseResult commentList(String commentType,Long articleId, Integer pageNum, Integer pageSize);

    ResponseResult addComment(Comment comment);
}
