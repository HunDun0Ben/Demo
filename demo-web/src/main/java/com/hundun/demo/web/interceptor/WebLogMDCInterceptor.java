package com.hundun.demo.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Logback 中的 MDC (Mapped Diagnostic Context, 映射调试上下文) 中添加映射值。
 * 配合自定义日志格式，提供之后的日志追踪功能。
 *
 * @author Ben.Guo
 */
@Slf4j
public class WebLogMDCInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // PreHandle always enters
        String str = String.valueOf(System.currentTimeMillis());
        MDC.put("MDC", str);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // When Controller has correctly returned, this function will be executed.
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // When preHandle() return is ture, this function will be executed.
        // You can still get the value of the MDC here.
        MDC.clear();
    }
}
