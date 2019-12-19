package com.zb.vo;

public class UserVo {
	
	private String uid;
	private String name;
	private String email;
	private int rid;
	private String password;
	private String role;
	

	public String getPassword() {
	return "密码已加密不可查看";
	}
	public String getRole() {
		switch (this.rid) {
		case 1:
			return "普通用户";			
        case 2:
        	return "管理员";
		default:
			return "普通用户";
		}
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public void setRid(int rid) {
		this.rid = rid;
	}
	@Override
	public String toString() {
		return "UserVo [uid=" + uid + ", name=" + name + ", email=" + email + ", rid=" + rid + ", role=" + getRole() + "]";
	}

	

}
