package com.zb.admin.web;

import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.zb.base.web.AdminBaseServlet;

@WebServlet("/StatisticsServlet")
public class StatisticsServlet extends AdminBaseServlet {

	public String orderStatistics(HttpServletRequest request, HttpServletResponse response) {
		Map<String, List<Object>> map=statisticsService.orderStatisticsByDate();
		return "%"+JSON.toJSONString(map);
	}
}
