package serializable;

import java.io.Externalizable;

/**
 * @ClassName Employee
 * @Description 序列化
 * @Author Li Anjun
 * @Date 2020/7/13  11:20
 **/
public class Employee implements java.io.Serializable {
    public static final long serialVersionUID=1L;
    public String name;
    public String address;
    public transient int ssn;
    public int number;
    public int ages;

    public static String test="demo";
    public void check(){
        System.out.println(name+" "+address);
    }
}
