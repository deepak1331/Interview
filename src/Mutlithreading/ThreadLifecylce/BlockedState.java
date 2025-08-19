package src.Mutlithreading.ThreadLifecylce;

import java.util.concurrent.TimeUnit;

public class BlockedState {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new DemoBlockedRunnable());
        Thread t2 = new Thread(new DemoBlockedRunnable());

        t1.start();
        t2.start();

        Thread.sleep(500);

        System.out.printf("Thread Name: %s and State: %s\n",
                t2.getName(), t2.getState());
        System.exit(0);
    }
}

class DemoBlockedRunnable implements Runnable {
    @Override
    public void run() {
        commonResource();
    }

    /*public static synchronized void commonResource() {
        while(true) {
            // Infinite loop to mimic heavy processing
            // 't1' won't leave this method
            // when 't2' try to enter this

        }
    }*/

    public static synchronized void commonResource() {

        System.out.printf("Current Thread Name: %s and State: %s\n",
                Thread.currentThread().getName(),Thread.currentThread().getState());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}