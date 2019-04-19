package com.qfedu.shiroadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication // 创建SpringBoot自带的 不要动
@MapperScan("com.qfedu.shiroadmin.dao") // 扫描dao层
@EnableTransactionManagement // 启用事务
public class ShiroadminApplication {

    public static void main(String[] args) {
        SpringApplication.run (ShiroadminApplication.class, args);
    }

}
