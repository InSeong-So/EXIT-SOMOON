package kr.somoon.somoonshop.webservice.config;

import kr.somoon.somoonshop.webservice.security.LoginAccountHandlerMethodArgumentResolver;
import kr.somoon.somoonshop.webservice.security.OriginAuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public OriginAuthInterceptor originAuthInterceptor(){
        return new OriginAuthInterceptor();
    }

    @Bean
    public LoginAccountHandlerMethodArgumentResolver loginAccountHandlerMethodArgumentResolver(){
        return new LoginAccountHandlerMethodArgumentResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(originAuthInterceptor());
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(loginAccountHandlerMethodArgumentResolver());
    }
}
