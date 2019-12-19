package com.zb.admin.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.zb.base.web.AdminBaseServlet;
import com.zb.dto.ProductDto;
import com.zb.pojo.Product;
import com.zb.pojo.User;


import cn.itcast.commons.CommonUtils;
@WebServlet("/ProductManageServlet")
public class ProductManageServlet extends AdminBaseServlet {

	public String list(HttpServletRequest request, HttpServletResponse response){
		List<Product> list;
		try {
			list = productService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return "403";
		}
		return "%"+JSON.toJSONString(list);
		
	
	}
	public String add(HttpServletRequest request, HttpServletResponse response){
		ProductDto productDto=	CommonUtils.toBean(request.getParameterMap(), ProductDto.class);
		productManageService.add(productDto);
		return "%添加成功";
	
	}
public String edit(HttpServletRequest request, HttpServletResponse response){
		
		ProductDto productDto=	CommonUtils.toBean(request.getParameterMap(), ProductDto.class);
		productManageService.edit(productDto);
		return "%修改成功";
		
	
	}
public String delete(HttpServletRequest request, HttpServletResponse response){
	String pid=request.getParameter("pid");
	productManageService.delete(pid);
	return "%删除成功";
	

}
}
