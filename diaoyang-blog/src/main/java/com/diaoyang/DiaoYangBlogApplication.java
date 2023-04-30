package com.diaoyang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author : 重庆车银优
 * @Date : 2023/4/25 20:16
 * @Version : V1.0
 * @Description :
 */
@SpringBootApplication
@MapperScan("com.diaoyang.mapper")
public class DiaoYangBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiaoYangBlogApplication.class,args);
        System.out.println("启动成功");
    }
}
