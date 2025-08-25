package src.Problems;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MissingNumber {

    public static void main(String[] args) {

        int[] array = new int[]{1,2,2,6,8,9,6,6,4,7};

       Set<Integer> sorted =  Arrays.stream(array).boxed().collect(Collectors.toSet());

        IntStream.rangeClosed(1, 9).filter(i->!sorted.contains(i)).forEach(System.out::println);
    }
}
