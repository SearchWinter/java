package thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description newFixedThreadPool  创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
 * @Date 2020/8/21  15:43
 **/
public class FixedThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

        //循环10次，创建了10个线程，但是线程池大小为3，
        for (int i = 0; i <10 ; i++) {
            final int index=i;
            fixedThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"  "+index);
                    try {
                        Thread.sleep(3*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        fixedThreadPool.shutdown();
        fixedThreadPool.awaitTermination(2, TimeUnit.SECONDS);
    }
}
