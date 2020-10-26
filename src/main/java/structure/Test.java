package structure;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Description TODO
 * @Date 2020/8/20  11:21
 **/
public class Test {
    @org.junit.Test

    public void test(){
        String[] strings={"var1","var2","var3"};
        System.out.println();

        /** list重写了toString方法*/
        ArrayList<String> list = new ArrayList<>();
        list.add("var1");
        list.add("var2");
//        String string = list.toString();
        System.out.println(list);
    }

    public Boolean test(HashMap<String,Integer> hashMap){

        return true;
    }
}
