package com.sk.wagawin.person.util;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ApiLogger extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(ApiLogger.class);

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
            throws Exception {
        final String requestId = UUID.randomUUID().toString();
        log(request, response, requestId);
        final long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        request.setAttribute("requestId", requestId);
        return true;
    }

    @Override
    public void afterCompletion(final HttpServletRequest request, final HttpServletResponse response,
            final Object handler, final Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
        final long startTime = (Long) request.getAttribute("startTime");

        final long endTime = System.currentTimeMillis();

        final long executeTime = endTime - startTime;
        logger.info("requestId {}, Handle :{} , request take time: {}", request.getAttribute("requestId"), handler,
                executeTime);
    }

    private void log(final HttpServletRequest request, final HttpServletResponse response, final String requestId) {
        logger.info("requestId {}, host {}  HttpMethod: {}, URI : {}", requestId, request.getHeader("host"),
                request.getMethod(), request.getRequestURI());
    }
}