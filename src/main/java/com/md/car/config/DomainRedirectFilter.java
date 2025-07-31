package com.md.car.config;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class DomainRedirectFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpServletResponse httpRes = (HttpServletResponse) response;

        String host = httpReq.getHeader("host");
if ("benzaiten.co.in".equalsIgnoreCase(host)) {
            String target = "https://www.benzaiten.co.in" + httpReq.getRequestURI();
            if (httpReq.getQueryString() != null) {
                target += "?" + httpReq.getQueryString();
            }
            httpRes.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY); // 301
            httpRes.setHeader("Location", target);
            return;
        }

        chain.doFilter(request, response);
    }
}

