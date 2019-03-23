package me.codegc.apet.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 *  @Author:  Ding / 2019-03-17 09:39
 *  @email：  coding1618@gmail.com
 *  @version: V1.0
 *  @TODO:  swagger配置类
 *  <p>
 *      <a href="https://codegc.me">to see Blog</a>
 *      <a href="https://github.com/JDode">to see Github</a>
 *  </p>
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 指定controller存放的目录路径
                .apis(RequestHandlerSelectors.basePackage("me.codegc.apet.server.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 文档标题
                .title("ApeTranslation API Docs v1.5")
                // 文档描述
                .description("https://github.com/JDode/ApeTranslationServer")
                .termsOfServiceUrl("https://github.com/JDode/ApeTranslationServer")
                .version("v1.5")
                .build();
    }
}
