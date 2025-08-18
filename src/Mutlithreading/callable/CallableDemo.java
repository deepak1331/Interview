package src.Mutlithreading.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {

    public static void main(String[] args) {
        // Create an ExecutorService with a fixed thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Create Callable tasks
        Factorial task1 = new Factorial(5);
        Factorial task2 = new Factorial(7);
        Factorial task3 = new Factorial(4);
        Factorial task4 = new Factorial(6);

        // Submit the tasks to the ExecutorService and get Future objects
        Future<Long> future1 = executorService.submit(task1);
        Future<Long> future2 = executorService.submit(task2);
        Future<Long> future3 = executorService.submit(task3);
        Future<Long> future4 = executorService.submit(task4);

        try {
            System.out.println("Factorial of 5 : " + future1.get());
            System.out.println("Factorial of 7 : " + future2.get());
            System.out.println("Factorial of 6 : " + future4.get());
            System.out.println("Factorial of 4 : " + future3.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        catch (IllegalArgumentException e){
            System.out.println("Unable to calculate Factorial of a negative number");
        }
        finally {
            // Shut down the ExecutorService
            executorService.shutdown();
        }
    }
}
