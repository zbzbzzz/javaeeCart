package com.zb.pojo;

import java.util.Date;
import java.util.List;

public class Order {
	String oid;
	String uid;
	double sum;
	int status;
	Date ordertime;
	List<OrderItem> items; 
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	public Order(String uid,String oid,int status,double sum,Date ordertime) {
		// TODO Auto-generated constructor stub
		this.uid=uid;
		this.oid=oid;
		this.status=status;
		this.sum=sum;
		this.ordertime=ordertime;
	}
	
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
	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", uid=" + uid + ", sum=" + sum + ", status=" + status + ", ordertime=" + ordertime
				+ ", items=" + items + "]";
	}
	
	
	

}
