package thread.block;


import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 数据存储载体 生产和消费方法
 **/
public class StorageBlock2 {
    // 仓库存储的载体  线程安全
    public static LinkedBlockingQueue<Integer> lbqueue = new LinkedBlockingQueue<>();
    //非线程安全
    public static Queue<Integer> queue = new ArrayDeque<>(10);

    //整形原子类，多个线程操作同一数据保持顺序；前一线程还未结束，后一线程看到的数据可能是还未更改的
    private AtomicInteger start = new AtomicInteger(0);

    public void produce() throws InterruptedException {
        //获取当前值，并自增
        int i = start.getAndIncrement();
//        queue.add(i);
        lbqueue.put(i);
    }

    public void consume() throws InterruptedException {
        //返回并移除队列的第一个元素
        if (!queue.isEmpty()) {
//            Integer poll = queue.poll();
//            System.out.println(poll);
            lbqueue.take();
        }
    }
}
