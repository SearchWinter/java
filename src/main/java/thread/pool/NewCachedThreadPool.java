package thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description ToDO
 * @Date 2020/8/20  23:36
 **/
public class NewCachedThreadPool {
    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();
        ExecutorService service = Executors.newCachedThreadPool();
        System.out.println("******newCachedThreadPool*******");
        for (int i = 0; i <4 ; i++) {
            TPoolDemo tPoolDemo = new TPoolDemo(i);
            service.execute(tPoolDemo);
        }
//        service.shutdownNow();
        service.awaitTermination(10, TimeUnit.SECONDS);
        long end=System.currentTimeMillis();
        System.out.println(end-start);
//        "https://my.oschina.net/sdlvzg/blog/2222136"
    }
}
