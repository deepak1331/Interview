package src.Mutlithreading;

class Multithreading extends Thread {
    public void run() {
        try {
            // Displaying the thread that is running
            System.out.printf("\nThread %s is running", Thread.currentThread().getName());
        } catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
}

class MultiThreadingClass extends Thread {
    public void run() {
        System.out.printf("Current Thread Details" +
                        "\nName: %s" +
                        "\nThreadGroup: %s" +
                        "\nClass(): %s" +
                        "\nId: %s" +
                        "\nisDaemon: %s" +
                        "\nisAlive: %s",
                Thread.currentThread().getName(),
                Thread.currentThread().getThreadGroup(),
                Thread.currentThread().getClass(),
                Thread.currentThread().getId(),
                Thread.currentThread().isDaemon(),
                Thread.currentThread().isAlive());
    }
}

public class MyThread {
    public static void main(String[] args) {
        MultiThreadingClass t1 = new MultiThreadingClass();
        t1.start();

        for (int i = 1; i < 11; i++) {
            Multithreading thread = new Multithreading();
            thread.start();
        }
    }
}
