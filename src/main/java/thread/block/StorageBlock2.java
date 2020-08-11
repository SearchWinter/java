package thread.block;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 数据存储载体 生产和消费方法
 **/
public class StorageBlock2 {
    // 仓库存储的载体
    private Queue<Integer> queue = new ArrayDeque<>(10);
    //整形原子类，多个线程操作同一数据保持顺序；前一线程还未结束，后一线程看到的数据可能是还未更改的
    //https://www.cnblogs.com/aimei/p/12200367.html
    private AtomicInteger start =new AtomicInteger(0);

    public void produce() {
        //自增
        int i = start.getAndIncrement();
        queue.add(i);
        System.out.println("【生产" + Thread.currentThread().getName() + "】生产一个产品，现库存" + queue.size());
    }

    public void consume() {
        //返回并移除队列的第一个元素
        if(!queue.isEmpty()) {
            queue.poll();
            System.out.println("【消费者" + Thread.currentThread().getName() + "】消费了一个产品,现库存" + queue.size());
        }else {
            System.out.println(Thread.currentThread().getName()+"库存为0，请等待。");
        }
    }
}
