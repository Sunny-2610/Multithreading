package in.example.demo;

public class BankAccount {

    private int balance = 1000;

    // synchronized method
    public synchronized void withdraw(int amount) {

        System.out.println(Thread.currentThread().getName() + " is trying to withdraw " + amount);

        if (balance >= amount) {
            System.out.println("Processing withdrawal...");

            try {
                Thread.sleep(1000);   // simulate delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}
