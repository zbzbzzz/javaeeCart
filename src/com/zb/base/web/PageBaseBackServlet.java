package com.zb.base.web;


import java.io.InputStream;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.catalina.connector.Request;

import com.zb.common.service.ProductService;
import com.zb.common.service.SearchService;
import com.zb.pojo.User;
import com.zb.user.service.CartService;
import com.zb.user.service.CommentService;
import com.zb.utill.tools;
import com.zb.vo.Page;

import cn.itcast.commons.CommonUtils;






public abstract class PageBaseBackServlet extends HttpServlet {

	public abstract String add(HttpServletRequest request, HttpServletResponse response, Page page) ;
	public abstract String delete(HttpServletRequest request, HttpServletResponse response, Page page) ;
	public abstract String edit(HttpServletRequest request, HttpServletResponse response, Page page) ;
	public abstract String update(HttpServletRequest request, HttpServletResponse response, Page page) ;
	public abstract String list(HttpServletRequest request, HttpServletResponse response, Page page) ;
	public ProductService productService = new ProductService();
	public CartService cartService = new CartService();
	public CommentService commentService = new CommentService();
	public SearchService searchService = new SearchService();

	
	public void service(HttpServletRequest request, HttpServletResponse response) {
	/*	try {
			
			获取分页信息
			int start= 0;
			int count = 12;
			String type=null;
			try {
				start = Integer.parseInt(request.getParameter("page.start"));
			} catch (Exception e) {
				
			}
			try {
				count = Integer.parseInt(request.getParameter("page.count"));
			} catch (Exception e) {
			}	
			try {
				type=request.getParameter("page.type");
				type = new String(request.getParameter("page.type").getBytes("iso-8859-1"), "utf-8");
				if(type.trim().length()==0)
					type=null;		
			} catch (Exception e) {				
			}		
				*/	
		try {
		     Page page=CommonUtils.toBean(request.getParameterMap(), Page.class);
			if("所有商品".equals(page.getType()))
				page.setType("");
			System.out.println(page.getType()+"++++++++++++++++++++++++++++++++++++++++++++");
			/*根据过滤器切割的字符串判断方法*/		
			/*借助反射，调用对应的方法*/
			String method = (String) request.getAttribute("method");
			Method m = this.getClass().getMethod(method, javax.servlet.http.HttpServletRequest.class,
					javax.servlet.http.HttpServletResponse.class,Page.class);
			String redirect=null;
			try {
				redirect = m.invoke(this,request, response,page).toString();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
			/*根据方法的返回值，进行相应的客户端跳转，服务端跳转，或者仅仅是输出字符串*/
			
		
			if(redirect==null)
				System.out.println("redirect为空");
			else if(redirect.startsWith("@"))
				response.sendRedirect(redirect.substring(1));
			else if(redirect.startsWith("%"))
				response.getWriter().print(redirect.substring(1));
			else
				request.getRequestDispatcher(redirect).forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	 
	

}
