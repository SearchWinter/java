package abstractdemo;

/**
 * @Description  protected 同一个包内都可以访问
 * @Date 2020/7/3  9:20
 **/
public class Demo1 extends StaticDemo1{
    public static void main(String[] args) {
        StaticDemo1 staticDemo1 = new StaticDemo1();
        System.out.println(staticDemo1.sum);
    }

}
