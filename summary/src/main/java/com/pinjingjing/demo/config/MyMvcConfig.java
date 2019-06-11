package com.pinjingjing.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.pinjingjing.demo.component.MyLocaleResolver;

// 使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
// @EnableWebMvc
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {



    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // super.addViewControllers(registry);
        // 浏览器发送 /atguiguu 请求来到success
        registry.addViewController("/success").setViewName("success");
    }

    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // springBoot已经做好了静态资源映射
        // registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
        //        .excludePathPatterns("/index.html", "/", "/user/login", "/asserts/**", "/webjars/**");
    }

    // 所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean // 将组件注册在容器
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
            }
        };


        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }


}
