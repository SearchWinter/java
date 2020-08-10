package serializable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * @ClassName SerializeDemo
 * @Description 序列化对象
 * @Author Li Anjun
 * @Date 2020/7/13  11:29
 **/
public class SerializeDemo {
    public static void main(String[] args) {
        Employee employee=new Employee();
        employee.name="Ani";
        employee.address="武汉";
        employee.ssn=1111;
        employee.number=1011;
        employee.ages=23;
        try {
            //创建一个对象输出流，可以包装其他类型的目标输出流，如文件输出流
            //添加true,表示序列化时，只是追加而不是覆盖
            FileOutputStream fileout = new FileOutputStream("D:\\employee.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileout);

            //通过writeObject()方法，写对象
            objectOutputStream.writeObject(employee);
            objectOutputStream.close();
            fileout.close();
            System.out.println("Serialized data is saved in employee.ser");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
