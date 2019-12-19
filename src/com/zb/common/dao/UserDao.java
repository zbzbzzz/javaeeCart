package com.zb.common.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.zb.pojo.User;

import cn.itcast.jdbc.TxQueryRunner;

public class UserDao {
	private QueryRunner qr = new TxQueryRunner();

	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		try {
			String sql = "select * from users where email=?";
			return qr.query(sql, new BeanHandler<User>(User.class),email);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void add(User user) {
		
		try {
			String sql = "insert into users values(?,?,?,?,?)";
			Object[] params = {user.getUid(), user.getName(), 
					user.getPassword(), user.getEmail(), user.getRid()};
			qr.update(sql, params);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	
	

		
}
