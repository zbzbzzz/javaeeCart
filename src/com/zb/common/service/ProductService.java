package com.zb.common.service;

import java.util.List;

import com.zb.common.dao.ProductDao;
import com.zb.pojo.Product;
import com.zb.vo.Page;


public class ProductService{
	ProductDao productDao = new ProductDao();

	public List<Product> findAll() {		
		return productDao.findAll();
	}

	public List<Product> findAllWithPage(Page page) throws Exception {
		return productDao.findAllWithPage(page);		
	}

	public int getTotal(String type) {
		return 0;
	}

	public int getTotalByType(String type) throws Exception {
		return productDao.getTotalByType(type);
	}

	public Product findByPid(String pid) {	
		return productDao.findByPid(pid);
	}
	  
}
