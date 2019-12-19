package com.zb.common.web;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.zb.base.web.PageBaseBackServlet;
import com.zb.pojo.Product;
import com.zb.vo.Page;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class ProductslistServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends PageBaseBackServlet {

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
			request.setAttribute("products", productService.findAllWithPage(page));
			page.setTotal(productService.getTotalByType(page.getType()));
			request.setAttribute("page", page);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "拉商品出库的时候出错了");
			return "user/login.jsp";
		}		
		return "user/allproductlist.jsp";
	}
	
	public String ajaxlist(HttpServletRequest request, HttpServletResponse response, Page page) {
		List<Product> list;
		try {
			list = productService.findAllWithPage(page);
		} catch (Exception e) {
			e.printStackTrace();
			return "%ajax拉商品出库的时候出错了";
		}
		return "%"+JSON.toJSONString(list);
	}
	
	//获取单个商品信息以及评论
	public String get(HttpServletRequest request, HttpServletResponse response, Page page) {
		try {
			String comment=request.getParameter("comment");
			if("true".equals(comment))
				request.setAttribute("success", "成功留下了你的评论！");
			String pid=request.getParameter("pid");
			request.setAttribute("product", productService.findByPid(pid));		
			request.setAttribute("comments", commentService.listByPid(pid));
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "拉商品出库的时候出错了");
			return "user/login.jsp";
		}		
		return "user/single-product.jsp";
	}
	
	
}
