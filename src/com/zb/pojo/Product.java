package com.zb.pojo;

import java.util.List;

public class Product {
	String pid;
	String pname;
	String ptype;
	Double poldprice;
	Double pnewprice;
	int pstarlevel;
	String plabel;
	String pinfo;
	List<ProductImg> productImgs;
	
	 public Product() {
		// TODO Auto-generated constructor stub
	}
	 public Product(String pid,String pname,String ptype,Double poldprice,Double pnewprice,int pstarlevel,String plabel,String pinfo) {
			// TODO Auto-generated constructor stub
		 this.pid=pid;
		 this.pname=pname;
		 this.ptype=ptype;
		 this.poldprice=poldprice;
		 this.pnewprice=pnewprice;
		 this.pstarlevel=pstarlevel;
		 this.plabel=plabel;
		 this.pinfo=pinfo;
		}
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Double getPoldprice() {
		return poldprice;
	}
	public void setPoldprice(Double poldprice) {
		this.poldprice = poldprice;
	}
	public Double getPnewprice() {
		return pnewprice;
	}
	public void setPnewprice(Double pnewprice) {
		this.pnewprice = pnewprice;
	}
	public int getPstarlevel() {
		return pstarlevel;
	}
	public void setPstarlevel(int pstarlevel) {
		this.pstarlevel = pstarlevel;
	}
	public String getPlabel() {
		return plabel;
	}
	public void setPlabel(String plabel) {
		this.plabel = plabel;
	}
	public String getPinfo() {
		return pinfo;
	}
	public void setPinfo(String pinfo) {
		this.pinfo = pinfo;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public List<ProductImg> getProductImgs() {
		return productImgs;
	}
	public void setProductImgs(List<ProductImg> productImgs) {
		this.productImgs = productImgs;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", ptype=" + ptype + ", poldprice=" + poldprice
				+ ", pnewprice=" + pnewprice + ", pstarlevel=" + pstarlevel + ", plabel=" + plabel + ", pinfo=" + pinfo
				+ ", productImgs=" + productImgs + "]";
	}
	
	
	

}
