package com.zb.filter;
 
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.zb.pojo.User;
 
public class UserFilter implements Filter {
 
    @Override
    public void destroy() {
 
    }
 
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        
        String contextPath = request.getServletContext().getContextPath();
		String uri = request.getRequestURI();
		uri = StringUtils.remove(uri, contextPath+"/");
		String servletPath = StringUtils.substringBetween(uri, "/", "/");	
		if (uri.startsWith("Common/")&&!servletPath.equals("Product")&&!servletPath.equals("User")&&!servletPath.equals("Search")) {
			request.setAttribute("warning","不要搞事情");
			request.getRequestDispatcher("/user/login.jsp").forward(request, response);
			return;
		}
		if (uri.startsWith("User/")) {
			if(request.getSession().getAttribute("user")==null)
			{
				if( StringUtils.substringAfterLast(uri, "/").contains("ajax"))
					response.getWriter().println("宁先登录在操作行吗");
				else
				{
					request.setAttribute("warning","宁先登录在操作行吗");
					request.getRequestDispatcher("/user/login.jsp").forward(request, response);
				}
				return;
			}
		}
		if (uri.startsWith("Admin/")&&!"Admin/User/adminlogin".equals(uri)&&!"Admin/Upload/image".equals(uri)) {
			User user=(User)request.getSession().getAttribute("user");
			if(request.getSession().getAttribute("user")==null&&((User)request.getSession().getAttribute("user")).getRid()>1)
				response.setStatus(403);	
		}
       
      
        chain.doFilter(request, response);
    }
 
    @Override
    public void init(FilterConfig arg0) throws ServletException {
 
    }
 
}