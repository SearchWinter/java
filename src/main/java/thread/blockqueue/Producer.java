package thread.blockqueue;


/**
 * @Description 生产者
 **/
public class Producer implements Runnable {
    private StorageBlock2 storageBlock;

    public Producer() {
    }

    public Producer(StorageBlock2 storageBlock, String name) {
        this.storageBlock = storageBlock;
    }

    @Override
    public void run() {
            //一个生产者执行10次生产方法
            for (int i = 0; i < 10; i++) {
                storageBlock.produce();
            }
    }
}
