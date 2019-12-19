package com.zb.admin.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import cn.itcast.jdbc.TxQueryRunner;

public class StatisticsDao {
	private QueryRunner qr = new TxQueryRunner();
	public  Map<String, List<Object>> OrderStatisticsByDate(){
		try {
			Map<String, List<Object>> map = new HashMap<String, List<Object>>();
			String sql = "SELECT DATE_FORMAT(ordertime,'%Y-%m-%d') odate,COUNT(DISTINCT oid) osum FROM order_ WHERE oid!='-1' and TO_DAYS( NOW( ) ) - TO_DAYS(ordertime) < 30 GROUP BY TO_DAYS(ordertime)";
			List<Object> list=qr.query(sql, new ColumnListHandler(1));
			map.put("date", list);
			list=qr.query(sql, new ColumnListHandler(2));
			map.put("sum", list);
			
			return map;
		} catch(SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
