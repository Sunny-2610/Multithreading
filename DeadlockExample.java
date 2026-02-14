public class DeadlockExample {

    // Two shared lock objects
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {

        // Thread 1
        Thread t1 = new Thread(() -> {

            // Step 1: Thread 1 acquires lock1
            synchronized (lock1) {
                System.out.println("Thread 1: Holding lock1");

                // Pause to allow Thread 2 to acquire lock2
                try { Thread.sleep(100); } catch (Exception e) {}

                // Step 3: Thread 1 tries to acquire lock2
                System.out.println("Thread 1: Waiting for lock2");

                synchronized (lock2) {
                    // This line will NOT execute because of deadlock
                    System.out.println("Thread 1: Holding lock1 and lock2");
                }
            }
        });

        // Thread 2
        Thread t2 = new Thread(() -> {

            // Step 2: Thread 2 acquires lock2
            synchronized (lock2) {
                System.out.println("Thread 2: Holding lock2");

                // Pause to allow Thread 1 to try for lock2
                try { Thread.sleep(100); } catch (Exception e) {}

                // Step 4: Thread 2 tries to acquire lock1
                System.out.println("Thread 2: Waiting for lock1");

                synchronized (lock1) {
                    // This line will NOT execute because of deadlock
                    System.out.println("Thread 2: Holding lock2 and lock1");
                }
            }
        });

        // Start both threads
        t1.start();
        t2.start();
    }
}
