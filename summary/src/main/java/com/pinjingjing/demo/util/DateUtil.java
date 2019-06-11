package com.pinjingjing.demo.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	/**
	 * 获取当前时间，格式为年-月-日 时:分:秒
	 * @return
	 */
	public static String getCurrTime(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currDate = format.format(new Date());
		return currDate;
	}
	
	/**
	 * 获取当前时间，格式为年月日时分秒
	 * @return
	 */
	public static String getNowTime(){
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String currDate = format.format(new Date());
		return currDate;
	}
	
    /**
     * 获取年份
     * @return
     */
    public static String getYear() {
        String strYear = "";
        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        strYear = formatter.format(currentDate);
        return strYear;
    }

    /**
     * 获取月份 
     * @return
     */
    public static String getYearMonth() {
        String strYearMonth = "";
        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        strYearMonth = formatter.format(currentDate);
        return strYearMonth;
    }
    
    /**
     * 获取指定日期格式的日期
     * @param format
     * @return
     */
    public static String getDateByFormat(String format)
    {
        String date = "";
        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        date = formatter.format(currentDate);
        return date;
    }

    /**
     * 获取年月日
     * @return
     */
    public static String getDate() {
        String strCurrentDate = "";
        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        strCurrentDate = formatter.format(currentDate);
        return strCurrentDate;
    }

    
    /**
     * 获取指定格式的日期
     * @param dateFormat 日期格式
     * @param intervalDay 与当天相隔的天数(0:当天 1:明天 -1：昨天)
     * @return
     */
    public static String getSpecialDate(String dateFormat,int intervalDay)
    {
        String strCurrentDate = "";
        // Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_YEAR, intervalDay);
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        strCurrentDate = formatter.format(c.getTime());
        
        return strCurrentDate;
    }
    
    /**
     * 功能：获取间隔一定分钟数的日期
     * 修改时间：Jul 27, 2011 10:46:53 AM  
     * @param dateFormat
     * @param intervalMinute
     * @return
     */
    public static String getSpecialDateByIntervalMinute(String dateFormat,int intervalMinute)
    {
        Date date = new Date();
        long time = date.getTime()+intervalMinute* 60 * 1000;
        Date preDate = new Date(time);
        
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat); 
        
        return formatter.format(preDate);
    }
    
    /**
     * 获取当前时间时分秒
     * @return
     */
    public static String getTime() {
        String strCurrentTime = "";
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        strCurrentTime = formatter.format(currentTime);
        return strCurrentTime;
    }
    
    /**
     * 获取当前小时
     * @return
     */
    public static String getCurrentHour()
    {
        String strCurrentTime = "";
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH");
        strCurrentTime = formatter.format(currentTime);
        return strCurrentTime;
    }
    
    /**
     * 获取当前分钟
     * @return
     */
    public static String getCurrentMinute()
    {
        String strCurrentTime = "";
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("mm");
        strCurrentTime = formatter.format(currentTime);
        return strCurrentTime;
    }
    
    /**
     * 根据日期格式获取某个时间值
     * @param specialDate
     * @param dateFormat
     * @return
     */
    public static String gettDateStrFromSpecialDate(Date specialDate, String dateFormat)
    {
        String strCurrentTime = "";
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        strCurrentTime = formatter.format(specialDate);
        return strCurrentTime;
    }

    /**
     * 数字时间格式化
     * 234359->23:43:59
     * @param time
     * @return
     */
    public static String numberToStringTime(String time) {
        String strTime = "";
        if (time.length() == 6) {
            String hh = time.substring(0, 2);
            String mm = time.substring(2, 4);
            String ss = time.substring(4, 6);
            strTime = (new StringBuilder(String.valueOf(hh))).append(":")
                    .append(mm).append(":").append(ss).toString();
        }
        return strTime;
    }

    /**
     * 数字日期格式化
     * 20090806->2009-08-06
     * @param date
     * @return
     */
    public static String numberToStringDate(String date) {
        String strTime = "";
        // System.out.println("date.length:"+date.length());
        if (date.length() == 8) {
            String year = date.substring(0, 4);
            String month = date.substring(4, 6);
            String day = date.substring(6, 8);
            strTime = (new StringBuilder(String.valueOf(year))).append("-")
                    .append(month).append("-").append(day).toString();
        }
        return strTime;
    }
    
    /**
     * 返回两个string类型日期之间相差的天数 
     * @param smdate
     * @param bdate
     * @return
     */
    public static int daysBetween(String smdate,String bdate){ 
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); 
        Calendar cal = Calendar.getInstance();  
        long time1 = 0;
        long time2 = 0;
         
        try{
          cal.setTime(sdf.parse(smdate));  
          time1 = cal.getTimeInMillis();  
          cal.setTime(sdf.parse(bdate)); 
          time2 = cal.getTimeInMillis(); 
        }catch(Exception e){
          e.printStackTrace();
        }
        long between_days=(time2-time1)/(1000*3600*24); 
           
       return Integer.parseInt(String.valueOf(between_days));   
      }
    
    /**
     * String转Date
     * @param s
     * @return
     */
    public static Date transferDate(String s){
        try {
        	SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdfTime.parse(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 判断日期是一周中的第几天
     * @param str
     * @return
     */
    public static int getWeekWhich(String str){
    	Calendar calendar = Calendar.getInstance();
        calendar.setTime(transferDate(str));
        return calendar.get(Calendar.DAY_OF_WEEK);
    }
    
    /**
     * 获取指定天数前后的日期
     * @param day 指定天数
     * @param s 加减
     * @return
     */
    public static String getNamedDays(int day,String s){
        Calendar canlendar = Calendar.getInstance();
        if(s.equals("+")){
            canlendar.add(Calendar.DATE, day); // 日期减 如果不够减会将月变动
        }else {
            canlendar.add(Calendar.DATE, -day); // 日期减 如果不够减会将月变动
        }
        Date date = canlendar.getTime();

        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdfd.format(date);

        return dateStr;
    }
}
