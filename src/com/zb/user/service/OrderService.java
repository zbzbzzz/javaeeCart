package com.zb.user.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.zb.Exception.CommonException;
import com.zb.pojo.Order;
import com.zb.pojo.User;
import com.zb.user.dao.CartDao;
import com.zb.user.dao.OderitemDao;
import com.zb.user.dao.OrderDao;
import com.zb.vo.CartProductVo;
import com.zb.vo.OrderItemVo;

import cn.hutool.core.util.IdUtil;
import cn.itcast.jdbc.JdbcUtils;

public class OrderService {
 private OrderDao orderDao=new OrderDao();
 private CartDao cartDao=new CartDao();
 private OderitemDao oderitemDao = new OderitemDao();
	public void add(User user)throws Exception {
		try {
			JdbcUtils.beginTransaction();
			
		double sum=cartDao.sumCart(user);
		Order order=new Order(user.getUid(),IdUtil.simpleUUID(),2,sum,new Date());
		cartDao.clearByOrder(user,order.getOid());
	    orderDao.add(order);
	    
	    JdbcUtils.commitTransaction();
		} catch(Exception e) {
			e.printStackTrace();
			try {
				JdbcUtils.rollbackTransaction();
			} catch (SQLException e1) {
				e.printStackTrace();
			}
			throw new CommonException("出现未知错误了");
		}
	}
	public List<OrderItemVo> listByOid(User user, String oid)throws CommonException {
		return oderitemDao.listByOid(user.getUid(),oid);		
	}
	public void checkout(User user, String oid) throws CommonException{
		orderDao.checkout(user.getUid(),oid);		
	}

}
