package src.Mutlithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

class Count implements Runnable {
    static int counter = 0;

    public void increment() {
        counter++;
        System.out.printf("Current Value: %d, Updated By: %s\n", counter, Thread.currentThread().getName());
    }

    @Override
    public void run() {
        increment();
    }
}

public class RaceCondition2Demo {

    public static void main(String[] args) {


        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Count count = new Count();
        count.increment();

        IntStream.range(0, 100).forEach(i -> executorService.submit(count::increment));
        //IntStream.range(0, 100).forEach(i ->new Thread(count::increment).start());


        executorService.shutdown();
    }
}
