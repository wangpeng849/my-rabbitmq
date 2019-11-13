package com.wangp.myrabbitmq.config;

        import com.wangp.myrabbitmq.interceptor.MyInterceptor;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
        import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 继承WebMVCConfigurerAdapter在进行静态资源目录配置的时候我们用到过这个类。
 * 这里我们重写了addInterceptors这个方法，进行拦截器的配置，主要配置项就两个，一个是指定拦截器，第二个是指定拦截的URL。
 */
@Configuration
public class InterceptorConfig extends InterceptorConfigAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
