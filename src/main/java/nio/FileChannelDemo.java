package nio;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @ClassName FileChannelDemo
 * @Description TODO
 * @Author Li Anjun
 * @Date 2020/7/16  15:12
 **/
public class FileChannelDemo {
    /** 配合缓冲区，实现文件复制功能
     *  从test里面读取数据
     * */
    @Test
    public void FileCopy() throws IOException {
        //1、获取FileChannel通道
        Path path = Paths.get("E:\\test.txt");
        FileChannel fileInChannel = FileChannel.open(path, StandardOpenOption.READ);

        Path path1 = Paths.get("E:\\test2.txt");
        FileChannel fileOutChannel = FileChannel.open(path1, StandardOpenOption.WRITE);

        //2、分配指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //3、将通道中的数据存入缓冲区中
        while (fileInChannel.read(byteBuffer)!=-1){
            //切换读取数据的模式
            byteBuffer.flip();
            //将缓冲区中的数据写入通道中，这一步就已经再往文件里面写数据
            fileOutChannel.write(byteBuffer);
            //如果没有这一句，程序会一直执行，也就是会一直讲byteBuffer里面的数据写入文件
            byteBuffer.clear();
        }

    }
}
