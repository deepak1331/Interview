package src.problems;

import java.util.List;

/*
Write a Java method that takes a array of strings and groups the anagrams together.
Example 1:
Input: ["eat", "tea", "tan", "ate", "nat", "bat"]
Output: [
  ["eat", "tea", "ate"],
  ["tan", "nat"],
  ["bat"]
]
 */
public class demo {

    public static void main(String[] args) {
        String[] arr= new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};


    }

    public static List<List<String>> anagrams(String[] arr){
        if(arr!=null && arr.length>0){
            for(int i=0;i<arr.length;i++){
                char[] word = arr[i].toCharArray();
                for(int j=0;j<word.length;j++){


                }
            }
            return null;
        }else{
            return null;
        }
       /*
        Arrays.stream(arr).toList().forEach(ch ->{
            if(ch.s)
        });*/
    }
}
