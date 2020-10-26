import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description if后面可以不接else,只有当if(true)的时候才会执行
 *              if()中是一个方法时，哪怕结果为false,（）中的方法还是会执行;list作为参数，值已经改变
 * @Date 2020/8/25  14:17
 **/
public class TestDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        if(!putDemo(list)){
            System.out.println("if条件为false,作为参数的list的值，会改变");
        }
        System.out.println(list);
    }

    public static boolean putDemo(List<Integer> list){
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        return true;
    }

    @Test
    public void randomTest(){
        Random random = new Random();
        for (int j = 0; j <10 ; j++) {
            int i = random.nextInt(20);
            System.out.println(i);
        }
    }
}

