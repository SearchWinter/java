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
}
