package file;

import java.io.File;

/**
 * @Description
 *          delete()方法，如果是一个目录，目录下面必须为空才能删除
 * @Date 2020/10/20  16:54
 **/
public class FileExists {
    public static void main(String[] args) {
        //linux下的路径，项目中的路径
        File file = new File("/data/taf/result/BaseStat/");
        if(file.exists()){

            //是一个文件夹，为空直接删，不为空
            if(file.isDirectory()) {
                if (file!=null){

                }else {
                    file.delete();
                }
            }
        }else{
            System.out.println("此文件不存在");
        }
    }

    public static void demo(File f){//传一个File对象f进去  因为要调用其方法
        if(f!=null){//判断f数据是否为空    因为可能有人会传null值进来
            if(f.exists()){//判断该抽象路径的目录和文件是否存在
                if(f.isDirectory()){//判断是否是目录
                    File[] listFiles = f.listFiles();//调用listFiles()方法返回一个File对象组成的数组集合
                    if(listFiles==null){//如果该数组为Null说明没有文件和目录对象  就是一个空的文件夹
                        f.delete();//直接删除
                    }else{//不为空的文件夹
                        for (File file : listFiles) {//遍历该集合
                            demo(file);//遍历到的每个File对象传入demo()方法
                        }
                        f.delete();//最后将这个不为空的文件夹删除
                    }
                }else{//不是目录可能是是文件或者不存在
                    f.delete();//直接删除
                }
            }else{//为Null
                return;//结束方法调用
            }
        }
    }
}
