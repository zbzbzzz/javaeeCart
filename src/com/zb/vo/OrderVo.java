package com.zb.vo;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderVo {
	private String uid;
	private double sum;
	private int status;
	//status等于1表示在购物车，2表示生成订单未付款，3表示已付款
	private String statusStr;
	private String action;
	private String actionurl;
	private String time;
	private String oid;
	private Timestamp ordertime;
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStatusStr() {
		return this.status<3?"待付款":"付款成功";
	}
	
	public String getAction() {
		return this.status<3?"查看并付款":"查看";
	}
	
	public String getActionurl() {
		return this.status<3?"User/Order/list?checkout=true&oid="+this.oid:"User/Order/list?oid="+this.oid;
	}
	public void setActionurl(String actionurl) {
		this.actionurl = actionurl;
	}
	public String getTime() {
		String string="";
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		string=dateFormat.format(this.ordertime);
		return string ;
	}
	public void setTime(String time) {		
		this.time = time;
	}	
	public void setOrdertime(Timestamp ordertime) {
		this.ordertime = ordertime;
	}
	@Override
	public String toString() {
		return "OrderVo [uid=" + uid + ", sum=" + sum + ", status=" + status + ", statusStr=" + statusStr + ", action="
				+ action + ", actionurl=" + actionurl + ", time=" + time + ", oid=" + oid + ", ordertime=" + ordertime
				+ "]";
	}

	
}
