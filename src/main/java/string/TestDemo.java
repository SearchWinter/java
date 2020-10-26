package string;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * @Description java.lang.string中某些方法的测试
 * @Date 2020/8/4  10:32
 **/
public class TestDemo {
    @Test
    public void testMd2Hax(){
        String string="org.junit.Test";
        String s = DigestUtils.md2Hex(string);
        System.out.println(s);
    }
    @Test
    /**截取字符串*/
    public void subTest(){
        String string="org.junit";
        int i = string.indexOf(".");
        //包括beginIndex 不包括endIndex
        String substring = string.substring(0, i);
        System.out.println(substring);
    }

    @Test
    /** 取指定字符后几位的值*/
    public void subTest2(){
        String str="DeleteSignalDataFromCache_20201013.log";
        int i = str.lastIndexOf("_");
        String substring = str.substring(i + 1, i + 9);
        System.out.println(substring);
    }

    //用字符串表示负数，- 也算一个字符
    @Test
    public void lengthTest(){
        String num ="-1";
        System.out.println(num.length());
    }

    @Test
    public void test(){
        String str="DeleteSignalDataFromCache_20201013.log";
        int i = str.lastIndexOf("_");
        System.out.println(i);
        System.out.println(str.length()-i);
    }

    @Test
    public void subTestPath(){
        String str="file:///taf/warehouse/result/BaseStat/";
        String substring = str.substring(7);
        System.out.println(substring);

    }
}
