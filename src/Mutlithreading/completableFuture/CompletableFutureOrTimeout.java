package src.Mutlithreading.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static src.util.MyUtil.currentThread;

public class CompletableFutureOrTimeout {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Starting CompletableFutureDemo");

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Worker Thread: " + currentThread());
                Thread.sleep(1500);
            } catch (InterruptedException ignored) {
            }
            return "OK";
        }).orTimeout(1400, TimeUnit.MILLISECONDS).exceptionally(s -> "Timeout Occurred");
        System.out.println(cf1.get());
        System.out.println(currentThread());
    }
}