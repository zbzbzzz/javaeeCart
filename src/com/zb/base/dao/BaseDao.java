package com.zb.base.dao;

import java.util.List;

public interface BaseDao {
	public void add(Object object);
	public void update(Object object);
	public void detele(Object object);
	public List<?> findAll();
	
	//default关键字可在接口中声明一个选择性实现的方法
	default void f(){
		System.out.println("eee");
	}

}
