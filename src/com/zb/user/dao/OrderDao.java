package com.zb.user.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zb.Exception.CommonException;
import com.zb.pojo.Order;
import com.zb.pojo.User;
import com.zb.vo.OrderVo;


import cn.itcast.jdbc.TxQueryRunner;

public class OrderDao {
	private QueryRunner qr = new TxQueryRunner();


	public void add(Order order) {
		try {
			String sql = "insert into order_ values(?,?,?,?,?)";
			Timestamp timeStamp = new Timestamp(order.getOrdertime().getTime());
			Object[] params = {order.getStatus(),order.getOid(),order.getUid(),order.getSum(),timeStamp};
			qr.update(sql, params);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}


	public List<OrderVo> findAll(User user) throws CommonException {
		try {
			String sql = "select * from order_ where uid=? and oid !='-1' order by ordertime desc";			
			List<OrderVo> list=	qr.query(sql,new BeanListHandler<OrderVo>(OrderVo.class),user.getUid());
			return list;
		} catch(SQLException e) {
			e.printStackTrace();
			throw new CommonException("数据异常");
		}
	}


	public void checkout(String uid, String oid) throws CommonException {
		try {
			String sql = "update order_ set status=3 where uid=? and oid =?";	
			Object[] params = {uid,oid};
			qr.update(sql,params);
		} catch(SQLException e) {
			e.printStackTrace();
			throw new CommonException("结账异常");
		}
		
	}

}
