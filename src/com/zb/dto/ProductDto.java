package com.zb.dto;

import java.util.Arrays;

public class ProductDto {
	String pid;
	String pname;
	String ptype;
	Double poldprice;
	Double pnewprice;
	int pstarlevel;
	String plabel;
	String pinfo;
	String productImgs;
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
	public String getProductImgs() {
		return productImgs;
	}
	public void setProductImgs(String productImgs) {
		this.productImgs = productImgs;
	}
	@Override
	public String toString() {
		return "ProductDto [pid=" + pid + ", pname=" + pname + ", ptype=" + ptype + ", poldprice=" + poldprice
				+ ", pnewprice=" + pnewprice + ", pstarlevel=" + pstarlevel + ", plabel=" + plabel + ", pinfo=" + pinfo
				+ ", productImgs=" + productImgs + "]";
	}

	
}
