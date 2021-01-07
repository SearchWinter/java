package string;

import jodd.util.StringUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/** @Description java.lang.string中某些方法的测试 @Date 2020/8/4 10:32 */
public class TestDemo {
  @Test
  public void testMd2Hax() {
    String string = "org.junit.Test";
    String s = DigestUtils.md2Hex(string);
    System.out.println(s);
  }

  @Test
  /** 截取字符串 */
  public void subTest() {
    String string = "org.junit";
    int i = string.indexOf(".");
    // 包括beginIndex 不包括endIndex
    String substring = string.substring(0, i);
    System.out.println(substring);
  }

  @Test
  /** 取指定字符后几位的值 */
  public void subTest2() {
    String str = "DeleteSignalDataFromCache_20201013.log";
    int i = str.lastIndexOf("_");
    String substring = str.substring(i + 1, i + 9);
    System.out.println(substring);
  }

  // 用字符串表示负数，- 也算一个字符
  @Test
  public void lengthTest() {
    String num = "-1";
    System.out.println(num.length());
  }

  @Test
  public void test() {
    String str = "DeleteSignalDataFromCache_20201013.log";
    int i = str.lastIndexOf("_");
    System.out.println(i);
    System.out.println(str.length() - i);
  }

  @Test
  public void subTestPath() {
    String str = "file:///taf/warehouse/result/BaseStat/";
    String substring = str.substring(7);
    System.out.println(substring);
  }

  //截取有空值的情况
  @Test
  public void testSplit() {
      //reportrst
    String logName =
        "192.168.0.18|2020-09-04 10:59:59|d42c733926bc385b0a53eb3aeb563c47|com.hummer.shcj.client.windows|3269943|15||SN=WIN_com.hummer.shcj.client.windows&VN=0_0.0.0_0_DD&RL=1920_1080&OS=6.2.9200&CHID=4501_4501&MN=oemhummer_shcj&SDK=1.0.1&MO=&VC=&RV=|1599188399";
    //feedback
    String logName2="192.168.0.18|2020-11-02 14:57:01|4d12d95dbf37671fed16da1c93f5826c|com.hummer.shcj.client.windows|3270035|1604300221|SN=WIN_com.hummer.shcj.client.windows&VN=0_1.0.0_171_DD&RL=1920_1080&OS&CHID=1100_1100&MN=oemhummer_shcj&SDK=1.0.1&MO=&VC=&RV=";

    String[] split = logName2.split("\\|", -1);
    System.out.println(split.length);
    for (String str : split) {
      System.out.println(str);
    }
  }
  /** limit 参数的作用
   *  0 尽可能多的切分，但是为空的字符串会被舍弃
   *  正数 n 切分 n-1次，不会舍弃空字符串，返回数组的长度也就为n
   *  负数 尽可能多的切分，不舍弃空字符串
   * */
  @Test
  public void splitTest(){
    String str1="a|b|c|d|e";
    String str2="a|b|c||";
    String[] split = str1.split("\\|",2);

    System.out.println("split length:"+split.length);
    for (String string:split){
      System.out.print(string);
    }
  }

  /** trim()用于删除字符串头尾的空字符串*/
  @Test
  public void trimTest(){
    String str=" trim test ";
    String trim = str.trim();
    System.out.println(trim);
    System.out.println("str length: "+str.length());
    System.out.println("trim length:"+trim.length());
  }

  /** contains()判断一个字符串是否包含某个字符串
   * 方法返回true，当且仅当此字符串包含指定的char值序列*/
  @Test
  public void containsTest(){
    String logName="_taf_._trace___t_trace__20201225.log";
    boolean contains = logName.contains("20201225");
    System.out.println(contains);
  }

  /** equals()  比较字符串*/
  @Test
  public void emptyTest(){
    String str="";
    System.out.println("".equals(""));
    System.out.println(str==null);
  }

  /** 使用已有的方法判断空值情况*/
  @Test
  public void emptyTest2(){
    String str1="";
    while(StringUtil.isEmpty(str1)){

    }
  }

  /** equalsIgnoreCase() 比较字符串，并忽略大小写*/
  @Test
  public void equalsTest2(){
    String str="java";
    System.out.println("JAVA".equalsIgnoreCase(str));
  }
}
