package abstractdemo;

/**
 * @ClassName StaticDemo1
 * @Description 与abstractdemo2里面的StaticDemo做验证
 * @Date 2020/6/29  18:45
 **/
public class StaticDemo1 {
    //成员变量
     int num=100;
     //类变量  必须声明为static类型
    public static int num2=100;

    public int num3=91910880;

    protected int sum=101010;
    public static void main(String[] args) {

        //同一类中，静态方法，不能访问默认权限的
//        System.out.println(num);
        //静态方法可以直接使用
        display();
//      protected
        StaticDemo1 staticDemo1 = new StaticDemo1();
        System.out.println(staticDemo1.num2);
        System.out.println(staticDemo1.sum);
    }
    public  void show(){
        System.out.println(num);
        System.out.println(num2);
    }
    public static void display(){
        System.out.println("调用公有的静态display方法");
        System.out.println(num2);
    }
    private void PriShow(){

        System.out.println("调用私有的非静态PriShow方法");
    }
}










