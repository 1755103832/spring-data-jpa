package com.baosight.bin.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author zyb
 * @Date Create in 2020/9/4 15:19
 * @Description
 **/
@Configuration
@EnableSwagger2
public class Swagger2Config {

    private static final String PACKAGE_CONTROLLER_URL = "com.baosight.bin.jpa.controller";

    /**
     * @Author zyb
     * @Description 配置api的详细信息以及api扫描的基础包controller
     * @Datetime 2020/9/4 15:20
     * @Param []
     * @Return springfox.documentation.spring.web.plugins.Docket
     **/
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                // 选择swagger具体生效的接口是什么?(mapper,service,controller)
                .select()
                .apis(RequestHandlerSelectors.basePackage(PACKAGE_CONTROLLER_URL))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * @Author zyb
     * @Description 构建了整个项目的一些描述信息
     * @Datetime 2020/9/4 15:21
     * @Param []
     * @Return springfox.documentation.service.ApiInfo
     **/
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger2")
                .description("接口调试服务")
                .contact(new Contact("zyb", "http://www.baidu.com", "a1755103832@163.com"))
                .version("1.0")
                .build();
    }

}
