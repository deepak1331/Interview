package src.Mutlithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static src.util.MyUtil.currentThread;

public class ReadWriteCount {

    private int count = 0;

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public int getCount() {
        readLock.lock();
        try {
            return count;
        } finally {
            readLock.unlock();
        }
    }

    public void increment() {
        writeLock.lock();
        try {
            count++;
            //TimeUnit.MILLISECONDS.sleep(new Random().nextInt(10));
            TimeUnit.MILLISECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ReadWriteCount counter = new ReadWriteCount();

        // Runnable writeTask = obj::increment;
        Runnable writeTask = () -> {
            for (int i = 0; i < 10; i++) {
                counter.increment();
                System.out.printf("%s incremented\n", currentThread());
            }
        };

        // Runnable readTask = obj::getCount;
        Runnable readTask = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.printf("%s Count: %d\n", currentThread(), counter.getCount());
            }
        };

        Thread reader1 = new Thread(readTask);
        Thread reader2 = new Thread(readTask);
        Thread writer = new Thread(writeTask);

        writer.start();
        reader1.start();
        reader2.start();

        writer.join();
        reader1.join();
        reader2.join();

        System.out.printf("%s Count: %d\n", currentThread(), counter.getCount());
    }
}
