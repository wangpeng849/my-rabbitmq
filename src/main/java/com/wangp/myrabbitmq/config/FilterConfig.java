package com.wangp.myrabbitmq.config;

import com.wangp.myrabbitmq.filer.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean registFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new MyFilter());
        bean.addUrlPatterns("/filter/*");
        bean.setName("myFilter");
        bean.setOrder(1);
        return bean;
    }
}
