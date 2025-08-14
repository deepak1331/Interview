package src.Mutlithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Executor2 {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(()->{
            System.out.println(Thread.currentThread().getName());
        });
        executorService.execute(()->{
            System.out.println(Thread.currentThread().getName());
        });
        Future<String> result = executorService.submit(() -> Thread.currentThread().getName());
        try {
            System.out.println(result.get());
        } catch (InterruptedException | RuntimeException | ExecutionException r) {
            r.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }
}
