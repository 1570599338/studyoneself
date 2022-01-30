package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @program: retire
 * @description: 启动
 * @author: lquan
 * @create: 2022-01-25 15:09
 **/

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class ApiAplication  extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ApiAplication.class, args);


    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApiAplication.class);
    }
}
