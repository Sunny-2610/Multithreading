package ac.cooler.demo;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    private int count = 0;

    // Create lock object
    private ReentrantLock lock = new ReentrantLock();

    public void increment() {

        lock.lock();  // acquire lock

        try {
            for (int i = 0; i < 5; i++) {
                count++;
                System.out.println(Thread.currentThread().getName()
                        + " incremented count to: " + count);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock();   // always release lock
        }
    }
}
