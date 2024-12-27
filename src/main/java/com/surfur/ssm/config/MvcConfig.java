package com.surfur.ssm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(value = "com.surfur.ssm.controller")
@EnableWebMvc // 等价于 <mvc:annotation-driven/>
public class MvcConfig implements WebMvcConfigurer {

    // 1. 默认视图解析器（如果你需要，可以自定义实现逻辑视图）
    // 这里可以省略，Spring MVC 会自动使用默认的视图解析器

    // 2. 放行静态资源配置，等价于 <mvc:default-servlet-handler/>
    /**
     * addResourceHandler：拦截所有请求
     * addResourceLocations：静态资源放行白名单，不交给dispatchServlet进行处理
     * @param registry 注册器
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 配置静态资源路径
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/", "classpath:/public/");
    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

}
