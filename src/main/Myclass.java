package src.main;

import java.util.Arrays;

public class Myclass {

    public static void main(String[] args) {

        // Java Program to move all zeros to end using temporary array
        int arr[] = new int[]{1, 2, 0, 4, 3, 0, 5, 0};
        int expectedOutput[] = new int[]{1, 2, 4, 3, 5, 0, 0, 0};
        print("Input Array: ", arr);
        print("Output Array: ", expectedOutput);
        int len = arr.length;
        int temp[] = new int[len];
        print("Temp Array: ", temp);
        //Arrays.fill(temp, 0);
        //print("Temp Array after filling with zero: ", temp);

        int n =0;
        for(int i=0;i<len;i++){
            if(arr[i]!=0)
                temp[n++]=arr[i];
        }
        print("Temp Array after filling with non-zero numbers at beginning:\n ", temp);
    }

    public static void print(String msg, int arr[]) {
        System.out.print("\n" + msg);
        Arrays.stream(arr).forEach(n -> System.out.print(" " + n));
    }
}
