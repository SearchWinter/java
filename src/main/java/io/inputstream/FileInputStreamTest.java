package io.inputstream;

import java.io.*;

/**
 * @Description 文件输入流案例,读取文件的内容，然后在控制台输出
 * @Date 2020/7/16  10:30
 **/
public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        //使用字符串类型的文件名，来创建输入流对象读取文件
            FileInputStream fileInputStream = new FileInputStream("E:\\test.txt");

        //使用文件对象创建一个输入流对象
        File file = new File("E:\\test.txt");
        FileInputStream fileInputStream2 = new FileInputStream(file);

        //read()    int     从这个输入流中读取一个字节的数据
        char read = (char)fileInputStream.read();
        System.out.println(read);

        //构建InputStreamReader对象
        InputStreamReader ipsReader = new InputStreamReader(fileInputStream, "utf-8");

        StringBuffer stringBuffer = new StringBuffer();
        //ready()  boolean     告知该流是否已准备好读取。
        //read()    char        读取单个字符
        while (ipsReader.ready()){
            //转换为char加到StringBuffer里面
            stringBuffer.append((char)ipsReader.read());
        }
        System.out.println(stringBuffer.toString());

        //关闭读取流
        ipsReader.close();

    }
}
