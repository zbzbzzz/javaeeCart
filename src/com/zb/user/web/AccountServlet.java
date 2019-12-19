package com.zb.user.web;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zb.Exception.CommonException;
import com.zb.base.web.BaseServlet;
import com.zb.pojo.User;
import com.zb.vo.OrderVo;
@WebServlet("/AccountServlet")
public class AccountServlet extends BaseServlet {
	public String load(HttpServletRequest request, HttpServletResponse response){
		User user=(User)request.getSession().getAttribute("user");
		try {
			if(null!=request.getParameter("success")){
			switch (request.getParameter("success")) {
			case "1":
				request.setAttribute("success", "创建订单成功快去结账吧");
				break;
			case "2":request.setAttribute("success", "结账成功");
			    break;
			}}
			List<OrderVo> list=accountService.findAllOrder(user);
			request.setAttribute("orderlist", list);
		} catch (CommonException e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		return "user/my-account.jsp";
	}

}
