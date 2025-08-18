package src.Mutlithreading.callable;

import java.util.concurrent.*;

public class CallableisDone {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Callable<String> task1 = () -> {
            TimeUnit.SECONDS.sleep(2);
            return Thread.currentThread().getName();
        };
        Callable<String> task2 = () -> {
            TimeUnit.SECONDS.sleep(2);
            return Thread.currentThread().getName();
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(task2);
        Future<String> result = executorService.submit(task1);
        System.out.printf("\nIsDone: %s, isCancelled: %s ThreadName: %s",
                result.isDone(), result.isCancelled(), Thread.currentThread().getName());


        boolean isTerminated = executorService.awaitTermination(3, TimeUnit.SECONDS);
        if (!isTerminated) {
            executorService.shutdownNow();
            System.out.printf("\nFuture<String> value: %s, IsDone: %s, isCancelled: %s ThreadName: %s\n", result.get(),
                    result.isDone(), result.isCancelled(), Thread.currentThread().getName());
            System.out.println("Shutting Down !");
        }

    }
}
