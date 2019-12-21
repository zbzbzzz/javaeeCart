package com.zb.filter;


import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CorsFilter implements Filter {
    
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
				HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        // 跨域配置多域名访问
        String [] allowDomain= {"http://localhost:9001","http://www.zbzbzzz.top"}; 
        Set allowedOrigins= new HashSet(Arrays.asList(allowDomain)); 
        String originHeader=((HttpServletRequest) req).getHeader("Origin"); 
        if (allowedOrigins.contains(originHeader)){ 
		response.addHeader("Access-Control-Allow-Origin", originHeader);
        response.addHeader("Access-Control-Allow-Methods", "OPTIONS,GET, POST, PUT, DELETE");
        response.addHeader("Access-Control-Max-Age", "1800");//30 min
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
        }
        if("OPTIONS".equals(request.getMethod()))
        {
        	response.setStatus(200);
        	return;
        }
        filterChain.doFilter(request, response);
		
		
	}

	
}