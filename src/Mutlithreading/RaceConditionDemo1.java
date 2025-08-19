package src.Mutlithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/*
class MyClass implements Runnable {
 private static int count = 0;
    @Override
    public void run() {
        System.out.printf("Current Thread: %s.\tCount: %d", Thread.currentThread().getName(), count++);
    }
 }
 */


public class RaceConditionDemo1 {
    private static int count = 0;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        IntStream.range(0, 10000).forEach(i -> executorService.submit(RaceConditionDemo1::increment));

        RaceConditionDemo1.show();

        executorService.shutdown();
    }

    private static synchronized void increment() {
        count++;
    }

    public static void show() {
        System.out.printf("Current Thread: %s.\tCount: %d", Thread.currentThread().getName(), count);
    }
}
