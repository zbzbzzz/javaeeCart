package com.zb.vo;

import java.util.List;

import com.zb.pojo.ProductImg;

public class CartProductVo {
	 private String pid;
	 private int number;
	 private String pname;
	 private	String ptype;
	 private	Double poldprice;
	 private	Double pnewprice;
	 private	int pstarlevel;
	 private	String plabel;
	 private	String pinfo;
	 private	List<ProductImg> productImgs;
	 
	 
	public String getPid() {
		return pid;
	}


	public void setPid(String pid) {
		this.pid = pid;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public String getPtype() {
		return ptype;
	}


	public void setPtype(String ptype) {
		this.ptype = ptype;
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


	public List<ProductImg> getProductImgs() {
		return productImgs;
	}


	public void setProductImgs(List<ProductImg> productImgs) {
		this.productImgs = productImgs;
	}


	@Override
	public String toString() {
		return "CartProductVo [pid=" + pid + ", number=" + number + ", pname=" + pname + ", ptype=" + ptype
				+ ", poldprice=" + poldprice + ", pnewprice=" + pnewprice + ", pstarlevel=" + pstarlevel + ", plabel="
				+ plabel + ", pinfo=" + pinfo + ", productImgs=" + productImgs + "]";
	}


	

}
