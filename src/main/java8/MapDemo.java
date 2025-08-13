package src.main.java8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapDemo {

    public static void main(String[] args) {


        Map<String, Integer> fruitMap = new HashMap<>();
        fruitMap.put("Papaya", 10);
        fruitMap.put("Fig", 19);
        fruitMap.put("Mango", 6);
        fruitMap.put("Apple", 50);
        fruitMap.put("Watermelon", 25);

        fruitMap.merge("Apple", 40, (oldValue, newValue)->oldValue);

        print("Before Sorting",fruitMap);

        Map<String, Integer> sortedbyValueFruitMap = fruitMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                //.sorted(Map.Entry.comparingByValue()) // for ascending order
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        // Merge function for duplicate keys (not relevant for sorting)
                        LinkedHashMap::new)); //to Ensure insertion order is maintained

        print("\nAfter Sorting",sortedbyValueFruitMap);

        fruitMap.keySet().stream().sorted().forEach(k->System.out.printf("\n "+k));
        fruitMap.values().stream().sorted(Comparator.reverseOrder()).forEach(k->System.out.printf("\n "+k));

    }

    public static void print(String msg, Map<String, Integer> map) {
        System.out.println(msg);
       /* map.entrySet().forEach(e ->
                System.out.printf("\n%d units available in stock of %s", e.getValue(), e.getKey()));*/
         map.forEach((k, v) -> System.out.printf("\n%d units available in stock of %s", v, k));
    }
}
