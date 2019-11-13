package com.wangp.myrabbitmq.filer;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 *   此过滤器通过 @WebFilter
 *   不再需要Bean
 *   此外需要在启动类加上 @ServletComponetScan，指定扫描的包。
 *
 *
 *   @WebFilter这个注解并没有指定执行顺序的属性，
 *   其执行顺序依赖于Filter的名称，是根据Filter类名（注意不是配置的filter的名字）的字母顺序倒序排列，
 *   并且@WebFilter指定的过滤器优先级都高于FilterRegistrationBean配置的过滤器。
 */
@WebFilter(urlPatterns = "/interceptor/*",filterName = "myFilter2")
public class MyFilter2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String message = "Filter2......";
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println(message + " Execute cost = "+ (System.currentTimeMillis()-start));
    }

    @Override
    public void destroy() {

    }
}
