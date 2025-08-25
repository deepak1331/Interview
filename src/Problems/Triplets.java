package src.Problems;

import java.util.ArrayList;

/**
 * Given an array of integers, return all triplets [a, b, c] such that a + b + c = 0 .
 * The solution must not contain duplicate triplets (e.g., [1, 2, 3] and [2, 3, 1] are
 * considered duplicates). If no such triplets are found, return an empty array. *
 * Each triplet can be arranged in any order, and the output can be returned in any order.
 * Input [-1,1,2,3,-3,5,-2]
 * Output eg [-2,-1,3]
 */
public class Triplets {

    public static void main(String[] args) {

        int[] input = new int[]{-1, 1, 2, 3, -3, 5, -2};
        ArrayList<ArrayList<Integer>> outputList = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = i; j < input.length; j++) {
                for (int k = j; k < input.length; k++) {
                    if (input[i] + input[j] + input[k] == 0) {
                        ArrayList<Integer> output = new ArrayList<>();
                        output.add(input[i]);
                        output.add(input[k]);
                        output.add(input[j]);
                        outputList.add(output);
                    }
                }
            }
        }
        System.out.println("Triplets combinations with sum ZERO (a + b + c = 0) are as follows: ");
        outputList.forEach(System.out::println);
    }
}
