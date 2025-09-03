package src.Problems;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * ["apple", "banana", "apple", "orange"]
 */
public class MarriotTest {

    public static void main(String[] args) {
        ArrayList<String> mylist = new ArrayList<>();
        mylist.add("apple");
        mylist.add("banana");
        mylist.add("apple");
        mylist.add("orange");

        Map<String, Long> result = mylist.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(result);
    }
}
