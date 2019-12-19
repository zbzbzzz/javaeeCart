package com.zb.common.dao;



import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sun.org.apache.xerces.internal.impl.dv.dtd.NMTOKENDatatypeValidator;
import com.zb.Exception.CommonException;
import com.zb.pojo.Product;
import com.zb.pojo.ProductImg;
import com.zb.vo.Page;

import cn.itcast.jdbc.TxQueryRunner;




public class ProductDao {
	private QueryRunner qr = new TxQueryRunner();
	private ProductImgDao productImgDao = new ProductImgDao();
	
//查询所有商品数据
public List<Product>  findAll(){
	try {
		String sql = "select * from products";
	    List<Product> list=qr.query(sql, new BeanListHandler<Product>(Product.class));
		 for(Product p:list)
		 {
			p.setProductImgs( productImgDao.findById(p.getPid()));
		 }
		 return list;
	} catch(SQLException e) {
		throw new RuntimeException(e);
	}
}

//分页查询所有商品数据
public List<Product> findAllWithPage(Page page) throws Exception {
	
	try {
		String sql;
		List<Product> list;
		if(null!=page.getType()&&page.getType().trim().length()!=0)
		{
		    sql = "select * from products where ptype=? limit ?,?";
		    Object[]  params = {page.getType(),page.getStart(),page.getCount()};
		    list=qr.query(sql, new BeanListHandler<Product>(Product.class),params);
		}
		else
		{
			sql = "select * from products limit ?,?";
			Object[] params = {page.getStart(),page.getCount()};
			 list=qr.query(sql, new BeanListHandler<Product>(Product.class),params);
		}
		 for(Product p:list)
		 {
			p.setProductImgs( productImgDao.findById(p.getPid()));
		 }
		 return list;
	} catch(SQLException e) {
		throw new RuntimeException(e);
	}
}

//按照种类查询总数
public int getTotalByType(String type) throws Exception {
	try {
		String sql;
		Number number;
		if(null!=type&&type.trim().length()!=0)
		{
		    sql = "select count(*) from products where ptype=?";
		    number=(Number)qr.query(sql, new ScalarHandler(),type);
		}
		else
		{
			sql = "select count(*) from products";
		number=(Number)qr.query(sql, new ScalarHandler());
		}
		return  number.intValue();				  
	} catch(SQLException e) {
		throw new RuntimeException(e);
	}
}

public Product findByPid(String pid) {
	try {
		String sql = "select * from products where pid=?";
	    Product product=qr.query(sql, new BeanHandler<Product>(Product.class),pid);
	    product.setProductImgs( productImgDao.findById(product.getPid()));
		return product;
	} catch(SQLException e) {
		throw new RuntimeException(e);
	}
}



public List<Product> findByKey(String key, Page page) {
	try {
		String sql;
		List<Product> list;
		if(null!=page.getType()&&page.getType().trim().length()!=0)
		{
		    sql = "select * from products where pinfo like ? and ptype=?  limit ?,?";
		    Object[]  params = {"%"+key+"%",page.getType(),page.getStart(),page.getCount()};
		    list=qr.query(sql, new BeanListHandler<Product>(Product.class),params);
		}
		else
		{
			sql = "select * from products where pinfo like ?  limit ?,?";
			Object[] params = {"%"+key+"%",page.getStart(),page.getCount()};
			 list=qr.query(sql, new BeanListHandler<Product>(Product.class),params);
		}
				
		 for(Product p:list)
		 {
			p.setProductImgs( productImgDao.findById(p.getPid()));
		 }
		 return list;
	} catch(SQLException e) {
		throw new RuntimeException(e);
	}
	
	
}

public int getTotalByKey(String key, String type) throws CommonException{

	try {
		String sql;
		Number number;
		if(null!=type&&type.trim().length()!=0)
		{
		    sql = "select count(*) from products where pinfo like ? and ptype=?";
		    Object[] params = {"%"+key+"%",type};
		    number=(Number)qr.query(sql, new ScalarHandler(),params);
		}
		else
		{
			sql = "select count(*) from products where pinfo like ?";
		number=(Number)qr.query(sql, new ScalarHandler(),key);
		}
		return  number.intValue();				  
	} catch(SQLException e) {
		throw new CommonException("暂无此商品");
	}
	
}
	
	  
}
