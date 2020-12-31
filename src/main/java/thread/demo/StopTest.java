package thread.demo;

/**
 * Created by anjunli on  2020/12/31
 **/
public class StopTest {
    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        testThread.run();

        Thread thread = new Thread(new TestThread());
        thread.setDaemon(true);
        thread.run();
    }
}
