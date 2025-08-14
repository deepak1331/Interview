package src.Mutlithreading;

import java.util.Random;

class MultiThreading implements Runnable {

    int num;
    long delay;

    public MultiThreading(int num, long delay) {
        this.num = num;
        this.delay = delay;
    }

    public void run() {
        for (int i = 1; i < 11; i++) {
            System.out.printf("\n%s => %d X %d = %d", Thread.currentThread().getName(), num, i, num * i);
            try {
                Thread.sleep(delay * 500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

public class MyRunnableMain {
    public static void main(String[] args) {

        Random random = new Random();

        Thread t1 = new Thread(new MultiThreading(random.nextInt(10), random.nextInt(3)));
        Thread t2 = new Thread(new MultiThreading(random.nextInt(10), random.nextInt(3)));
        Thread t3 = new Thread(new MultiThreading(random.nextInt(10), random.nextInt(3)));
        Thread t4 = new Thread(new MultiThreading(random.nextInt(10), random.nextInt(3)));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}