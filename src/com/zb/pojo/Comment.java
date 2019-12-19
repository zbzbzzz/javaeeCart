package com.zb.pojo;

public class Comment {
	
	private String coid;
	private String uid;
	private String content;
	private String pid;
	@Override
	public String toString() {
		return "Comment [coid=" + coid + ", uid=" + uid + ", content=" + content + ", pid=" + pid + "]";
	}
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
	

	

}
