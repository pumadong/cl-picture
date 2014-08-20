package com.cl.picture.utils;

import java.awt.Image;  
import java.awt.image.BufferedImage;  
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;  
import java.io.ByteArrayOutputStream;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.util.Iterator;   
import javax.imageio.ImageIO;  
import javax.imageio.ImageReader;  
import javax.imageio.stream.MemoryCacheImageInputStream; 

/**
 * 作者：付学亮
 * 版权：北京数字天域
 * 创建日期： 2011-10-10
 * 此类用途：图片工具类
 */
public final class ImageUtil {  
	
	public static String zoom(String picFrom, String picTo, int size, String formart) {		
		formart=JPG;	
		try {
			byte[] k1= readFromFile(picFrom);
			RenderedImage   rendImage   =getScaleImage(k1,formart.toUpperCase(), size);
			//以下是将图形保存为标准图片格式
			ImageIO.write(rendImage,formart.toUpperCase(),new File(picTo)); 
		} catch (IOException e) {
			 
		}
		return picTo;
	}
	public static void main(String[] args) {		
		 zoom("D:\\93791309846435096972.gif", "D:\\2.bmp", 200, "jpg");		
	}
    public static final String PNG="png";  
    public static final String JPG="jpg";  
    public static final String BMP="bmp";  
    public static final String GIF="gif";  
    public static byte[] readFromFile(String path) throws IOException {  
        InputStream is = new FileInputStream(new File(path));  
        byte[] buf = new byte[is.available()];  
        is.read(buf);  
        is.close();  
        return buf;  
    }  
  
    /** 
     * 构建一个image对象 
     *  
     * @param img 
     * @return 
     * @throws IOException 
     */  
    public static ImageInfo getImageInfo(byte[] img) throws IOException {  
        ByteArrayInputStream bais = new ByteArrayInputStream(img);  
        MemoryCacheImageInputStream is=new MemoryCacheImageInputStream(bais);  
        Iterator<ImageReader> it=ImageIO.getImageReaders(is);  
        ImageReader r=null;  
        while(it.hasNext()){  
            r=it.next();  
            break;  
        }  
        if(r==null){  
            return null;  
        }  
        ImageInfo i=new ImageInfo();  
        i.setType(r.getFormatName().toLowerCase());  
        int index=r.getMinIndex();  
        /** 
         * 对于ImageReader的线程安全是不确定的 
         */  
        synchronized (r) {  
            r.setInput(is);  
            i.setHeight(r.getHeight(index));  
            i.setWidth(r.getWidth(index));  
        }  
        return i;  
    }  
    public static BufferedImage getImage(byte[] img) throws IOException {  
        ByteArrayInputStream bais = new ByteArrayInputStream(img);  
        BufferedImage src = ImageIO.read(bais);  
        return src;  
    }  
    /** 
     * 等比例缩放 
     * @param img 
     * @param width 
     * @return 
     * @throws IOException 
     */  
    public static BufferedImage getScaleImage(byte[] img,String type,int width) throws IOException {  
        ByteArrayInputStream bais = new ByteArrayInputStream(img);  
        BufferedImage src = ImageIO.read(bais);  
        int w=src.getWidth();  
        int h=src.getHeight();  
        int height=(int) (((float)width/w)*h);  
        Image im=src.getScaledInstance(width, height,Image.SCALE_SMOOTH);  
        BufferedImage bi=new BufferedImage(width, height, src.getType());  
        bi.getGraphics().drawImage(im, 0, 0,null);  
        return bi;  
    }  
    public static byte[] getScaleImageBytes(byte[] img,String type,int width) throws IOException {  
        BufferedImage bi=getScaleImage(img, type, width);  
        ByteArrayOutputStream out=new ByteArrayOutputStream();  
        ImageIO.write(bi, type, out);  
        return out.toByteArray();  
    }  
    /** 
     * 获取文件类型,没找到返回null,这方法太高效了,可能不准确, 
     * 这个是我看的网上的，有bug不准确 
     * @param byte1 
     * @return 
     */  
    public static String fastParseFileType(byte[] byte1) {  
        if ((byte1[0] == 71) && (byte1[1] == 73) && (byte1[2] == 70)  
                && (byte1[3] == 56) && ((byte1[4] == 55) || (byte1[4] == 57))  
                && (byte1[5] == 97)) {  
            return GIF;  
        }  
        if ((byte1[6] == 74) && (byte1[7] == 70) && (byte1[8] == 73)  
                && (byte1[9] == 70)) {  
            return JPG;  
        }  
        if ((byte1[0] == 66) && (byte1[1] == 77)) {  
            return BMP;  
        }  
        if ((byte1[1] == 80) && (byte1[2] == 78) && (byte1[3] == 71)) {  
            return PNG;  
        }  
        return null;  
    }
    public static class ImageInfo{  
        private String type;  
        private int width;  
        private int height;  
        public String getType() {  
            return type;  
        }  
        public void setType(String type) {  
            this.type = type;  
        }  
        public int getWidth() {  
            return width;  
        }  
        public void setWidth(int width) {  
            this.width = width;  
        }  
        public int getHeight() {  
            return height;  
        }  
        public void setHeight(int height) {  
            this.height = height;  
        }  
    } 
    
    /**
     * 生成缩略图，对于第一张图，生成c颜色图(40*40)
     * 对于每张图，生成4种尺寸的图t(60*60),s(160*160),m(240*240),l(480*480)，加上原图o(1000*1000)，加上b(750*750)
     * @param path
     * @param ext
     */
    public static void CreateZoomPicture(String path,String ext)
    {
    	if(path.indexOf("_o.")==-1)
    	{
    		return;
    	}
    	//l图
        ImageUtil.zoom(path,path.replace("_o", "_l"), 480, ext);
        //m图
        ImageUtil.zoom(path,path.replace("_o", "_m"), 240, ext);
        //s图
        ImageUtil.zoom(path,path.replace("_o", "_s"), 160, ext);
        //t图
        ImageUtil.zoom(path,path.replace("_o", "_t"), 60, ext);
        //b图
        ImageUtil.zoom(path,path.replace("_o", "_b"), 750, ext);
        //对于第一张图，切c图
        if(path.indexOf("_01_") !=-1)
        {
        	ImageUtil.zoom(path,path.replace("_o", "_c"), 40, ext);
        }
    }
}  