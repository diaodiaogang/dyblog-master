package com.diaoyang.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author : 重庆车银优
 * @Date : 2023/4/27 11:14
 * @Version : V1.0
 * @Description :
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVo {
    private List rows;
    private Long total;


}
