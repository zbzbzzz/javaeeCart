package com.zb.common.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.sun.javafx.collections.MappingChange.Map;
import com.zb.Exception.CommonException;
import com.zb.base.web.BaseServlet;
import com.zb.common.service.UserService;
import com.zb.pojo.User;
import com.zb.utill.tools;

import cn.hutool.core.bean.BeanUtil;
import cn.itcast.commons.CommonUtils;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {		
public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		User user=	CommonUtils.toBean(request.getParameterMap(), User.class);
        try {			
			request.getSession().setAttribute("user",userService.login(user));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("info", e.getMessage());
			return "user/login.jsp";		
		}
        request.setAttribute("success", "登录成功，开始购物吧");
       return "user/home.jsp";
	}

public String register(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	User user=	CommonUtils.toBean(request.getParameterMap(), User.class);
	try {
		userService.register(user);
	}catch (Exception e) {
		e.printStackTrace();
		request.setAttribute("info", e.getMessage());
		return "user/register.jsp";			
	}
	request.setAttribute("success", "注册成功可以登录了");
	return "user/login.jsp";
	
	
}
public String logout(HttpServletRequest request, HttpServletResponse response) {
	// TODO Auto-generated method stub		
	request.getSession().invalidate();
	request.setAttribute("success", "成功登出了");
	return "user/login.jsp";
}
public String adminlogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	User user=	CommonUtils.toBean(request.getParameterMap(), User.class);
	
    try {	
    	user=userService.login(user);
		request.getSession().setAttribute("user",user);
		System.out.println(user);
		if(user.getRid()>1)
			return "%"+JSON.toJSONString(user);
		else
			return "403";
	} catch (Exception e) {
		e.printStackTrace();
		return "403";
	/*	return "%"+tools.ajaxresult("error", e.getMessage());	*/	
	}
}

}
