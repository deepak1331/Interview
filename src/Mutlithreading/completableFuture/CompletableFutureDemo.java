package src.Mutlithreading.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Starting CompletableFutureDemo");

        /*CompletableFuture<String> workedThread = CompletableFuture.supplyAsync(() -> {
            System.out.println("Worked Thread");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ignored) {
            }
            return "OK";
        });
        //System.out.println(workedThread.get());
        */
        //Using lambda same be done as following:
        CompletableFuture<String> result = CompletableFuture.supplyAsync(CompletableFutureDemo::wait_Print);
        //System.out.println(result.getNow("Not ready yet"));
        try {
            System.out.println(result.get(1000, TimeUnit.MILLISECONDS));
        } catch (TimeoutException ignored) {
        }

        System.out.println(currentThread());
    }

    public static String wait_Print() {
        try {
            System.out.println("Inside Worker Thread" + currentThread());
            Thread.sleep(2500);
        } catch (InterruptedException ignored) {
        }
        return "Worked Thread Completed";
    }

    public static String currentThread() {
        return String.format("\nCurrent Thread is : %s", Thread.currentThread().getName());
    }

}

