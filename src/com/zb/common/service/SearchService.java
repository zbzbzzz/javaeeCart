package com.zb.common.service;

import java.util.List;

import com.zb.Exception.CommonException;
import com.zb.common.dao.ProductDao;
import com.zb.pojo.Product;
import com.zb.vo.Page;

public class SearchService  {
	private ProductDao productDao=new ProductDao();
	public List<Product> findByKey(String key,Page page) throws Exception{
		List<Product> list;
			if(null==key||""==key.trim()||key.trim().length()==0)	
			{
			list= productDao.findAllWithPage(page);
			if(list.isEmpty())
				throw new CommonException("暂时没有相关商品！");
			}
			else
			{
				 list=productDao.findByKey(key,page);
				if(list.isEmpty())
					throw new CommonException("暂时没有相关商品！");
			}
			return list;
	
		
	}
	public int getTotalByKey(String key, Page page) throws CommonException {
		int total;
		if(null==key||""==key.trim()||key.trim().length()==0)
			try {
				total=	productDao.getTotalByType(page.getType());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new CommonException("操作异常");
			}
		else
			total=productDao.getTotalByKey(key,page.getType());
		return total;
	}

}
