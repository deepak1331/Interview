package src.Mutlithreading;

import src.Mutlithreading.ThreadLifecylce.Bank;

public class BankExample {
    public static void main(String[] args) {

        //Intrinsic Locking - Synchronized
        //Bank  bankAccount = new BankAccountSynchronized();

        //Extrinsic locking - Reentrant Lock
        Bank bankAccount = new BankAccountWithLock();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                bankAccount.withdraw(25);
            }
        };

        Thread t1 = new Thread(task, "MyThread_01");
        Thread t2 = new Thread(task, "MyThread_02");
        Thread t3 = new Thread(task, "MyThread_03");
        Thread t4 = new Thread(task, "MyThread_04");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
