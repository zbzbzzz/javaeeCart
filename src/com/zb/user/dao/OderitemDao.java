package com.zb.user.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.zb.Exception.CommonException;
import com.zb.common.dao.ProductImgDao;
import com.zb.vo.CartProductVo;
import com.zb.vo.OrderItemVo;

import cn.itcast.jdbc.TxQueryRunner;

public class OderitemDao {
	private QueryRunner qr = new TxQueryRunner();
	private ProductImgDao productImgDao=new ProductImgDao();

	public List<OrderItemVo> listByOid(String uid, String oid) throws CommonException{
		try {
			String sql="select * from orderitem INNER JOIN products using(pid) where oid=? and uid=?";			    
			Object[]  params = {oid,uid};
			List<OrderItemVo> list=qr.query(sql, new BeanListHandler<OrderItemVo>(OrderItemVo.class),params);
			 for(OrderItemVo c:list)
			 {
				c.setProductImgs( productImgDao.findById(c.getPid()));
			 }
			return list;
		} catch(SQLException e) {
			e.printStackTrace();
			throw new CommonException("获取数据异常");
		}
	}
}
