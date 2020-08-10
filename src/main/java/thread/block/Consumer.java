package thread.block;


/**
 * @Description ToDO
 **/
public class Consumer implements Runnable {
    private StorageBlock storageBlock;

    public Consumer() {
    }

    public Consumer(StorageBlock storageBlock, String name) {
        this.storageBlock = storageBlock;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(3000);
                storageBlock.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
