package com.zb.utill;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

public class tools {
	public static String decodeGet(HttpServletRequest request,String data){
		String result="";
		try {
			result=data==null?"":data;
			if("GET".equals(request.getMethod()))
				result=new String(result.getBytes("iso8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result="";
		}
		return result.trim();
		
	}
	
	
	public static String ajaxresult(String type,String info){
			return "{\""+type+"\":\""+info+"\"}";
	}

}
