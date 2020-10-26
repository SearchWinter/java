package typecast;

/**
 * @ClassName Test
 * @Description 类型转换
 * @Author Li Anjun
 * @Date 2020/7/9  10:55
 **/
public class Test {
    public static void main(String[] args) {
        //int char的相互转换，ASCII码
        //可以直接将一个（不超过char的范围的）数字赋值给一个char变量,无符号位：0 至 2 ^ 16 -1，即0-65535
        char c1 = 65535;
        System.out.println(c1);
        int  a1='a';
        System.out.println(a1);

        //int变量赋值给char变量,强制转换
        int num2=97;
        //数据会丢失，报错
//        char c2=num2;
        //显示的强制转换
        char c2=(char)num2;
        //初始化char变量，赋值给int变量，隐式转换
        char c3=97;
        int num1=c3;

        //int double
        int num3=100;
        double b1=num3;

        double dou1=324;
        int num4=(int)dou1;

        //string——>int
        String str1="12345";
        //第一种方法
        int num5=Integer.parseInt(str1);
        //第二种方法,本质还是调用了parseInt()方法
//        int num5=Integer.valueOf(str1);
        System.out.println(num5);

        //int ——>string
        int num6=100;
        String str2=Integer.toString(num6);
//        String str2=String.valueOf(num6);

        /** 0x 表示十六进制*/
        // 无符号右移。无论是正数还是负数，高位通通补0
        // 1111 1111 1111 1111 1111 1111 1111 1111
        int nBit = (0xFFFFFFFF >>> (32 - 3));
        System.out.println(nBit);
    }
}
