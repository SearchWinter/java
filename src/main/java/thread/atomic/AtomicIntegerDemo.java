package thread.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 整型原子类
 * @Date 2020/8/11  11:08
 **/
public class AtomicIntegerDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        AtomicInteger count = new AtomicInteger(10);
        for (int i = 0; i <100 ; i++) {
            executorService.submit(()->{
                System.out.println(Thread.currentThread().getName()+"count="+count.get());
                count.incrementAndGet();
            });
        }
        ExecutorService executorService1 = Executors.newFixedThreadPool(3);
        executorService.submit(()->{
            System.out.println(count);
        });
        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(count.get());
    }
}
