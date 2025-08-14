package src.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MapTransform {

    public static void main(String[] args) {


        List<String> mobileNumbers = Arrays.asList("7401087954", "9005130688", "7401089954", "9005136688", "7406687954", "9565130688");

        List<List<String>> mobileNumbers2 = Arrays.asList(
                Arrays.asList("7401087954", "9005130688"),
                Arrays.asList("7401089954", "9005136688"),
                Arrays.asList("7406687954", "9565130688"));


        System.out.println("Mobile Numbers (without country code) : "+ mobileNumbers);

        List<String> mobileNumbersWithCode = mobileNumbers.stream().map("+91 "::concat).toList();

        System.out.println("Mobile Numbers (with country code) : "+ mobileNumbersWithCode);

        List<String> mobileNumbersFlattened = mobileNumbers2.stream().flatMap(List::stream)
                .map("00-"::concat).toList();

        System.out.println("Mobile Numbers (nested) : "+ mobileNumbers2);
        System.out.println("Mobile Numbers (Flattened ) : "+ mobileNumbersFlattened);


        List<Integer> numbers = IntStream.range(0, 11).boxed().toList();
        List<String> stringList = numbers.stream().map(String::valueOf).toList();

        System.out.printf("list of numbers: %s \nList of string: %s", numbers, stringList);

    }
}
