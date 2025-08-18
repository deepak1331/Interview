package src.Mutlithreading.callable;

import java.util.Random;
import java.util.concurrent.*;

public class Callable2 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(() -> {
            try {
                Thread.sleep(999);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return new Random().nextInt(100);
        });

        try {
            if(!future.isDone())
                System.out.println("Result: " +  future.get(1,TimeUnit.SECONDS));
            System.out.println(future.isDone());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("Couldn't complete the task before timeout");
        }
        executor.shutdown();
    }
}
