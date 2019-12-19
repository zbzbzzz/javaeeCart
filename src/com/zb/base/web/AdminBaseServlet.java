package com.zb.base.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zb.admin.dao.StatisticsDao;
import com.zb.admin.service.ProductManageService;
import com.zb.admin.service.StatisticsService;
import com.zb.admin.service.UserManageService;
import com.zb.common.service.ProductService;
import com.zb.common.service.UserService;
import com.zb.user.service.AccountService;
import com.zb.user.service.OrderService;
import com.zb.vo.Page;

/**
 * Servlet implementation class BaseServlet
 */
@WebServlet("/AdminBaseServlet")
public class AdminBaseServlet extends HttpServlet { 
public StatisticsService statisticsService=new StatisticsService();
public UserManageService userManageService=new UserManageService();
public ProductService productService = new ProductService();
public ProductManageService productManageService = new ProductManageService();
 @Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		/*根据过滤器切割的字符串判断方法*/		
		/*借助反射，调用对应的方法*/
	 try {
		HttpSession session=request.getSession();
		String method = (String) request.getAttribute("method");
		Method m = this.getClass().getMethod(method, javax.servlet.http.HttpServletRequest.class,
				javax.servlet.http.HttpServletResponse.class);
		String redirect=null;
			
				redirect = m.invoke(this,request, response).toString();			
		
		/*根据方法的返回值，进行相应的客户端跳转，服务端跳转，或者仅仅是输出字符串*/
			
		if(redirect.startsWith("403"))
			response.setStatus(403);
		else if(redirect.startsWith("@"))
			response.sendRedirect(redirect.substring(1));
		else if(redirect.startsWith("%"))
			response.getWriter().print(redirect.substring(1));
		else
			request.getRequestDispatcher(redirect).forward(request, response);
		
	 } catch (Exception e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();		 
	 }		
	}
}
