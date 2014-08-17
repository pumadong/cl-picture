package com.cl.picture.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cl.picture.utils.ConfigUtil;
import com.cl.picture.utils.ImageUtil;


 
/**
 *对其他系统提供的文件上传、删除相关的控制器 
 */

@Controller
public class OpController {
	
	@Autowired
	private ConfigUtil configUtil;

	@RequestMapping("/upload")
    public String upload(HttpServletRequest request,String dt,String no,String url,@RequestParam("uploadFile") MultipartFile uploadFile) throws Exception {
		//文件保存成功后返回对方网站的页面，解决跨域的问题,url

		String resultJson = "{result:'success',message:'文件上传成功！'}";
		
		//判断传入的dt,no是否格式正确
		String regEx = "^\\d{6}$";
		Pattern pat = Pattern.compile(regEx);  
		Matcher mat = pat.matcher(dt);  
		if(!mat.find())
		{
			resultJson = "{result:'fail',message:'不是正确的年份或月份！'}";
            return "redirect:" + url + "?result=" + URLEncoder.encode(resultJson,"UTF-8");
		}
		
		regEx = "^\\d{8}$";
		pat = Pattern.compile(regEx);  
		mat = pat.matcher(no);  
		if(!mat.find())
		{
			resultJson = "{result:'fail',message:'不是正确的商品编号！'}";
            return "redirect:" + url + "?result=" + URLEncoder.encode(resultJson,"UTF-8");
		}
		

		//得到文件名
        String filename=uploadFile.getOriginalFilename();
        
        regEx = "^\\d{8}_[0,1]{1}\\d{1}_[b,o]{1}.\\w+$";
		pat = Pattern.compile(regEx);  
		mat = pat.matcher(filename);  
		if(!mat.find())
		{
			resultJson = "{result:'fail',message:'不是正确的图片格式！'}";
            return "redirect:" + url + "?result=" + URLEncoder.encode(resultJson,"UTF-8");
		}
        
        String ext = FilenameUtils.getExtension(filename).toLowerCase();
        String baseName = FilenameUtils.getBaseName(filename).toLowerCase();
        if(!ext.equals("jpg")
        		&& !ext.equals("png"))
        {
        	resultJson = "{result:'fail',message:'不是正确的图片格式！'}";
            return "redirect:" + url + "?result=" + URLEncoder.encode(resultJson,"UTF-8");
        }
        
        if(StringUtils.isBlank(dt) || StringUtils.isBlank(no) || StringUtils.isBlank(url))
        {
        	resultJson = "{result:'fail',message:'没有传入图片路径！'}";
            return "redirect:" + url + "?result=" + URLEncoder.encode(resultJson,"UTF-8");
        }
        
		if(uploadFile.getSize()>10000000)        
        {
            resultJson = "{result:'fail',message:'文件不能大于10M！'}";
            return "redirect:" + url + "?result=" + URLEncoder.encode(resultJson,"UTF-8");
        }        
        
    	String pathdt = configUtil.getPictureLocation() + dt;
    	File file =new File(pathdt);    
    	if(!file.exists())      
    	{       
       	    Boolean r = file.mkdir();   
       	    if(r)
         	{
       	    	//记录日志
         	} else {
         		//记录日志
         	}
    	}
    	String path = pathdt + File.separator + no;
    	file =new File(path);    
    	if(!file.exists())      
    	{       
       	    Boolean r = file.mkdir();   
       	    if(r)
         	{
    	    	//记录日志
         	} else {
         		//记录日志
         	}
    	}
    	
        if(uploadFile.getSize()>0){                
            try {            	
                SaveFileFromInputStream(uploadFile.getInputStream(),path,filename);
            } catch (IOException e) {
            	resultJson = "{result:'fail',message:'"+e.getMessage()+"'}";
                return "redirect:" + url + "?result=" + URLEncoder.encode(resultJson,"UTF-8");
            }
        }
        else{
        	resultJson = "{result:'fail',message:'上传文件不能为空'}";
            return "redirect:" + url + "?result=" + URLEncoder.encode(resultJson,"UTF-8");
        }
        
        //生成缩略图
        ImageUtil.CreateZoomPicture(path + File.separator + baseName + "." + ext,ext);	

		return "redirect:" + url + "?result=" + URLEncoder.encode(resultJson,"UTF-8");
    }
	
	@RequestMapping("/delete")
    public String delete(HttpServletRequest request,String dt,String no,String url) throws Exception {
		//文件保存成功后返回对方网站的页面，解决跨域的问题,url

		String resultJson = "{result:'success',message:'指定的目录删除成功！'}";
		
		//判断传入的dt,no是否格式正确
		String regEx = "^\\d{6}$";
		Pattern pat = Pattern.compile(regEx);  
		Matcher mat = pat.matcher(dt);  
		if(!mat.find())
		{
			resultJson = "{result:'fail',message:'不是正确的年份或月份！'}";
            return "redirect:" + url + "?result=" + URLEncoder.encode(resultJson,"UTF-8");
		}
		
		regEx = "^\\d{8}$";
		pat = Pattern.compile(regEx);  
		mat = pat.matcher(no);  
		if(!mat.find())
		{
			resultJson = "{result:'fail',message:'不是正确的商品编号！'}";
            return "redirect:" + url + "?result=" + URLEncoder.encode(resultJson,"UTF-8");
		}

		String pathdt = configUtil.getPictureLocation() + dt;
		String path = pathdt + File.separator + no;
    	File file =new File(path);    
    	if(!file.exists())      
    	{       
    		resultJson = "{result:'fail',message:'指定的目录不存在！'}";
            return "redirect:" + url + "?result=" + URLEncoder.encode(resultJson,"UTF-8");
    	}
    	
    	deleteDir(file);
    	
        
		return "redirect:" + url + "?result=" + URLEncoder.encode(resultJson,"UTF-8");
    }
	
	/**保存文件
     * @param stream
     * @param path
     * @param filename
     * @throws IOException
     */
    private void SaveFileFromInputStream(InputStream stream,String path,String filename) throws IOException
    {      
        FileOutputStream fs=new FileOutputStream( path + "/"+ filename);
        byte[] buffer =new byte[1024*1024];
        int byteread = 0; 
        while ((byteread=stream.read(buffer))!=-1)
        {
           fs.write(buffer,0,byteread);
           fs.flush();
        } 
        fs.close();
        stream.close();      
    }
    
    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     * @param dir 将要删除的文件目录
     * @return boolean Returns "true" if all deletions were successful.
     *                 If a deletion fails, the method stops attempting to
     *                 delete and returns "false".
     */
    private boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }
}