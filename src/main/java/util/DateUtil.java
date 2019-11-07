package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
     public static Date toDate(String dateStr) {
    	 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    	 
    	 
		try {
			return sdf.parse(dateStr) ;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    	 
     }
     /*
      * 根据某种日期格式转化为字符串
      * 
      * */
     
     public static String dateTostring(String dateFormat,Date date) {
		return new  SimpleDateFormat(dateFormat).format(date);
    	 
     }
}
