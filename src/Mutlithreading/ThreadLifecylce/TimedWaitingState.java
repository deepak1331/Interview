package src.Mutlithreading.ThreadLifecylce;

import java.util.concurrent.TimeUnit;

public class TimedWaitingState {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new TimeWaitingRunnable());
        System.out.println(t1.getState()); //NEW
        t1.start();
        System.out.println(t1.getState()); //Runnable
        // The following sleep will give enough time for ThreadScheduler
        // to start processing of thread t1
        Thread.sleep(1000);
        System.out.println(t1.getState()); //TIMED_Waiting

        Thread.sleep(3999);
        System.out.println(t1.getState()); //Runnable
        Thread.sleep(15);
        System.out.println(t1.getState()); //TERMINATED
    }
}


class TimeWaitingRunnable implements Runnable {

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
