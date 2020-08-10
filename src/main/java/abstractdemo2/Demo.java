package abstractdemo2;

import abstractdemo.StaticDemo1;

/**
 * @ClassName Demo
 * @Description protected  不同包的子类也不能访问
 * @Author Li Anjun
 * @Date 2020/7/3  9:18
 **/
public class Demo extends StaticDemo1 {
    public static void main(String[] args) {
        StaticDemo1 staticDemo1 = new StaticDemo1();
//        System.out.println(staticDemo1.sum);
    }
}
