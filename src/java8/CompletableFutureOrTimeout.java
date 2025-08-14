package src.java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureOrTimeout {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Starting CompletableFutureDemo");

        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Worked Thread");
                Thread.sleep(1500);
            } catch (InterruptedException ignored) {
            }
            return "OK";
        }).orTimeout(1501, TimeUnit.MILLISECONDS).exceptionally(s-> "Timeout Occurred");
        System.out.println(cf1.get());
        System.out.println("Main");

    }
}