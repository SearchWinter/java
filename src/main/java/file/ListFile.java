package file;

import java.io.File;

/**
 * @Description TODO
 * @Date 2020/9/25  14:30
 **/
public class ListFile {
    public static void main(String[] args) {
        File file = new File("D:\\IDEA_workplace\\Base-Stat");
        File[] files = file.listFiles();
        for (File file1:files){
            System.out.println(file1);
        }
    }
}
