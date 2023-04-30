package com.diaoyang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.diaoyang.common.ResponseResult;
import com.diaoyang.entity.Link;
import com.diaoyang.service.LinkService;
import com.diaoyang.mapper.LinkMapper;
import com.diaoyang.utils.BeanCopyUtils;
import com.diaoyang.utils.SystemConstants;
import com.diaoyang.vo.LinkVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author 13038
* @description 针对表【dy_link(友链)】的数据库操作Service实现
* @createDate 2023-04-27 12:18:52
*/
@Service
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link>
    implements LinkService{

    @Override
    public ResponseResult getAllLink() {
        //查询所有审核通过的
        LambdaQueryWrapper<Link> linkLambdaQueryWrapper = new LambdaQueryWrapper<>();
        linkLambdaQueryWrapper.eq(Link::getStatus, SystemConstants.LINK_STATUS_NORMAL);
        List<Link> list = list(linkLambdaQueryWrapper);
        //转换成vo
        List<LinkVO> links = BeanCopyUtils.copyBeanList(list, LinkVO.class);

        //封装返回
        return ResponseResult.okResult(links);
    }
}




