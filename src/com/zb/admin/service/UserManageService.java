package com.zb.admin.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.zb.Exception.CommonException;
import com.zb.admin.dao.UserManageDao;
import com.zb.common.dao.UserDao;
import com.zb.pojo.Order;
import com.zb.pojo.User;
import com.zb.user.dao.OrderDao;
import com.zb.vo.UserVo;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import cn.itcast.jdbc.JdbcUtils;

public class UserManageService {
	private UserManageDao userManageDao=new UserManageDao();
	private UserDao userDao=new UserDao();
	private OrderDao oderDao=new OrderDao();

	public List<UserVo> list() {	
		return userManageDao.list();
	}

	public void delete(String uid)throws Exception {
	userManageDao.delete(uid);
	}

	public void add(User bean)throws Exception {
		User user = userDao.findByEmail(bean.getEmail());
		if (user != null) 
			throw new CommonException("有人和你用了一样的Email");
		else {
			bean.setRid(1);
			bean.setUid(IdUtil.simpleUUID());
			bean.setPassword(SecureUtil.md5(bean.getPassword()));
			try {
			JdbcUtils.beginTransaction();
			
			userDao.add(bean);
			//注册时分配oid为-1且status为1的购物车
			Order order=new Order(bean.getUid(),"-1",1,0,new Date());
			oderDao.add(order);
			
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
	}

	public void update(User bean, String oldemail) throws Exception {
		User user = userDao.findByEmail(bean.getEmail());
		if (!oldemail.equals(bean.getEmail())&&user != null) 
			throw new CommonException("有人和你用了一样的Email");
		else {
		userManageDao.update(bean);		}
	}

}
