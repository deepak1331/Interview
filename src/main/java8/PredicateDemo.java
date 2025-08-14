package src.main.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {

        //Predicate<Integer> predicate = (t)-> (t % 2 == 0);
        Predicate<Integer> evenPredicate = t-> t % 2 == 0;
        System.out.printf("Is %d a Even Number: %s\n", 10, evenPredicate.test(10));

        List<Integer> myList = Arrays.asList(90, 10, 17, 34, 56, 89);
        myList.stream().filter(evenPredicate).forEach(System.out::println);
        
    }
}
