package structure;

import java.util.ArrayList;

/**
 * @Description TODO
 * @Date 2020/8/20  11:21
 **/
public class Test {
    @org.junit.Test

    public void test(){
        String[] strings={"var1","var2","var3"};
        System.out.println();

        /** list重新了toString方法*/
        ArrayList<String> list = new ArrayList<>();
        list.add("var1");
        list.add("var2");
//        String string = list.toString();
        System.out.println(list);
    }
}
