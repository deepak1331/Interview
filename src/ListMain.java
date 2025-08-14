package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ListMain {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome to Java 8 Demo");

        /*
         * 1. Constructor Initialization:
         * The most common method involves using the constructor of a specific
         * List implementation and then adding elements using the add() method.
         */
        List<String> list = new ArrayList<>();
        list.add("India");
        list.add("Australia");
        list.add("China");
        list.add("Africa");
        list.add("Ukraine");
        list.add("Ireland");

        list.stream().sorted().forEach(System.out::println);

        System.out.print("\nCountry Name starting with I : ");
        list.stream().filter(a->a.startsWith("I")).forEach(System.out::print);

        /*
         * 2. Arrays.asList():
         * This method is convenient for creating a fixed-size List from an array or a variable number
         * of arguments. The resulting List is backed by the array, meaning structural modifications
         * (like adding or removing elements) are not supported.
         * The Organization of Islamic Cooperation (OIC)
         */
        System.out.println("\nList of few Organization of Islamic Cooperation (OIC): ");
        List<String> oic = Arrays.asList("Iran", "Pakistan", "Afghanistan", "Iraq", "Uzbekistan", "UAE");

        //Below code will throw exception in thread "main" java.lang.UnsupportedOperationException
        //oic.add("Iran");
        oic.stream().sorted().forEach(System.out::print);


        List<String> asian = Stream.of("India", "Pakistan", "Afghanistan", "SriLanka",
                        "Nepal", "Bangladesh", "China")
                .collect(Collectors.toList());

        asian.add("Iran");
        System.out.println("\nSorting Asian countries by their name length: ");
        asian.sort((a, b) -> a.length() - b.length());
        asian.forEach(System.out::println);

        List<Integer> num = Arrays.asList(4,8,2,6,9);

        System.out.println("Min : "+num.stream().min(Integer::compareTo).get());
        System.out.println("Max : "+num.stream().max((x,y)->x.compareTo(y)).get());
    }
}