package com.zb.user.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.zb.Exception.CommonException;
import com.zb.common.dao.ProductImgDao;
import com.zb.pojo.OrderItem;
import com.zb.pojo.Product;
import com.zb.pojo.User;
import com.zb.vo.CartProductVo;
import com.zb.vo.Page;

import cn.itcast.jdbc.TxQueryRunner;

public class CartDao {
	private QueryRunner qr = new TxQueryRunner();
	private ProductImgDao productImgDao = new ProductImgDao();
	public int getTotal() {
		try {
			String	sql = "select count(*) from orderitem where oid='-1'";
			Number	number=(Number)qr.query(sql, new ScalarHandler());		
			return  number.intValue();				  
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public List<CartProductVo> findAllByPage(Page page, User user) {
		try {
			String sql="select * from orderitem INNER JOIN products using(pid) where oid='-1' and uid=? limit ?,?";			    
			Object[]  params = {user.getUid(),page.getStart(),page.getCount()};
			List<CartProductVo> list=qr.query(sql, new BeanListHandler<CartProductVo>(CartProductVo.class),params);
			 for(CartProductVo c:list)
			 {
				c.setProductImgs( productImgDao.findById(c.getPid()));
			 }
			return list;
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public OrderItem findByPid(String pid, String uid) throws Exception {
		try {
			String sql="select * from orderitem where oid='-1' and uid=? and pid=?";			    
			Object[]  params = {uid,pid};
			return qr.query(sql, new BeanHandler<OrderItem>(OrderItem.class),params);						
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void add(OrderItem orderItem) throws Exception{
		try {
			String sql = "insert into orderitem values(?,?,?,?,?)";
			Object[] params = {orderItem.getOiid(),orderItem.getOid(),orderItem.getPid(),orderItem.getNumber(),orderItem.getUid()};
			qr.update(sql, params);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public void update(OrderItem orderItem){
		try {
			String sql = "update orderitem set number=? where pid=? and uid=? and oid='-1'";
			Object[] params = {orderItem.getNumber(),orderItem.getPid(),orderItem.getUid()};
			qr.update(sql, params);
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void delete(OrderItem orderItem) {
		try {
			String sql = "delete from orderitem  where pid=? and uid=? and oid='-1'";
			Object[] params = {orderItem.getPid(),orderItem.getUid()};
			qr.update(sql, params);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//创建订单时清空购物车并计算商品价值
	public void clearByOrder(User user,String oid) {
		try {
			String sql = "update orderitem set oid=? where uid=? and oid='-1'";
			Object[] params = {oid,user.getUid()};
			qr.update(sql,params );
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public double sumCart(User user)throws Exception {
		try {
			String sql = "select sum(pnewprice*number) from orderitem JOIN products ON orderitem.pid=products.pid where uid=? and oid='-1'";
			Number number=(Number) qr.query(sql,new ScalarHandler(), user.getUid());
			return number.doubleValue();
		} catch(SQLException e) {
			e.printStackTrace();
			throw new CommonException("购物车无商品！");
		}
	}



}
