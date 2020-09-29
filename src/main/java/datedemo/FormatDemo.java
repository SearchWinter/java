package datedemo;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description
 * @Date 2020/9/9  13:58
 **/
public class FormatDemo {
    public static void main(String[] args) throws ParseException {
        String beforeDay = getBeforeDay("20200808");
        System.out.println(beforeDay);
    }

    //得到前一天的日期
    public static String getBeforeDay(String ds) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(ds));

        cal.add(Calendar.DAY_OF_MONTH, -1);

        return new SimpleDateFormat("yyyyMMdd").format(cal.getTime());
    }

    /**
     * SimpleDateFormat类的format()方法将时间戳转换为指定格式的时间
     */
    @Test
    public void dataFormat1(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long l = System.currentTimeMillis();
        String date = simpleDateFormat.format(l);
        System.out.println(date);
    }

    /**
     * parse()，它试图按照给定的SimpleDateFormat 对象的格式化存储来解析字符串
     * @throws ParseException
     */
    @Test
    public void parseString() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = simpleDateFormat.parse("2020-09-30");
        System.out.println(parse);
    }

    @Test
    /** 时间转换为时间戳
     *  getTime()
     * */
    public void dateFormat2() throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        long time = sdf.parse("2020-09-20").getTime();
    }
}
