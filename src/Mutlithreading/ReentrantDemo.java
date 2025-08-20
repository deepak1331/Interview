package src.Mutlithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantDemo {

    private final Lock lock = new ReentrantLock();

    public void outerMethod() {
        lock.lock();
        try {
            System.out.println("Outer Method");
            innerMethod();
        } finally {
            lock.unlock();
            System.out.println("unlocked by outer method");
        }
    }

    public void innerMethod() {
        lock.lock();
        try {
            System.out.println("Inner Method");
        } finally {
            lock.unlock();
            //lock.unlock();
            System.out.println("unlocked by inner method");
        }
    }

    public static void main(String[] args) {

        ReentrantDemo obj = new ReentrantDemo();
        obj.outerMethod();
    }
}
