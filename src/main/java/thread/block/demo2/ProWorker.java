package thread.block.demo2;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Description TODO
 * @Date 2020/8/10  18:30
 **/
public class ProWorker implements Runnable{
    public static final int MAX_SIZE=10;
    public static BlockingDeque<Integer> queue=new LinkedBlockingDeque<>(MAX_SIZE);

    @Override
    public void run() {

    }
}
