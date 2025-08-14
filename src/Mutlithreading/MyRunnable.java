package src.Mutlithreading;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Current thread name: "
                + Thread.currentThread().getName());
        System.out.println("run() method called");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        t1.setName("Thread 001");

        Thread t2= new Thread(new MyRunnable());
        t1.setName("Thread 0012");
        Thread t3 = new Thread(MyRunnable::new);
        t2.setName("Lambda::new");

//        t1.start();
//        t2.start();
        t1.run();
        t2.run();
        t3.start();
    }

    public static void currentThread() {
        System.out.printf("\nCurrent thread name: %s", Thread.currentThread().getName());
    }
}
