package com.zb.user.service;

import java.util.List;

import com.zb.pojo.OrderItem;
import com.zb.pojo.User;
import com.zb.user.dao.CartDao;
import com.zb.vo.CartProductVo;
import com.zb.vo.Page;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;

public class CartService {
 CartDao cartDao = new CartDao();
	

	public int getTotal() {
		return cartDao.getTotal() ;
	}

	public List<CartProductVo> findAllByPage(Page page, User user) {
		return cartDao.findAllByPage(page,user);
	}

	public void add(OrderItem orderItem, User user) throws Exception {
		OrderItem	result=cartDao.findByPid(orderItem.getPid(),user.getUid());
		orderItem.setUid(user.getUid());
	if(null==result)
	{	
		orderItem.setOid("-1");
		orderItem.setOiid(IdUtil.simpleUUID());
		cartDao.add(orderItem);
	}
	else
	{
		orderItem.setNumber(orderItem.getNumber()+result.getNumber());
		cartDao.update(orderItem);
	}
	}

	public void delete(OrderItem orderItem, User user) {
		orderItem.setUid(user.getUid());
		cartDao.delete(orderItem);
		
	}

	public void update(OrderItem orderItem, User user)  {
		orderItem.setUid(user.getUid());
		cartDao.update(orderItem);
		
	}
}
