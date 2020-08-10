package thread.block;


/**
 * @Description ToDO
 **/
public class Producer implements Runnable {
    private StorageBlock storageBlock;

    public Producer() {
    }

    public Producer(StorageBlock storageBlock, String name) {
        this.storageBlock = storageBlock;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
                storageBlock.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
