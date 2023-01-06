package 课程;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class 完全日期date {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//使用sdf设置时间的格式
        Date date = sdf.parse("2001-1-1");//将指定的日期2001-1-1转换成Date
        System.out.println(date);//检测一下date
        Calendar cal=new GregorianCalendar();//创建一个日历
        cal.setTime(date);//setTime设置时间
        cal.add(Calendar.DAY_OF_MONTH,1);
        /*
         * 
         */
        date=cal.getTime();
        System.out.println(date);
    }
}
