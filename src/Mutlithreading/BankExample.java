package src.Mutlithreading;

public class BankExample {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                bankAccount.withdraw(55);
            }
        };

        Thread t1 = new Thread(task, "MyThread_01");
        Thread t2 = new Thread(task, "MyThread_02");

        t1.start();
        t2.start();
    }
}
