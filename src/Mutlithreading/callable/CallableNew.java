package src.Mutlithreading.callable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallableNew {


    public static void main(String[] args) {

        List<Callable<String>> callables = Arrays.asList(
                new MyCallable("Task 1", 2),
                new MyCallable("Task 2", 4),
                new MyCallable("Task 3", 6)
        );


        ExecutorService executorService = Executors.newFixedThreadPool(2);
        try {
            System.out.println(executorService.invokeAny(callables));
        } catch (InterruptedException | ExecutionException e) {
        }finally {
            executorService.shutdownNow();
        }
    }
}
