package src.Problems;

import java.util.Arrays;

public class PutZerosToEnd {

    public static void main(String[] args) {

        // Java Program to move all zeros to end using temporary array
        int[] arr = new int[]{1, 2, 0, 4, 3, 0, 5, 0};
        int[] expectedOutput = new int[]{1, 2, 4, 3, 5, 0, 0, 0};

        print("Input Array: ", arr);
        print("Output Array: ", expectedOutput);

        int[] temp = new int[arr.length];
        print("Temp Array: ", temp);
        //Arrays.fill(temp, 0);
        //print("Temp Array after filling with zero: ", temp);

        int n = 0;
        for (int j : arr) {
            if (j != 0)
                temp[n++] = j;
        }
        print("Temp Array after filling with non-zero numbers at beginning:\n ", temp);
    }

    public static void print(String msg, int[] arr) {
        System.out.print("\n" + msg);
        Arrays.stream(arr).forEach(n -> System.out.printf(" %d", n));
    }
}
