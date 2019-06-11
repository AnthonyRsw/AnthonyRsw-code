package com.pinjingjing.demo.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.crypto.Data;

public class StringUtil {

	//组装mysql分页参数
	public static String getPageParam(int page, int limit){
		if(0 != page && (0 != limit)){
			return "LIMIT " + ((page-1)*limit) + ", " + limit;
		}
		return "";
	}
	
	public static boolean isNotNullAndEmpty(String value){
		return null != value && (!"".equals(value.trim()));
	}
	
	/**
	 * 判断是不是手机号
	 * @param mobiles
	 * @return
	 */
	public static boolean isMobileNO(String mobiles) {
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
		Matcher m = p.matcher(mobiles);
		return m.matches();
	}
	
	/**
	 * 格式化时间为long
	 * @param 
	 * @return
	 */
	public long dateTolong(Data data) {
		return 1l;
	}
	
	/**
	 * 将日期的字符串转化为日期类型
	 * 格式为"2004-10-10" --> Date
	 * @param sDate
	 * @since 1.0
	 */
	public static java.util.Date getString2Date(String sDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date obj = null;

		try {
			obj = sdf.parse(sDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return obj;
	}
	
	
	public static java.util.Date getString2Date2(String sDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		java.util.Date obj = null;

		try {
			obj = sdf.parse(sDate);
		} catch (ParseException e) {
			e.printStackTrace();

		}

		return obj;
	}

	public static String getDate2ChnString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dateString = sdf.format(date);
		StringBuffer sb = new StringBuffer();
		sb
			.append(dateString.substring(0, 4))
			.append("年")
			.append(dateString.substring(4, 6))
			.append("月")
			.append(dateString.substring(6, 8))
			.append("日");
		return sb.toString();
	}
	
	public static String getDetailChnDate(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateString = sdf.format(date);
		StringBuffer sb = new StringBuffer();
		sb
			.append(dateString.substring(0, 4))
			.append("年")
			.append(dateString.substring(4, 6))
			.append("月")
			.append(dateString.substring(6, 8))
			.append("日")
			.append(dateString.substring(8, 10))
			.append("时")
			.append(dateString.substring(10, 12))
			.append("分")
			.append(dateString.substring(12, 14))
			.append("秒");
		return sb.toString();
	}

	public static String getDate2String(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(date);
	}

	public static String getDate3String(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	public static String getCurrentDate3String() {
		return getDate3String(new Date());
	}
	public static String getDate4String(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(date);
	}

	public static String getTranTd(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
		return sdf.format(date);
	}

	public static String getDate5String(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(date);
	}

	public static String getDate6String(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(date);
	}

	public static Date getDate7String(String sDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		java.util.Date obj = null;

		try {
			obj = sdf.parse(sDate);
		} catch (ParseException e) {
			e.printStackTrace();

		}

		return obj;

	}
	
	public static String getDate8String(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	
	public static String getDate9String(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		return sdf.format(date);
	}
	
	
	public static String getDate10String(long date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	
	/**
	 * 系统当前时间加x分钟
	 * @return
	 */
	public static Calendar calendarAddxM(int m){
		//当前日期+m分钟
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, +m);
		return cal;
		
	}
	
	/**
	 * 系统当前时间
	 * @return
	 */
	public static Calendar nowCalendar(){
		//当前日期
		Calendar cal = Calendar.getInstance();
		return cal;
		
	}
	
	/**
	 * 参数时间减m分钟
	 * @return Long
	 */
	public static Long dateDelxM(Date date, long m){
		long x = m*60*1000;
		//时间-m分钟
		return date.getTime()-x;
	}
	
	/**
	 * 参数时间加m分钟
	 * @return Long
	 */
	public static Long dateAddxM(Date date, long m){
		long x = m*60*1000;
		//时间+m分钟
		return date.getTime()+x;
	}
	
	/**
	 * 系统当前时间减x天
	 * @return Long
	 */
	public static Calendar calendarDelxD(int d){
		//当前日期-3天
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -d);
		return cal;
	}
	
	/**
	 * 系统当前时间加x天
	 * @return Long
	 */
	public static Calendar calendarAddxD(int d){
		//当前日期-3天
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, +d);
		return cal;
	}
	
	/** 判断nowTime是否在startTime和endTime范围内 
	 *  时间格式hh:mm:ss
	 * @param nowTime
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static boolean timeCompare(String nowTime, String startTime, String endTime) {
		int hour1=Integer.parseInt(nowTime.substring(11,13));
		int hour2=Integer.parseInt(startTime.substring(0,2));
		int hour3=Integer.parseInt(endTime.substring(0,2));
		if(hour2<=hour1 && hour1<hour3){
			return true;
		}else
			return false;

	}
	
    /** 
     * 执行一个HTTP GET请求，返回请求响应的HTML 
     * 
     * @param url 请求的URL地址 
     * @return 返回请求响应的HTML 
     */ 
    public static StringBuffer doGet(String url) {
    	
    	InputStream in = null;
    	InputStreamReader rd = null;
    	HttpURLConnection connection = null;
    	StringBuffer temp = new StringBuffer();
    	try{
    	URL getUrl = new URL(url); 

        //根据拼凑的URL，打开连接，URL.openConnection()函数会根据 URL的类型，返回不同的URLConnection子类的对象，在这里我们的URL是一个http，因此它实际上返回的是HttpURLConnection 
        connection = (HttpURLConnection) getUrl.openConnection(); 
         
        //建立与服务器的连接，并未发送数据 
        connection.connect(); 

  		temp = new StringBuffer();
 		in = new BufferedInputStream(connection.getInputStream());
 		rd = new InputStreamReader(in,"UTF-8");
 		
		int c = 0;
			while((c = rd.read())!= -1){
			       temp.append((char)c);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				rd.close();
				in.close();
				connection.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return temp; 
    }
	

    
    /**
     * 判断字符串引用不为null并且值不为空
     * @param orgStr
     * @return
     */
    public static boolean isNotNullAndNotEmpty(String orgStr) {
    	
		return (orgStr != null && orgStr.trim().length() != 0 && (!"null".equals(orgStr)));
    	
	}
    
    /**
     * 判断Object引用不为null且值不为空
     * @param obj
     * @return
     */
    public static boolean isNotNullAndNotEmpty(Object obj) {
		if (obj instanceof Object[]) {
			Object[] o = (Object[]) obj;
			for (int i = 0; i < o.length; i++) {
				Object object = o[i];
				if ((object != null) && (!("").equals(object)) && (!"null".equals(obj))) {
					return true;
				}
			}
		} else {
			if ((obj != null) && (!("").equals(obj)) && (!"null".equals(obj)) ) {
				return true;
			}
		}

		return false;
	}
    
    /**
     * 判断字符串引用为null或值为空
     * @param orgStr
     * @return
     */
    public static boolean isNullOrEmpty(String orgStr) {
		return (orgStr == null || orgStr.trim().length() == 0 || ("null".equals(orgStr)));
	}

    
    /**
     * 判断Object引用为null或者值为空
     * @param obj
     * @return
     */
    public static boolean isNullOrEmpty(Object obj) {
		if (obj instanceof Object[]) {
			Object[] o = (Object[]) obj;
			for (int i = 0; i < o.length; i++) {
				Object object = o[i];
				if ((object == null) || (("").equals(object)) || ("null".equals(obj)) ) {
					return true;
				}
			}
		} else {
			if ((obj == null) || (("").equals(obj)) || ("null".equals(obj))) {
				return true;
			}
		}

		return false;
	}
    
    /**
     * 
     * @param obj
     * @return
     */
    public static String toStringAndTrim(Object obj){
    	String str = null;
    	if(isNotNullAndNotEmpty(obj)){
    		str = obj.toString().trim();
    	}
    	return str;
    }
    
    /**
	 * 随机生成6位数
	 * @return
	 */
	public static String generate(){
		char[] chs = new char[6]; 
		char[] letters = {'0','1','2','3','4','5','6','7','8','9'};  
		boolean[] flags = new boolean[letters.length]; 
		
		for(int i=0;i<chs.length;i++){ 
			int index;
			do{
				index = (int)(Math.random()*letters.length); 
			}while(flags[index]==true); 
			
			chs[i] = letters[index]; 
			flags[index] = true; 
		}
		return changePrint(chs);
	}
	
	/**
	 * 将一个字符串数组直接以字符串的形式输出
	 * @param value
	 * @return
	 */
	public static String changePrint(char[] value){
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < value.length; i++) {
			sb.append(value[i]);
		}
		return sb.toString();
	}
	
	/** 获得从now开始iMonth个月前的一天  
	 * @param now
	 * @param iMonth
	 * @return
	 */
	public static Date getDateBefore(Date now, int iMonth) {
		Calendar c = Calendar.getInstance();
		c.setTime(now);
		c.add(Calendar.MONTH, 0 - iMonth);
		return c.getTime();
	}
	
    /**
	 * 字母递增
	 * @param driver
	 * @return
	 */
	public static synchronized String driverLetters(String driver) {
		if (null == driver || driver.length() <= 0) {
			return "AAAAAA";
		}

		char[] charArray = driver.toCharArray();
		AtomicInteger z = new AtomicInteger(0);
		for (int i = charArray.length - 1; i > -1; i--) {
			if (z.intValue() > 0 || i == charArray.length - 1) {
				AtomicInteger atomic = new AtomicInteger(charArray[i]);
				char str = (char) atomic.incrementAndGet();
				
				// 过滤容易与数字混淆的字母
				if (str == 'I') {
					str = 'J';
					charArray[i] = str;
					break;
				} else if (str == 'O') {
					str = 'P';
					charArray[i] = str;
					break;
				} else if (str == 'Z') {
					charArray[i] = 'A';
					z.set(i - 1);
				} else {
					charArray[i] = str;
					break;
				}
			}
		}

		return String.valueOf(charArray);
	}
	/**
	 * 生成指定长度随机字符串
	 * @param length
	 * @return
	 */
	public static String getToken(int length) { //length表示生成字符串的长度
	    String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";   
	    Random random = new Random();   
	    StringBuffer sb = new StringBuffer();   
	    for (int i = 0; i < length; i++) {   
	        int number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }   
	    return sb.toString();   
	 } 
	/**
	 * 生成指定位数数字字符串
	 * @param length
	 * @return
	 */
	public static String getRandom(int length) { //length表示生成字符串的长度
	    String base = "0123456789";   
	    Random random = new Random();   
	    StringBuffer sb = new StringBuffer();   
	    for (int i = 0; i < length; i++) {   
	        int number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }   
	    return sb.toString();   
	 } 
}
