package thread.block;


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
        while (!Thread.interrupted()) {
            try {
                Thread.sleep(1000);
                storageBlock.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
