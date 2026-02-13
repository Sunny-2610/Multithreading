package ac.cooler.demo;

//This is file which contain main class
public class Test {

    public static void main(String[] args) {

        Counter counter = new Counter();

        Worker t1 = new Worker(counter);
        Worker t2 = new Worker(counter);

        t1.setName("Thread-1");
        t2.setName("Thread-2");

        t1.start();
        t2.start();
    }
}
