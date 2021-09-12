package com.manager.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class ApiKeyFilter implements Filter {

    public static final Logger LOG = LoggerFactory.getLogger(ApiKeyFilter.class);
    private final String API_KEY = "api-key";

    @Value("${server.key}")
    private String serverKey;

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String apiKey = req.getHeader(API_KEY);
        if (apiKey == null|| apiKey.trim().isEmpty()
                || !serverKey.equals(apiKey)) {
            HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
            String errorMessage = String.format("ApiKey %s is not valid ", apiKey);
            httpResponse.sendError(HttpStatus.FORBIDDEN.value(), errorMessage);
            LOG.error(errorMessage + apiKey);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
