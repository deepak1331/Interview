package src.Mutlithreading.synchronize;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class SynchronizedDemo1 {

    final static int NUM_THREADS = 5;
    final static int NUM_ITERATE = 10_00;

    public static void main(String[] args) {

        final var data = new DataHolder();

        final var executor = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_THREADS; i++) {
            try {
                executor.submit(new Runnable() {
                    @Override
                    public void run() {
                        for (int j = 0; j < NUM_ITERATE; j++)
                            data.increment();
                    }
                }).get(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            } catch (TimeoutException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.printf("Expected Value: %d, Actual Value: %d", (NUM_THREADS * NUM_ITERATE), data.getData());
        executor.shutdownNow();
    }
}