package com.zb.admin.service;

import com.zb.admin.dao.ProductManageDao;
import com.zb.dto.ProductDto;

import cn.hutool.core.util.IdUtil;

public class ProductManageService {
private ProductManageDao productManageDao=new ProductManageDao();
	public void add(ProductDto productDto) {
		productDto.setPid(IdUtil.simpleUUID());
		productManageDao.addProduct(productDto);
		productManageDao.addPimg(productDto);
	}
	public void edit(ProductDto productDto) {
		productManageDao.updateProduct(productDto);
		productManageDao.updatePimg(productDto);
	}
	public void delete(String pid) {
		productManageDao.delete(pid);	
	}

}
