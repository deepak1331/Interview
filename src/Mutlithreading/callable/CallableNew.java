package src.Mutlithreading.callable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallableNew {


    public static void main(String[] args) {

        List<Callable<String>> callables = Arrays.asList(
                new MyCallable("Task 1", 2),
                new MyCallable("Task 2", 1),
                new MyCallable("Task 3", 0)
        );


        ExecutorService executorService = Executors.newFixedThreadPool(2);
        try {
            System.out.println(executorService.invokeAll(callables));
        } catch (InterruptedException e) {
        }finally {
            executorService.shutdownNow();
        }
    }
}
