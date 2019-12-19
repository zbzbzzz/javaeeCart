package com.zb.user.service;

import java.util.List;

import com.zb.Exception.CommonException;
import com.zb.pojo.User;
import com.zb.user.dao.OrderDao;
import com.zb.vo.OrderVo;

public class AccountService {
private OrderDao orderDao=new OrderDao();
	public List<OrderVo> findAllOrder(User user) throws CommonException {
		return orderDao.findAll(user);
	}

}
