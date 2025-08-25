package src.Problems;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NumberFrequency {
    public static void main(String[] args) {

        int[] input = new int[]{1, 1, 4, 4, 6, 6, 6, 9, 9, 6, 8, 8, 7, 5, 5, 3};


        System.out.println("Input: " + Arrays.toString(input));

        Map<Integer, Integer> map = new TreeMap<>();

        //For Each way
        for (Integer number : input)
            map.put(number, map.getOrDefault(number, 0) + 1);
        System.out.println("Frequency Count : " + map);

        //Stream way
        Map<Integer, Long> result = Arrays.stream(input).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Frequency Count : " + result);


        String string = "India is a great country I love my country India";
        Map<Character, Long> charCount = string.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Characters Frequency Count : " + charCount);

        Map<String, Long> wordCount = Arrays.stream(string.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Word Frequency Count : " + wordCount);

    }
}
