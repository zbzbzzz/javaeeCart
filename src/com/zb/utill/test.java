package com.zb.utill;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.zb.admin.dao.StatisticsDao;
import com.zb.admin.dao.UserManageDao;
import com.zb.common.dao.ProductDao;
import com.zb.common.dao.UserDao;
import com.zb.pojo.Comment;
import com.zb.pojo.Product;
import com.zb.pojo.User;
import com.zb.user.dao.CommentDao;
import com.zb.vo.CommentVo;


import cn.hutool.core.bean.BeanUtil;
import cn.itcast.jdbc.TxQueryRunner;
import javafx.beans.binding.BooleanBinding;

public class test {

	@Test
	public void test(){
		
		
		StatisticsDao name = new StatisticsDao();
		Map<String, List<Object>> list=name.OrderStatisticsByDate();
		System.out.println(list);
		String pString=JSON.toJSONString(list);
		System.out.println(pString);
		UserManageDao pDao = new UserManageDao();
		System.out.println(pDao.list());
	}
}
