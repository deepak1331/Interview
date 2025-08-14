package src;

import java.util.Optional;

public class OptionalMain {
    public static void main(String[] args) {

        Optional<String> str = Optional.empty();
        str = Optional.of("Tiger");
        System.out.println("str: " + str
                + " Optional.isPresent() : " + str.isPresent()
                + " Optional.isEmpty() : " + str.isEmpty());

        //However, the argument passed to the of() method can’t be null.
        // Otherwise, we’ll get a NullPointerException:
        Optional<String> nameOptional = Optional.of("Deepak");
        System.out.println(nameOptional);

        //But in case we expect some null values, we can use the ofNullable() method:
        String name = null;
        Optional<String> opt = Optional.ofNullable(name);
        System.out.println(opt);


        Optional<String> opt1 = Optional.of("India");
        opt1.ifPresent(s -> System.out.println(s + " length = " + s.length()));

        String nullName = null;
        name = Optional.ofNullable(nullName).orElse("Default Name");
        System.out.println(name);

        name = Optional.ofNullable(nullName).orElseGet(() -> "john");
        System.out.println(name);
    }
}