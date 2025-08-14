package src.java8;

import java.util.stream.IntStream;

public class PredicateDemo {
    public static void main(String[] args) {

        //Predicate<Integer> predicate = (t)-> (t % 2 == 0);
        /*Predicate<Integer> evenPredicate = t-> t % 2 == 0;
        System.out.printf("Is %d a Even Number: %s\n", 10, evenPredicate.test(10));

        List<Integer> myList = Arrays.asList(90, 10, 17, 34, 56, 89);
        myList.stream().filter(evenPredicate).forEach(System.out::println);


        System.out.printf("Is %d a Prime Number: %s\n", 99993, MyUtil.isPrime(99993));*/


        long startTime1 = System.currentTimeMillis();
        IntStream.rangeClosed(2, 100000).forEach(n ->
                System.out.printf("Is %d a Prime Number: %s\n", n, MyUtil.isPrime(n)));
        long endTime1 = System.currentTimeMillis();


        long startTime2 = System.currentTimeMillis();
        IntStream.rangeClosed(2, 100000).forEach(n ->
                System.out.printf("Is %d a Prime Number: %s\n", n, MyUtil.isPrimeOpt(n)));
        long endTime2 = System.currentTimeMillis();


        System.out.printf("\nTime taken to execute MyUtil.isPrime: %d ms", endTime1 - startTime1);
        System.out.printf("\nTime taken to execute MyUtil.isPrimeOpt: %d ms", endTime2 - startTime2);


        System.out.printf("\nTotal Time taken to execute : %d ms", endTime2 - startTime1);


    }
}
