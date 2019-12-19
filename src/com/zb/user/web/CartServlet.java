package com.zb.user.web;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.zb.base.web.PageBaseBackServlet;
import com.zb.pojo.OrderItem;
import com.zb.pojo.User;
import com.zb.user.dao.CartDao;
import com.zb.vo.CartProductVo;
import com.zb.vo.Page;

import cn.hutool.db.Session;
import cn.itcast.commons.CommonUtils;

@WebServlet("/CartServlet")
public class CartServlet extends PageBaseBackServlet {

	@Override
	public String add(HttpServletRequest request, HttpServletResponse response, Page page) {
		return null;
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
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		request.setAttribute("CartProduct",cartService.findAllByPage(page,user));
		page.setTotal(cartService.getTotal());
		request.setAttribute("page", page);
		request.setAttribute("button", "生成订单");
		request.setAttribute("buttonUrl", "User/Order/addOrder");
		return "user/cart.jsp";
	}
	
	public String ajaxlist(HttpServletRequest request, HttpServletResponse response, Page page) {
		User user=(User) request.getSession().getAttribute("user");
		List<CartProductVo> list=cartService.findAllByPage(page,user);		
		return "%"+JSON.toJSONString(list);
	}
	
	public String ajaxadd(HttpServletRequest request, HttpServletResponse response, Page page) {
		try {
			User user=(User) request.getSession().getAttribute("user");
			OrderItem orderItem=	CommonUtils.toBean(request.getParameterMap(), OrderItem.class);
			cartService.add(orderItem,user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "%添加失败";
		}
		return "%添加成功";
	}
	
	public String ajaxdelete(HttpServletRequest request, HttpServletResponse response, Page page) {
		User user=(User) request.getSession().getAttribute("user");
		OrderItem orderItem=	CommonUtils.toBean(request.getParameterMap(), OrderItem.class);
		cartService.delete(orderItem,user);
		return "%删除成功";
	}
	
	public String ajaxupdate(HttpServletRequest request, HttpServletResponse response, Page page) {
		User user=(User) request.getSession().getAttribute("user");
		OrderItem orderItem=	CommonUtils.toBean(request.getParameterMap(), OrderItem.class);
		cartService.update(orderItem,user);
		return "%修改成功";
	}

	

}
