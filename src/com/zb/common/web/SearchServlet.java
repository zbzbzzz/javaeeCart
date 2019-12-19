package com.zb.common.web;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zb.Exception.CommonException;
import com.zb.base.web.PageBaseBackServlet;
import com.zb.pojo.Product;
import com.zb.utill.tools;
import com.zb.vo.Page;
@WebServlet("/SearchServlet")
public class SearchServlet extends PageBaseBackServlet {

	@Override
	public String add(HttpServletRequest request, HttpServletResponse response, Page page) {
		// TODO Auto-generated method stub
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
		try {		
			page.setType(tools.decodeGet(request,page.getType()));
		    String key=tools.decodeGet(request,request.getParameter("key"));
			List<Product> list=searchService.findByKey(key,page);
			page.setTotal(searchService.getTotalByKey(key,page));
			request.setAttribute("products", list);
			request.setAttribute("page", page);
			request.setAttribute("key", key);
		} catch (Exception e) {
			
			e.printStackTrace();
			if(e instanceof CommonException)			
			request.setAttribute("info", e.getMessage());
			else
				request.setAttribute("error", "从仓库拿商品时遇到点问题");
		}
		return "user/search.jsp";
	}

}
