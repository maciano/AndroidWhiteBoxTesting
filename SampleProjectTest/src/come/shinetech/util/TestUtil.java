package come.shinetech.util;


public class TestUtil {
    private static final int WAIT_TIME = 500;
    private static final int MAX_ATTEMPTS = 6;

	public static void tryUntil(Wait wait) {
        for (int i = 0; i < MAX_ATTEMPTS; i++) {
            wait.run();
            if (wait.finishedWaiting) {
                return;
            } else {
                try {
                    Thread.sleep(WAIT_TIME);
                } catch (InterruptedException e) { }
            }
        }
    }

    public static abstract class Wait implements Runnable {
        public boolean finishedWaiting;
    }
}
