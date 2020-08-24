package thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description     newCachedThreadPool 创建一个可缓存线程池(Integer.MAX_VALUE);当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
 * @Date 2020/8/21  16:26
 **/
public class CacheThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int index = i;
            Thread.sleep(index * 100);

            cachedThreadPool.execute(() ->
                    System.out.println(index +"当前线程："+Thread.currentThread().getName())
            );
        }
        cachedThreadPool.shutdownNow();
        cachedThreadPool.awaitTermination(3, TimeUnit.SECONDS);
        System.out.println("test");
    }
}
