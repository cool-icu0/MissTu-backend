package com.cool.tu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.cool.tu.mapper")
@EnableAsync
@EnableAspectJAutoProxy(exposeProxy = true)
public class MissTuBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(MissTuBackendApplication.class, args);
    }

}
