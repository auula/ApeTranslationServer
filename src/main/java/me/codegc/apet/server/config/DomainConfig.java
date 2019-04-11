package me.codegc.apet.server.config;

import me.codegc.apet.server.Interceptor.DomainInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: Ding / 2019-03-23 17:28
 * @version: V1.0
 * @TODO: 白名单域名配置
 * <p>
 * <a href="https://codegc.me">to see Blog</a>
 * <a href="https://github.com/JDode">to see Github</a>
 * </p>
 */
@Configuration
public class DomainConfig implements WebMvcConfigurer {

    @Bean
    public DomainInterceptor domainInterceptor() {
        return new DomainInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(domainInterceptor()).addPathPatterns("/**");
    }
}
