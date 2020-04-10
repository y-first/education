package com.education.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.education.edu.mapper")
@ComponentScan(basePackages = {"com.education"})
@EnableDiscoveryClient
@EnableFeignClients
public class TeacherApplication {
    public static void main(String[] args) {
        SpringApplication.run(TeacherApplication.class,args);
    }
}
