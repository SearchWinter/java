package regex.matchdemo;

import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName MatchTest
 * @Description TODO
 * @Author Li Anjun
 * @Date 2020/7/15  11:21
 **/
public class MatchTest {

//groupCount 方法返回一个 int 值，表示matcher对象当前有多个捕获组。
    /** replaceFirst()      replaceAll()        将匹配到的第一个字符串替换为指定的字符串
     * */
    @Test
    public void replaceTest(){
        String string="cat dog cat";
        Pattern pattern = Pattern.compile("cat");
        Matcher matcher = pattern.matcher(string);

        String pig = matcher.replaceFirst("pig");
        String java = matcher.replaceAll("java");
        System.out.println(pig);
        System.out.println(java);
    }

    /** find()   boolean   尝试查找与模式匹配的输入序列的下一个子序列，匹配到的字符串可以再任何位置
     *  group()     String   返回前一个匹配项匹配的子序列
     *  start()     int     返回匹配到的字符串的初始索引
     *  end()       int     返回匹配到的字符串的最后一个索引位置+1
     * */
    @Test
    public void findStartTest(){
        String str="java hello java scala java";
        Pattern pattern = Pattern.compile("java");
        Matcher matcher2 = pattern.matcher(str);
        while (matcher2.find()){
            System.out.println(matcher2.group()+"位置："+matcher2.start()+","+matcher2.end());
        }
    }

    /** lookingAt()  Boolean    只有匹配到的字符在最前面才会返回true
     * */
    @Test
    public void lookingAtTest(){
        Pattern pattern = Pattern.compile("\\d+");

        Matcher matcher = pattern.matcher("22add33");
        Matcher matcher1 = pattern.matcher("add2233");
        boolean b = matcher.lookingAt();
        boolean b1 = matcher1.lookingAt();
        System.out.println(b);
        System.out.println(b1);
    }

    @Test
    public void matchsTest(){
        Pattern pattern = Pattern.compile("foo");
        Matcher matcher = pattern.matcher("foooooo");
        boolean b = matcher.matches();
        System.out.println(b);
    }
}
