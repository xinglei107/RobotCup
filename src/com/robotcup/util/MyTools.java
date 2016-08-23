package com.robotcup.util;
import java.security.*;
public class MyTools {

	//md5加密
	public final static String MD5(String s) {      
		  char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',  'a', 'b', 'c', 'd', 'e', 'f' };      
		  try {      
		   byte[] strTemp = s.getBytes();      
		   MessageDigest mdTemp = MessageDigest.getInstance("MD5");      
		   mdTemp.update(strTemp);      
		   byte[] md = mdTemp.digest();      
		   int j = md.length;      
		   char str[] = new char[j * 2];      
		   int k = 0;      
		   for (int i = 0; i < j; i++) {      
		    byte byte0 = md[i];      
		    str[k++] = hexDigits[byte0 >>> 4 & 0xf];      
		    str[k++] = hexDigits[byte0 & 0xf];      
		   }      
		   return new String(str);      
		  } catch (Exception e) {      
		   return null;      
		   }
	}
	//从字符串中提取汉字
	public static String getChinese(String content,int length)
	{
		StringBuffer sb = new StringBuffer();
        for (int i = 0; i < content.length(); i++) {
            if ((content.charAt(i)+"").getBytes().length>1) {
                sb.append(content.charAt(i));
                if(sb.length()>=length)//提取到指定长度的汉字以后即可跳出
                	break;
            }
        }
		return sb.toString();
	}
	//从文章中提取文本内容（去除标签）
	public static String getText(String content,int length){
		if(content==null)
			return "";
		int start=0,end=0;
		StringBuffer sb = new StringBuffer();
		String res="";
		while(end!=-1&&sb.length()<=length)//end=1说明到结尾了
		{
			start=content.indexOf(">",end);
			end=content.indexOf("<",start);
			if(start+1<end)
			{
				String temp=content.substring(start+1,end).replace(" ", "").replace("&nbsp;","");
				sb.append(temp);
			}
		}
		if(sb.length()>length)
			res=sb.substring(0, length);
		else
			res=sb.toString();
		return res;
	}
	//从字符串中提取图片链接
	public static String getImageUrl(String content)
	{
		if(content==null)
			return "";
		int imgi=content.indexOf("<img");
		if(imgi<0)
			return "";
		int srci=content.indexOf("src=\"",imgi);
		int srcj=content.indexOf("\" style", imgi);
		String src=content.substring(srci+5, srcj);
		return src;
	}
}

    
     
