package src.Mutlithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//Callable class can only be executed by using Executor Service
//Whereas runnable can be executed using Threads or Executor Service both.

/**
 * With Runnable
 * The Runnable interface is a functional interface and has a single run() method that doesn’t
 * accept any parameters or return any values.
 */
public class CallableDemo implements Callable<String> {
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName();
    }

    public static void main(String[] args) {
        Callable<String> task1 = new CallableDemo();
        Callable<String> task2 = new CallableDemo();
        Callable<String> task3 = new CallableDemo();
        Callable<String> task4 = new CallableDemo();
        Callable<String> task5 = new CallableDemo();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> result1 = executorService.submit(task1);
        executorService.submit(task2);
        executorService.submit(task3);
        executorService.submit(task4);
        executorService.submit(task5);

        executorService.shutdown();
    }
}
