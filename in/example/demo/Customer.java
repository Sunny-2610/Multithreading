package in.example.demo;

public class Customer extends Thread {

    private BankAccount account;

    public Customer(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        account.withdraw(700);
    }
}
