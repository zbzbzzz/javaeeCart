package com.zb.user.web;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zb.Exception.CommonException;
import com.zb.base.web.BaseServlet;
import com.zb.base.web.PageBaseBackServlet;
import com.zb.pojo.User;
import com.zb.vo.OrderVo;

@WebServlet("/OrderServlet")
public class OrderServlet extends BaseServlet {
	
	public  String list(HttpServletRequest request, HttpServletResponse response) {
		User user=(User)request.getSession().getAttribute("user");
		String oid=request.getParameter("oid");
		try {
			request.setAttribute("CartProduct",orderService.listByOid(user, oid));
			if(null!=request.getParameter("checkout"))
			{
				request.setAttribute("button", "结账");
				request.setAttribute("buttonUrl", "User/Order/checkout?oid="+oid);
				}
			else
			{
				request.setAttribute("button", "返回");
				request.setAttribute("buttonUrl", "User/Account/load");
			}
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		return "user/orderitem.jsp";
	}
   public  String checkout(HttpServletRequest request, HttpServletResponse response) {
		
	   User user=(User)request.getSession().getAttribute("user");
	   String oid=request.getParameter("oid");
		try {
			orderService.checkout(user, oid);
			/*request.setAttribute("success", "结账成功");
			List<OrderVo> list=accountService.findAllOrder(user);
			request.setAttribute("orderlist", list);*/
		} catch (CommonException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		
		return "@../../User/Account/load?success=2";
	}
   
   public  String addOrder(HttpServletRequest request, HttpServletResponse response) {
	   User user=(User)request.getSession().getAttribute("user");
	   try {
		orderService.add(user);
		/*List<OrderVo> list=accountService.findAllOrder(user);
		request.setAttribute("orderlist", list);*/
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		request.setAttribute("error", e.getMessage());
		return "user/login.jsp";
	}		 
	  /* request.setAttribute("success", "创建订单成功快去结账吧");*/
		return "@../../User/Account/load?success=1";
	}

}
