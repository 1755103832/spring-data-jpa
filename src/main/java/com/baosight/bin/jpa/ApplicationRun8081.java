package com.baosight.bin.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author zyb
 * @Date 2020/7/2
 * @Description
 **/
//@NacosConfigurationProperties(dataId = "nacos-springboot", autoRefreshed = true)
@SpringBootApplication
//@EntityScan(basePackages = "com.aaa.bin.jpa.model")
//@EnableJpaRepositories(basePackages = "com.aaa.bin.jpa.mapper")
public class ApplicationRun8081 {
    //    @NacosConfigListener(dataId = "nacos-springboot")
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun8081.class, args);
    }
}
