package thread.block;

import java.util.concurrent.Executors;

/**
 * @Description TODO
 * @Date 2020/8/10  14:18
 **/
public class Test2 implements Runnable {
    public static void main(String[] args) {
        java.util.concurrent.ExecutorService service = Executors.newFixedThreadPool(10, (Runnable r) -> {
            Thread t = new Thread(r, "TafLogReaderThead");
            t.setDaemon(true);
            return t;
        });
        service.execute(()->{
            while (!Thread.interrupted()){
                System.out.println("Thread.interrupted()="+ Thread.interrupted());
                if (Thread.currentThread().isInterrupted()){
                    System.out.println("Thread.interrupted()="+ Thread.interrupted());
                    return;
                }
            }
        });

    }
    @Override
    public void run() {

    }
}
