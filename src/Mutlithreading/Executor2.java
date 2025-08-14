package src.Mutlithreading;

import java.util.concurrent.*;

public class Executor2 {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        long startTime = System.currentTimeMillis();
        executorService.execute(()->{
            System.out.println(Thread.currentThread().getName());
        });
        executorService.execute(()->{
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
            }
        });

        Future<String> result = executorService.submit(() -> Thread.currentThread().getName());

        try {
            System.out.println(result.get());
            executorService.shutdown();
            System.out.println("Shutdown called for firstTime: "+(System.currentTimeMillis()-startTime));
            boolean isTerminated = executorService.awaitTermination(2, TimeUnit.SECONDS);
            if(!isTerminated){
                executorService.shutdownNow();
                System.out.println("Shutdown Finished => ShutdownNow() called!");
            }
        } catch (InterruptedException | RuntimeException | ExecutionException r) {
            r.printStackTrace();
        }finally {
            //executorService.shutdown();
            System.out.println("Shutdown called finally after Time: "+(System.currentTimeMillis()-startTime));

        }
    }
}
