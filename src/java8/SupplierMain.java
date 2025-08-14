package src.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierMain {

    public static void main(String[] args) {

        Supplier<String> supplier = ()-> "Hello World";
        System.out.println(supplier.get());

        List<String> list = Arrays.asList("Abc", "Xyz");
        List<String> list2 = Arrays.asList();
       // System.out.println(Stream.of("India", "Australia").findAny().orElseGet(supplier));
        System.out.println(list.stream().findAny().orElseGet(supplier));
        System.out.println(list2.stream().findAny().orElseGet(supplier));
    }
}
