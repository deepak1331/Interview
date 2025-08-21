package src.Mutlithreading.completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompletableFutureAllOf {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Starting CompletableFutureDemo");

        CompletableFuture<String> cf1 =
                CompletableFuture.supplyAsync(() -> print(2, '-'));

        CompletableFuture<String> cf2 =
                CompletableFuture.supplyAsync(() -> print(1, '0'));

        try {
            System.out.println(cf1.get(500, TimeUnit.MILLISECONDS));

            System.out.println(cf2.get());
        } catch (TimeoutException ignored) {
        }

        //CompletableFuture<Void> completableFuture = CompletableFuture.allOf(cf1, cf2);
        //completableFuture.join();
        System.out.println(currentThread());
    }

    private static String print(int delay, char ch) {
        for (int i = 0; i < 10000; i++) {
            try {
                System.out.print(ch);
                Thread.sleep(delay);
            } catch (InterruptedException ignored) {
            }
        }
        return String.format("%s :  Delay: %d Char: %s", currentThread(), delay, ch);
    }

    public static String currentThread() {
        return String.format("\nCurrent Thread is :%s", Thread.currentThread().getName());
    }

}