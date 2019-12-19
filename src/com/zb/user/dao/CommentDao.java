package com.zb.user.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zb.base.dao.BaseDao;
import com.zb.pojo.Comment;
import com.zb.pojo.OrderItem;
import com.zb.vo.CommentVo;

import cn.itcast.jdbc.TxQueryRunner;

public class CommentDao implements BaseDao {
	private QueryRunner qr = new TxQueryRunner();
	@Override
	public void add(Object object) {
		try {
			Comment comment=(Comment)object;
			String sql = "insert into comment values(?,?,?,?)";
			Object[] params = {comment.getCoid(),comment.getPid(),comment.getUid(),comment.getContent()};
			qr.update(sql, params);
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detele(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<?> findAll() {
		try {
			String sql="select c.pid,c.uid,c.content,u.name from comment c,users u where c.uid=u.uid";			    
			List<CommentVo> list=qr.query(sql, new BeanListHandler<CommentVo>(CommentVo.class));						
			return list;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<CommentVo> findAllByPid(String pid) {
		try {
			String sql="select c.pid,c.uid,c.content,u.name from comment c,users u where c.uid=u.uid and pid=?";			    
			List<CommentVo> list=qr.query(sql, new BeanListHandler<CommentVo>(CommentVo.class),pid);						
			return list;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}


}
