package src.Mutlithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        // Create a fixed-size thread pool with 2 threads
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Submit a Runnable task
        executor.execute(() -> {
            System.out.println("Task 1 executed by thread: " + Thread.currentThread().getName());
        });

        // Submit another Runnable task
        executor.execute(() -> {
            System.out.println("Task 2 executed by thread: " + Thread.currentThread().getName());
        });

        // Shut down the executor service gracefully
        executor.shutdown();
        try {
            // Wait for all tasks to complete or timeout
            boolean result = executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ExecutorService shut down.");
    }
}