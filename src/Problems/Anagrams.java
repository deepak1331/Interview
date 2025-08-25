package src.Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Anagrams {

// Java Code to group anagrams together by using sorted
// words as keys

    static ArrayList<ArrayList<String>> anagrams(String[] arr) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        HashMap<String, Integer> mp = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];

            // Find the key by sorting the string
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            s = new String(chars);

            // If key is not present in the hash map, add
            // an empty group (ArrayList) in the result and
            // store the index of the group in hash map
            if (!mp.containsKey(s)) {
                mp.put(s, res.size());
                res.add(new ArrayList<>());
            }

            // Insert the string in its correct group
            res.get(mp.get(s)).add(arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        String[] arr = {"act", "god", "cat", "dog", "tac"};

        ArrayList<ArrayList<String>> res = anagrams(arr);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++)
                System.out.print(res.get(i).get(j) + " ");
            System.out.println();
        }
    }
}