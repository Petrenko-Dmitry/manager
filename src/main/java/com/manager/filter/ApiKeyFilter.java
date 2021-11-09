package com.manager.filter;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class ApiKeyFilter implements Filter {

    public static final Logger LOG = LoggerFactory.getLogger(ApiKeyFilter.class);
    private final String API_KEY = "api-key";
    private ObjectMapper objectMapper = new ObjectMapper();

    @Value("#{'${server.key}'.split(',')}")
    private List<String> apiKeys;

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String path = ((HttpServletRequest) req).getRequestURI();
        /*
        Сделали исключение, чтоб при проверке ключа ходить без ключа.
        */
        if (path.startsWith("/checkApiKey")) {
            filterChain.doFilter(servletRequest, servletResponse); // Just continue chain.
            return;
        }
        String apiKey = req.getHeader(API_KEY);
        if (!checkApiKey(apiKey)) {
            HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
            String errorMessage = String.format("ApiKey %s is not valid ", apiKey);
            httpResponse.sendError(HttpStatus.FORBIDDEN.value(), errorMessage);
            LOG.error(errorMessage + apiKey);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean checkApiKey(String apiKey) throws IOException {
        HttpResponse response = Request.Post("http://localhost:8081/checkApiKey")
                .bodyString(apiKey, ContentType.APPLICATION_JSON)
                .execute()
                .returnResponse();

        return Boolean.parseBoolean(EntityUtils.toString(response.getEntity(), "UTF-8"));
    }

    @Override
    public void destroy() {
    }
}
