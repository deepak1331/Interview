package src.Mutlithreading;

import java.util.concurrent.Callable;

//Callable class can only be executed by using Executor Service
//Whereas runnable can be executed using Threads or Executor Service both.

/**
 * With Runnable
 * The Runnable interface is a functional interface and has a single run() method that doesn’t
 * accept any parameters or return any values.
 */
public class CallableDemo implements Callable {
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Object call() throws Exception {
        return null;
    }
}
