package com.diaoyang.utils;

import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author : 重庆车银优
 * @Date : 2023/4/26 15:30
 * @Version : V1.0
 * @Description : Bean拷贝工具类封装
 */
@Data
public class BeanCopyUtils {

    public static <V> V copyBean(Object o,Class<V> vClass){
        V result = null;
        try {
            result = vClass.newInstance();
            BeanUtils.copyProperties(o,result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static  <O,V> List<V> copyBeanList(List<O> list,Class<V> vClass){
        return list.stream()
                .map(o -> copyBean(o,vClass))
                .collect(Collectors.toList());
    }
}
