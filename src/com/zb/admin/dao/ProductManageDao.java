package com.zb.admin.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.zb.dto.ProductDto;

import cn.hutool.core.util.IdUtil;
import cn.itcast.jdbc.TxQueryRunner;

public class ProductManageDao {
	private QueryRunner qr = new TxQueryRunner();
	public void addProduct(ProductDto productDto) {
		try {			
			String sql = "insert into products values(?,?,?,?,?,?,?,?)";
			Object[]  params = {productDto.getPid(),productDto.getPtype(),productDto.getPname(),productDto.getPoldprice(),productDto.getPnewprice(),productDto.getPstarlevel(),productDto.getPlabel(),productDto.getPinfo()};
			qr.update(sql,params);			
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	public void addPimg(ProductDto productDto) {
		try {			
			String sql = "insert into pimg values";
			List<Object> list=new ArrayList<Object>();
			String imgurl[]=productDto.getProductImgs().split(",");
			for(String url:imgurl)
			{
				sql += "(?,?,?),";
				list.add(IdUtil.simpleUUID());
				list.add(url);
				list.add(productDto.getPid());
			}
			Object[]  params = list.toArray();
			sql=sql.substring(0, sql.length()-1);
			qr.update(sql,params);			
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void updateProduct(ProductDto productDto) {
		try {			
			String sql = "update products set ptype=?,pname=?,poldprice=?,pnewprice=?,pstarlevel=?,plabel=?,pinfo=? where pid=?";
			Object[]  params = {productDto.getPtype(),productDto.getPname(),productDto.getPoldprice(),productDto.getPnewprice(),productDto.getPstarlevel(),productDto.getPlabel(),productDto.getPinfo(),productDto.getPid()};
			qr.update(sql,params);			
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void updatePimg(ProductDto productDto) {
		try {			
			String sql = "delete from pimg where pid=?";
			qr.update(sql,productDto.getPid());
			addPimg(productDto);
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}		
	}
	public void delete(String pid) {
		try {			
			String sql = "delete from pimg where pid=?";
			qr.update(sql,pid);
			sql="delete from products where pid=?";
			qr.update(sql,pid);
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}		
		
	}

}
