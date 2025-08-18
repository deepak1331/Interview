package src.Mutlithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorForLoopDemo {

    public static void main(String[] args) throws InterruptedException {
        int threadsNumber = Runtime.getRuntime().availableProcessors();
        System.out.println("threadsNumber : "+threadsNumber);
        List<Runnable> runnables = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(threadsNumber);
        for (int i = 0; i < 20; i++) {
            runnables.add(ExecutorForLoopDemo::print);
           /* executorService.submit(() -> System.out.println("Hello from: " + Thread.currentThread().getName()));
            TimeUnit.SECONDS.sleep(1);*/
        }
        runnables.parallelStream().forEach(executorService::execute);
        executorService.submit(() -> System.out.println("Another task executed by " + Thread.currentThread().getName()));
        executorService.shutdown();
    }

    public static void print() {
        System.out.println("Hello from: " + Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
