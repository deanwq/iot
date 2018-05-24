package com.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	
	public static int parseInt(String str)
	{
		try{
			return Integer.parseInt(str);
		}catch(Exception e){
			return 0;
		}
	}
	
	
	public static int getWeek(int ymd) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date d = sdf.parse(""+ymd);
		return getWeek(d);
	}
	public static int getWeek(Date d){
		int week = d.getDay();
		if(week==0)
			week=7;
		return week;
	}
	public static int getWeek(){
		return getWeek(new Date());
	}
	public static String getTime(){
		return getTime("yyyy-MM-dd HH:mm:ss");
	}
	public static int getDay(){
		String day = getTime("yyyyMMdd");
		return Integer.parseInt(day);
	}
	public static String getTime(String format){
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(d);
	}
	/**
	 * 写文件，系统默认字符集 
	 * @param content 待写入的文件内容
	 * @param path	  文件路径
	 * @param charset 指定的编码
	 * @param bAppend 是否追加
	 * @throws Exception
	 */
	public static void writeTxt(String content,String path,boolean bAppend) throws Exception
	{
		//输出字符流
		FileWriter fw = new FileWriter(path,bAppend);
		fw.write(content);
		fw.close();
	}
	/**
	 * 写文件，指定字符集，重新覆盖方式 
	 * @param content 待写入的文件内容
	 * @param path	  文件路径
	 * @param charset 指定的编码
	 * @throws Exception
	 */
	public static void writeTxt(String content,String path,String charset) throws Exception
	{
		if(charset==null)
			charset = "utf-8";
		//输出字节流
		OutputStream os = new FileOutputStream(path);
		os.write(content.getBytes(charset));
		os.close();
	}
	/**
	 * 写文件，指定字符集，追加方式
	 * @param content 待写入的文件内容
	 * @param path	  文件路径
	 * @param charset 指定的编码
	 * @throws Exception
	 */
	public static void writeTxtAppend(String content,String path,String charset) throws Exception
	{
		if(charset==null)
			charset = "utf-8";
		//输出字节流
		OutputStream os = new FileOutputStream(path,true);
		os.write(content.getBytes(charset));
		os.close();
	}
	public static String readTxt(String path,String charset) throws Exception
	{
		StringBuffer sb = new StringBuffer();
		if(charset==null)
			charset = "utf-8";
		//字节流
		//InputStream is = new FileInputStream(path);
		//InputStreamReader isr = new InputStreamReader(is,charset);
		//BufferedReader br = new BufferedReader();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path),charset));
		String line = "";
		while(  (line=br.readLine()) != null){
			sb.append(line+"\r\n");
		}
		br.close();
		
		return sb.toString();
	}
	
	public static String readTxt0(String path,String charset) throws Exception
	{
		int bufsize=1024;
		StringBuffer sb = new StringBuffer();
		if(charset==null)
			charset = "utf-8";
		//字节流
		InputStream is = new FileInputStream(path);
		InputStreamReader isr = new InputStreamReader(is,charset);
		char[] buf = new char[bufsize];
		int n;
		while( (n = isr.read(buf)) > 0){
			if(n<bufsize){
				char[] buf2 = new char[n];
				System.arraycopy(buf, 0, buf2, 0, n);
				sb.append(buf2);
			}else{
				sb.append(buf);
			}
			buf = new char[bufsize];
		}
		return sb.toString();
	}
}
