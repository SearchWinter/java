package thread.block;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Description TODO
 **/
public class StorageBlock {
    // 仓库存储的载体
    private LinkedBlockingQueue<Object> list = new LinkedBlockingQueue<>(10);

    public void produce() {
        try{
            //插入指定元素在这个队列的尾部,容量达到最大时，自动阻塞
            list.put(new Object());
            System.out.println("【生产者" + Thread.currentThread().getName()
                    + "】生产一个产品，现库存" + list.size());
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void consume() {
        try{
            //容量为0时，自动阻塞
            list.take();
            list.clear();
            System.out.println("【消费者" + Thread.currentThread().getName()
                    + "】消费了所有产品，现库存" + list.size());
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
