package com.zxj.config;

import com.zxj.common.utils.Constants;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @program: springs
 * @description: 上传文件
 * @author: zxj
 * @create: 2022-02-14 17:51
 **/
@Configuration
public class UploadConfig implements WebMvcConfigurer {


    /**
     * 将D:\\upload下的文件映射到当前项目/upload/下
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {


        //addResourceHandler()里配置需要映射的文件夹，此处代表映射文件夹user下的所有资源。
        //addResourceLocations()配置文件夹在系统中的路径，使用绝对路径，格式为“file:你的路径”
        registry.addResourceHandler(Constants.headImage+"/**").addResourceLocations("file:"+Constants.avatarPath);
    }

}
