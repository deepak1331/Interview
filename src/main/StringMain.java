package src.main;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringMain {

    public static void main(String[] args) {

        String s1 = "Java";
        String s2 = new String("Java");
        String s3 = new String("I love coding in Java . Java is my fav coding language");

        // creates a new String "java rules", but does not change s1
        String concatStr = s1.concat(" rules");
        System.out.println("concatStr : "+ concatStr);

        // s1 still refers to "java"
        System.out.println("s1 refers to :" + s1);

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        System.out.println("s2.intern() : " + s2.intern());
        System.out.println(s1.equals(s2.intern()));

        Map<Character, Long> map = s1.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(map);
        Map<String, Long> freqMap = Arrays.stream(s3.split(" ")).collect(Collectors.groupingBy(
                Function.identity(), Collectors.counting()));
        System.out.println(freqMap);

    }
}
