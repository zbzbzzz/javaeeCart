package com.zb.vo;


import com.zb.pojo.User;

public class CommentVo {
	private String coid;
	private String uid;
	private String content;
	private String pid;
	private String name;
	public String getCoid() {
		return coid;
	}
	public void setCoid(String coid) {
		this.coid = coid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "CommentVo [coid=" + coid + ", uid=" + uid + ", content=" + content + ", pid=" + pid + ", name=" + name
				+ "]";
	}
	
	
	
	
}
