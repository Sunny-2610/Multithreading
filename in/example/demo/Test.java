package in.example.demo;

public class Test {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        Customer c1 = new Customer(account);
        Customer c2 = new Customer(account);

        c1.setName("Customer 1");
        c2.setName("Customer 2");

        c1.start();
        c2.start();
    }
}
