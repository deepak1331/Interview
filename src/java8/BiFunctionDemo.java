package src.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class BiFunctionDemo {

    public static void main(String[] args) {

        List<String> list1 = Arrays.asList("a","b", "c", "d", "e");
        List<Integer> list2 = Arrays.asList(1, 2, 3,4, 5);

        List<String> result = new ArrayList<>();
        for (int i=0; i < list1.size(); i++) {
            result.add(list1.get(i) + list2.get(i));
        }

        System.out.println(result);
        result = null;

        result = listCombiner(list1, list2, (letter, number)-> number+letter+number);

        System.out.println(result);

    }
    private static <T, U, R> List<R> listCombiner(
            List<T> list1, List<U> list2, BiFunction<T, U, R> combiner) {
        List<R> result = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            result.add(combiner.apply(list1.get(i), list2.get(i)));
        }
        return result;
    }
}
