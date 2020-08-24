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
    public void subTest(){
        String string="org.junit";
        int i = string.indexOf(".");
        //包括beginIndex 不包括endIndex
        String substring = string.substring(0, i);
        System.out.println(substring);
    }
}
