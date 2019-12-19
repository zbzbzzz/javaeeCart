package com.zb.admin.web;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.alibaba.fastjson.JSON;
import com.zb.base.web.AdminBaseServlet;

@WebServlet("/UploadServlet")
public class UploadServlet extends AdminBaseServlet {
	public String image(HttpServletRequest request, HttpServletResponse response) {
		 String filename = null;
	        try {
	            DiskFileItemFactory factory = new DiskFileItemFactory();
	            ServletFileUpload upload = new ServletFileUpload(factory);
	            // 设置上传文件的大小限制为1M
	            factory.setSizeThreshold(1024 * 1024);
	             
	            List items = null;
	            try {
	                items = upload.parseRequest(request);
	            } catch (FileUploadException e) {
	                e.printStackTrace();
	            }
	  
	            Iterator iter = items.iterator();
	            while (iter.hasNext()) {
	                FileItem item = (FileItem) iter.next();
	                if (!item.isFormField()) {
	  
	                    // 根据时间戳创建头像文件
	                    filename = System.currentTimeMillis() + ".jpg";
	                     
	                    //实际环境
	                    String photoFolder =request.getServletContext().getRealPath("upload");
	                     
	                    File file = new File(photoFolder, filename);
	                    if( !file.getParentFile().exists())
	                    file.getParentFile().mkdirs();
	                    
	                    
	                    InputStream inputStream = item.getInputStream();
	                    FileOutputStream fileOutputStream = new FileOutputStream(file);
	                    byte y[] = new byte[1024 * 1024];
	                    int l = 0;
	                    while (-1 != (l = inputStream.read(y))) {
	                    	fileOutputStream.write(y, 0, l);
	                    }
	                    fileOutputStream.close();
	                    
	                    
	                    
	                    //开发环境
	                  /* File f=new File("C:/Users/Administrator/workspace/cart/WebContent/upload",filename);
	                    // 通过item.getInputStream()获取浏览器上传的文件的输入流
	                    InputStream is = item.getInputStream();
	  
	                    // 复制文件
	                    FileOutputStream fos = new FileOutputStream(f);
	                    byte b[] = new byte[1024 * 1024];
	                    int length = 0;
	                    while (-1 != (length = is.read(b))) {
	                        fos.write(b, 0, length);
	                    }
	                    fos.close();*/
	  
	                } else {
	                    System.out.println(item.getFieldName());
	                    String value = item.getString();
	                    value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
	                    System.out.println(value);
	                }
	            }
	             
	          
	            return "%upload/"+filename;
	             
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            return "403";
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            return "403";
	        }
		
	}

}
