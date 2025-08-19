package src.Mutlithreading.synchronize;

import java.util.concurrent.Executors;

public class SynchronizedDemo1 {

    final static int NUM_THREADS = 10;
    final static int NUM_ITERATE = 10_000;

    public static void main(String[] args) {

        final var data = new DataHolder();

        final var executor = Executors.newFixedThreadPool(NUM_THREADS);
        for (int i = 0; i < NUM_THREADS; i++) {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < NUM_ITERATE; j++)
                        data.increment();
                }
            });
        }

        System.out.printf("Expected Value: %d, Actual Value: %d", (NUM_THREADS * NUM_ITERATE), data.getData());
        executor.shutdown();
    }
}