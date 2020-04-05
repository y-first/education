package com.education.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.education.edu.mapper")
@ComponentScan(basePackages = {"com.education"})
public class TeacherApplication {
    public static void main(String[] args) {
        SpringApplication.run(TeacherApplication.class,args);
    }
}
