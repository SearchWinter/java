package thread.ThreadFactoryDemo;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 线程工厂、
 * @Date 2020/8/13  15:11
 **/
 class ThreadFactoryTest implements ThreadFactory {

     private AtomicInteger threadNum=new AtomicInteger(0);
    @Override
    public Thread newThread(Runnable r) {
        return null;
    }
}
