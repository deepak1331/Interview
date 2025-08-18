package src.Mutlithreading;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorDemo {

    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        Runnable task = () -> System.out.println("\nExecuting: " + Thread.currentThread().getName());

        ScheduledFuture<?> future = scheduledExecutorService.schedule(task, 3, TimeUnit.SECONDS);
        Thread.sleep(1500);

        System.out.printf("\nRemaining Delay: %d", future.getDelay(TimeUnit.MILLISECONDS));

       // scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println(new Date()),
              //  0,1,TimeUnit.SECONDS);

        scheduledExecutorService.scheduleWithFixedDelay(() -> System.out.println(new Date()),
                0,500,TimeUnit.MILLISECONDS);

    }
}
