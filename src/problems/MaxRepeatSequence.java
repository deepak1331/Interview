package src.problems;

public class MaxRepeatSequence {

    //Find the length of the longest contiguous sequence of either 1s or 0s in the array.
    //Input: arr[] = [0, 1, 0, 1, 1, 1, 1]	Output = 4

    public static void main(String[] args) {
        int arr[] = new int[]{0, 1, 0, 1, 1, 1, 1};

        System.out.println("Max Sequence: " + getMaxSeq(arr));

    }

    public static int getMaxSeq(int[] arr) {
        int maxCount = 0;
        int count = 1;

        if (arr != null && arr.length > 0) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] == arr[i + 1]) {
                    count++;
                } else {
                    maxCount = Math.max(maxCount, count);
                    count = 1;
                }
            }
        }
        return Math.max(maxCount, count);
    }
}