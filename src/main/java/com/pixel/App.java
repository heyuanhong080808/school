package com.pixel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;





/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan("com.pixel.basic")
@EntityScan(basePackages = { "com.pixel.basic.model" }) // 扫描数据模型定义
@EnableJpaRepositories(basePackages = { "com.pixel.basic.service" }) // 扫描数据操作
public class App {
    public static void main( String[] args ){
    SpringApplication.run(App.class, args);
        
    }
   
}