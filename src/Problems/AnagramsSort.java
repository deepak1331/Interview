package src.Problems;

import java.util.*;

public class AnagramsSort {

    public static void main(String[] args) {
        String[] arr = {"act", "god", "cat", "dog", "tac"};

        List<List<String>> res = anagrams(arr);
        System.out.println(res);
    }

    private static List<List<String>> anagrams(String[] arr) {
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        if (arr != null) {
            for (String s : arr) {
                String sortedStr = sortedWord(s);
                if (!map.containsKey(sortedStr)) {
                    map.put(sortedStr, result.size());
                    result.add(new ArrayList<>());
                }
                result.get(map.get(sortedStr)).add(s);
            }
        }
        return result;
    }

    public static String sortedWord(String str) {
        if (str != null) {
            char[] chars = str.toLowerCase().toCharArray();
            Arrays.sort(chars);
            //str = Arrays.toString(chars);
            //System.out.println("Sorted word: " + str);
            return Arrays.toString(chars);
        }
        return null;
    }
}
