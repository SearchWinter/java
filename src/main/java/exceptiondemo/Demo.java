package exceptiondemo;

import static java.lang.Thread.sleep;

/**
 * @ClassName Demo
 * @Description  finally不一定会被执行
 * @Author Li Anjun
 * @Date 2020/7/8  15:45
 **/
public class Demo {
    public static void main(String[] args) {
        //在try块之前就有异常抛出
        int[] arr = new int[-1];
        try{
            int i=100/0;
            System.out.println(i);
        }catch(Exception e){
            System.out.println(1);

            //退出当前正在运行的程序
//            System.exit(0);
            throw new java.lang.RuntimeException();
        }finally{
            System.out.println(2);
        }
    }
}
