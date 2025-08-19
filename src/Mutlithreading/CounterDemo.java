package src.Mutlithreading;

class Counter {
    int count;

    public synchronized void increment() {
        count++;
    }

    public void show() {
        System.out.printf("Current Count value : %d\n", count);
    }

    public void printTimeElapsed(long startTime) {
        System.out.println("Time taken for execution : " + (System.currentTimeMillis() - startTime));
    }
}

public class CounterDemo {

    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();

        Counter counter = new Counter();
        counter.printTimeElapsed(startTime);
        Runnable obj1 = () -> {
            for (int i = 0; i < 1000; i++)
                counter.increment();
        };

        Runnable obj2 = () -> {
            for (int i = 0; i < 1000; i++)
                counter.increment();
        };

        counter.show();
        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.printf("Current Count value : %d\n", counter.count);
        //counter.show();
        counter.printTimeElapsed(startTime);
    }

}