package com.zb.pojo;

import java.util.List;

public class OrderItem {
	private String oiid;
	private  String oid;
	private String pid;
	private String uid;
	private int number;

	
	public String getOiid() {
		return oiid;
	}
	public void setOiid(String oiid) {
		this.oiid = oiid;
	}
	
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "OrderItem [oiid=" + oiid + ", oid=" + oid + ", pid=" + pid + ", uid=" + uid + ", number=" + number
				+ "]";
	}
	
	
	
	

	
	
	
}
