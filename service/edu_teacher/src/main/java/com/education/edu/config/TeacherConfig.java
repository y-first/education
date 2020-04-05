package com.education.edu.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TeacherConfig {
    //逻辑删除
    @Bean
    public ISqlInjector sqlInjector(){
        return  new LogicSqlInjector();
    }

    //分页插件
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return  new PaginationInterceptor();
    }
}
