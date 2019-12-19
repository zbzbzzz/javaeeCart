package com.zb.admin.dao;

import java.sql.SQLException;
import java.util.List;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sun.org.apache.regexp.internal.recompile;
import com.zb.pojo.User;
import com.zb.vo.UserVo;


import cn.itcast.jdbc.TxQueryRunner;

public class UserManageDao {
	private QueryRunner qr = new TxQueryRunner();

	public List<UserVo> list() {
		try {			
			String sql = "select * from users";
			List<UserVo> list=qr.query(sql, new BeanListHandler<UserVo>(UserVo.class));						
			return list;
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void delete(String uid)throws Exception {
	
		try {			
			String sql = "delete from users where uid=?";
			qr.update(sql,uid);
			 sql = "delete from order_ where uid=?";
			qr.update(sql,uid);
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void update(User user) throws Exception {	
		try {			
			String sql = "update users set name=?,password=?,email=?,rid=? where uid=?";
			Object[]  params = {user.getName(),user.getPassword(),user.getEmail(),user.getRid(),user.getUid()};
			qr.update(sql,params);			
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public boolean check(String email) throws Exception {	
		try {			
			String sql = "select count(*) from where email=?";
			Number number=(Number) qr.query(sql,new ScalarHandler(),email );	
			if(number.intValue()>0)
				return true;
			else
				return false;
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
