package com.zb.pojo;





public class User  {
	private String uid;
	private String name;
	private String password;
	private String email;
	private int rid;	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String uid,String name,String email) {
		// TODO Auto-generated constructor stub
		this.uid=uid;
		this.name=name;
		this.email=email;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", password=" + password + ", email=" + email + ", rid=" + rid
				+ "]";
	}

	
	 

	 

	    
	  


	

}
