package com.zb.pojo;

public class ProductImg {
	String imgid;
	String imgurl;
	Product product;
	
	public ProductImg() {
		// TODO Auto-generated constructor stub
	}
	public ProductImg(String imgid,String imgurl) {
		// TODO Auto-generated constructor stub
		this.imgid=imgid;
		this.imgurl=imgurl;
		
	}
	
	public String getImgid() {
		return imgid;
	}
	public void setImgid(String imgid) {
		this.imgid = imgid;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product products) {
		this.product= product;
	}
	@Override
	public String toString() {
		return "ProductImg [imgid=" + imgid + ", imgurl=" + imgurl + ", product=" + product + "]";
	}
	
	
}
