package com.findeng;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * SpringBoot入口
 *
 * @author Alien
 */
@SpringBootApplication
@EnableScheduling
@PropertySource("classpath:file-path.properties")
public class Application {

    public static ApplicationContext applicationContext;

    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        applicationContext = app.run(args);
        System.out.println("SpringBoot启动成功!!");
    }

}