package src.Mutlithreading.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class MyCallable implements Callable<String> {
    private String name;
    private int delay;

    public MyCallable(String name, int delay) {
        this.name = name;
        this.delay = delay;
    }

    public String getName() {
        return name;
    }

    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(delay);
        return name;
    }

    @Override
    public String toString() {
        return "MyCallable{" +
                "name='" + name + '\'' +
                ", delay=" + delay +
                '}';
    }
}