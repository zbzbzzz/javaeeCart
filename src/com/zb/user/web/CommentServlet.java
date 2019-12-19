package com.zb.user.web;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.zb.base.web.PageBaseBackServlet;
import com.zb.pojo.Comment;
import com.zb.pojo.User;
import com.zb.vo.CommentVo;
import com.zb.vo.Page;

import cn.itcast.commons.CommonUtils;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends PageBaseBackServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public String add(HttpServletRequest request, HttpServletResponse response, Page page) {
		User user=(User) request.getSession().getAttribute("user");
		Comment comment=CommonUtils.toBean(request.getParameterMap(), Comment.class);
	    comment.setUid(user.getUid());
	    commentService.add(comment);
		return "@../../Common/Product/get?pid="+comment.getPid()+"&comment=true";
	}

	@Override
	public String delete(HttpServletRequest request, HttpServletResponse response, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String edit(HttpServletRequest request, HttpServletResponse response, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(HttpServletRequest request, HttpServletResponse response, Page page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String list(HttpServletRequest request, HttpServletResponse response, Page page) {
	
		return null;
	}
	
	public String ajaxadd(HttpServletRequest request, HttpServletResponse response, Page page) {
		User user=(User) request.getSession().getAttribute("user");
		Comment comment=CommonUtils.toBean(request.getParameterMap(), Comment.class);
	    comment.setUid(user.getUid());
	    commentService.add(comment);
		return "%添加成功";
	}
	
    public String ajaxlist(HttpServletRequest request, HttpServletResponse response, Page page) {
    	List<CommentVo>list=commentService.list();
		return "%"+JSON.toJSONString(list);
	}
    public String ajaxlistByPid(HttpServletRequest request, HttpServletResponse response, Page page) {
    	String pid=request.getParameter("pid");
    	List<CommentVo>list=commentService.listByPid(pid);
		return "%"+JSON.toJSONString(list);
	}
       
   
    
}
