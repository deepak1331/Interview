package src.Mutlithreading;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountingGroupingMain {

    public static void main(String[] args) {

        String str = "Hello World using Java 8";

        Map<Character, Long> freqMap = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()
                ));
        System.out.println(freqMap);

        String input = "Java is awesome Java is simple";
         Map<String, Long> wordMap = Arrays.stream(input.toLowerCase().split(" ")).collect(Collectors
                .groupingBy(word -> word, Collectors.counting()));
        System.out.println(wordMap);




        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("orange", "grape", "kiwi"),
                Arrays.asList("melon")
        );
        System.out.println(listOfLists);

        //FlatMap
        List<String> fruitList = listOfLists.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(fruitList);

        //Map
        fruitList.stream().map(s -> s.concat(" is my fav fruit")).forEach(System.out::println);


        //reduce
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Summing numbers using reduce with an identity of 0
        int sum = numbers.stream().reduce(0, (a,b)->a+b);
        System.out.println("Sum = "+sum);

        int prod = numbers.stream().reduce(1, (a,b)->a*b);
        System.out.println("Product = "+prod);
    }
}
