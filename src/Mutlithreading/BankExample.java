package src.Mutlithreading;

import src.Mutlithreading.ThreadLifecylce.Bank;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class BankExample {
    public static void main(String[] args) {

        final int NUM_THREADS = Runtime.getRuntime().availableProcessors();

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

        ExecutorService executors = Executors.newFixedThreadPool(4);

        IntStream.range(0, 4).forEach(i -> executors.submit(task));

        /*Thread t1 = new Thread(task, "MyThread_01");
        Thread t2 = new Thread(task, "MyThread_02");
        Thread t3 = new Thread(task, "MyThread_03");
        Thread t4 = new Thread(task, "MyThread_04");

        t1.start();
        t2.start();
        t3.start();
        t4.start();*/
    }
}
