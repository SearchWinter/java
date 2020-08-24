package thread.pool;

/**
 * @Description ToDO
 * @Date 2020/8/20  23:32
 **/
public class TPoolDemo implements Runnable{
    public int index;

    public TPoolDemo(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        System.out.println("***开始处理线程***");
        try {
            Thread.sleep(1*1000);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
