package src.Mutlithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CompletableFutureGetNow {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Starting CompletableFutureDemo");

        CompletableFuture<String> result =
                CompletableFuture.supplyAsync(CompletableFutureGetNow::wait_Print);
        try {
            System.out.println(result.get(5000, TimeUnit.MILLISECONDS));
        } catch (TimeoutException ignored) {
        }
        System.out.println(result.getNow("Calculation In progress"));
        System.out.println(currentThread());
    }

    public static String wait_Print() {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(currentThread());

        for (int i = 1; i < 11; i++) {
            try {
                stringBuilder.append("\nLoop: ").append(i);
                Thread.sleep(499);
            } catch (InterruptedException ignored) {
            }
        }
        return stringBuilder.toString();
    }

    public static String prettyPrint() {
        return "PrettyPrint";
    }

    public static String currentThread() {
        return String.format("\nCurrent Thread is : %s", Thread.currentThread().getName());
    }

}

