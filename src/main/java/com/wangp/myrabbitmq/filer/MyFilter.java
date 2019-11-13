package com.wangp.myrabbitmq.filer;

import javax.servlet.*;
import java.io.IOException;


/**
 *   此过滤器实现Filter接口
 *   在通过config/FilterConfig进行bean注册
 */
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String message = "Filter......";
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println(message + " Execute cost = "+ (System.currentTimeMillis()-start));
    }

    @Override
    public void destroy() {

    }
}
