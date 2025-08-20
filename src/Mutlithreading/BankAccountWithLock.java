package src.Mutlithreading;

import src.Mutlithreading.ThreadLifecylce.Bank;
import src.util.MyUtil;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static src.util.MyUtil.currentThread;
import static src.util.MyUtil.getTimeTaken;

public class BankAccountWithLock implements Bank {

    private int balance = 100;

    private final Lock lock = new ReentrantLock();

    //Extrinsic/Manual locking mechanism implemented via Lock Interface implementations
    public void withdraw(int amount) {
        System.out.printf("%s attempting to withdraw Rs. %d\n", currentThread(), amount);
        long startTime = System.currentTimeMillis();
        try {
            // if (lock.tryLock()) {
            if (lock.tryLock(4050, TimeUnit.MILLISECONDS)) {
                System.out.printf("%s > acquired lock in %d ms\n", currentThread(), getTimeTaken(startTime));
                if (balance >= amount) {
                    System.out.printf("%s proceeding with withdrawal\n", currentThread());
                    try {
                        //to simulate  complex processing
                        Thread.sleep(2000);
                        balance -= amount;
                        System.out.printf("%s withdrawal completed. Available Balance Rs. %d\n", currentThread(), balance);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println(MyUtil.currentThreadAndState());
                    } finally {
                        lock.unlock();
                        System.out.printf("%s > released lock. Txn Time: %d ms\n", currentThread(), getTimeTaken(startTime));
                    }
                } else {
                    System.out.printf("%s insufficient balance.\n", currentThread());
                }
            } else {
                System.out.printf("%s could not acquire lock, will try later\n", currentThread());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(MyUtil.currentThreadAndState());
        }
    }
}

