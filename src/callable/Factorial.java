package src.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Factorial implements Callable<Long> {

    private final int number;

    public Factorial(int number) {
        this.number = number;
    }


    @Override
    public Long call() throws Exception {
        if (number < 0) throw new IllegalArgumentException("Number must be non-negative");

        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
            TimeUnit.MILLISECONDS.sleep(100);
        }
        System.out.printf("\nCurrent Thread Name : %s", Thread.currentThread().getName());
        return result;
    }
}
