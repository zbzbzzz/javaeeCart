package com.zb.admin.service;

import java.util.List;
import java.util.Map;

import com.zb.admin.dao.StatisticsDao;

public class StatisticsService {
private StatisticsDao statisticsDao=new StatisticsDao();
	public Map<String, List<Object>> orderStatisticsByDate() {
		return statisticsDao.OrderStatisticsByDate();
	}

}
