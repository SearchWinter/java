package thread.block;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description 线程池
 **/
public class Test2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        StorageBlock2 storageBlock=new StorageBlock2();
        executorService.execute(new Producer(storageBlock, "p1"));
        executorService.execute(new Producer(storageBlock, "p2"));
        executorService.execute(new Producer(storageBlock, "p3"));

        executorService.execute(new Consumer(storageBlock, "c1"));
        executorService.execute(new Consumer(storageBlock, "c2"));
        executorService.execute(new Consumer(storageBlock, "c3"));
        executorService.execute(new Consumer(storageBlock, "c4"));


    }

}
