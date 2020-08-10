package serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

/**
 * @ClassName DeserializeDemo
 * @Description 反序列化
 * @Author Li Anjun
 * @Date 2020/7/13  13:43
 **/
public class DeserializeDemo {
    public static void main(String[] args) {
        Employee employee=null;

        try {
            //创建对象输入流
            FileInputStream fileInput = new FileInputStream("D:\\employee.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInput);
            //通过readObject()方法读取对象，转化成 Employee 引用。
            employee=(Employee) objectInputStream.readObject();
            objectInputStream.close();
            fileInput.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(employee.name);
        //当对象被序列化时，属性 SSN 的值为 1111，但是因为该属性是短暂的，该值没有被发送到输出流。所以反序列化后 Employee 对象的 SSN 属性为 0
        System.out.println(employee.ssn);
        System.out.println(employee.address);
        System.out.println(employee.ages);
    }
}
