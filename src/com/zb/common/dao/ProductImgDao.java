package com.zb.common.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zb.pojo.Product;
import com.zb.pojo.ProductImg;

import cn.itcast.jdbc.TxQueryRunner;

public class ProductImgDao {
	private QueryRunner qr = new TxQueryRunner();
	public List<ProductImg> findById(String pid) {
		try {
			String sql = "select * from pimg where pid=?";
			return qr.query(sql, new BeanListHandler<ProductImg>(ProductImg.class),pid);						
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	

}
