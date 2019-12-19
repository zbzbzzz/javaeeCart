package com.zb.admin.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.zb.base.web.AdminBaseServlet;
import com.zb.pojo.User;
import com.zb.vo.UserVo;

import cn.itcast.commons.CommonUtils;

@WebServlet("/UserManageServlet")
public class UserManageServlet extends AdminBaseServlet {
	 public String add(HttpServletRequest request, HttpServletResponse response) {
		 User user=	CommonUtils.toBean(request.getParameterMap(), User.class);
			try {
				userManageService.add(user);
			}catch (Exception e) {
				e.printStackTrace();			
				return "403";			
			}
			return "%添加成功";
	}
	 public String edit(HttpServletRequest request, HttpServletResponse response) {
		 User user=	CommonUtils.toBean(request.getParameterMap(), User.class);
		 String oldemail=request.getParameter("oldemail");
			try {
				userManageService.update(user,oldemail);
			}catch (Exception e) {
				e.printStackTrace();			
				return "403";			
			}
			return "%修改成功";
	}

	 public String list(HttpServletRequest request, HttpServletResponse response){
		 List<UserVo> list;
		 try {
				 list=userManageService.list();
			}catch (Exception e) {
				e.printStackTrace();			
				return "403";			
			}
		 return "%"+JSON.toJSONString(list);
		 
	 }
	 public String delete(HttpServletRequest request, HttpServletResponse response){
		 String uid=request.getParameter("uid");
		 try {
			 userManageService.delete(uid);
			}catch (Exception e) {
				e.printStackTrace();			
				return "403";			
			}
		 return "%删除成功";
		 
	 }
	 
}
