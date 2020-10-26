package datedemo;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

        ArrayList<String> beforeDay1 = getBeforeDay(3);
        System.out.println(beforeDay1);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        String date = simpleDateFormat.format(1602737796233L);
        System.out.println(date);
    }

    //得到指定日期，前一天的日期
    public static String getBeforeDay(String ds) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(ds));

        cal.add(Calendar.DAY_OF_MONTH, -1);

        return sdf.format(cal.getTime());
    }

    /**
     * 近n天的日期,保存到list中
     * */
    public static ArrayList<String> getBeforeDay(Integer n) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        ArrayList<String> list = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        //从0开始，包括当天
        for(int i=0;i<=n;i++) {
            cal.setTime(new Date());
            cal.add(Calendar.DAY_OF_MONTH, -i);
            list.add( sdf.format(cal.getTime()));
        }
        return list;
    }
    /**
     * 将时间戳转换为指定格式的时间
     * SimpleDateFormat类的format()方法
     */
    @Test
    public void dataFormat1(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long l = System.currentTimeMillis();
        String date = simpleDateFormat.format(l);
        System.out.println(date);
    }

    /**
     * parse() 解析特定格式的字符串 String 2020-09-30 ->Date
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

    @Test
    /**
     * 获取四天前的日期，指定格式
     */
    public void dateDemo(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_MONTH,-4);

        String s = sdf.format(cal.getTime());
        System.out.println(s);
    }


}
