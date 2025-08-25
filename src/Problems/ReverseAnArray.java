package src.Problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseAnArray {

    public static void main(String[] args) {

        int[] input = new int[]{10, 20, 30, 40, 50};
        System.out.println("Original Array: " + Arrays.toString(input));

        System.out.println("Original Array: " + Arrays.toString(reverse(input)));

        //System.out.println("Original Array: " + Arrays.toString(reverseUsingCollections(input)));
    }

    public static int[] reverse(int[] input) {
        int[] result = new int[input.length];
        int count = 0;

        for (int i = input.length - 1; i >= 0; i--)
            result[count++] = input[i];
        return result;
    }

    public static int[]  reverseUsingCollections(int[] input) {
        //Exception in thread "main" java.lang.UnsupportedOperationException
        //	at java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:142)
        List<Integer> result = Arrays.stream(input).boxed().toList();


        Collections.reverse(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
