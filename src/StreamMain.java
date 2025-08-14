package src;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Stream.builder;

public class StreamMain {
    public static void main(String[] args) throws IOException {


        /*
        There are many ways to create a stream instance of different sources. Once created, the instance
        will not modify its source, therefore allowing the creation of multiple instances from a single source.
         */

        //Empty Stream
        Stream<Object> emptyStream = Stream.empty();
        System.out.println("Empty Stream size : " + emptyStream.count());


        //Stream Builder of Object type
        Stream<Object> s1 = builder().add("India").add("Africa").add(100).build();
        s1.forEach(System.out::println);


        //Stream Builder of String type
        Stream<String> s2 = Stream.<String>builder().add("India").add("Nepal").add("Africa").add("Nepal").build();
        s2.sorted().forEach(System.out::println);

        String[] country = new String[]{"India", "Nepal", "Africa", "Nepal", "China"};
        Stream<String> s3 = Stream.of(country);
        System.out.println("Stream after distinct and sorting: " + s3.distinct().sorted().collect(Collectors.toList()));


        Stream<String> s4 = Arrays.stream(country, 0, 3);
        System.out.println("Stream from Arrays element " + s4.collect(Collectors.toList()));

        //Stream.generate Example
        Stream.generate(() -> "Jai Shree Ram").limit(5).forEach(System.out::println);


        //IntStream.generate Example
        IntStream.generate(() -> 1331).limit(6).forEach(i -> System.out.print(" " + i));

        //Generating a stream of random integers
        System.out.print("\nPrinting 20 random numbers: ");
        IntStream.generate(() -> new Random().nextInt(100))
                .limit(20)
                .forEach(i -> System.out.print(" " + i));

        //Stream.range examples (startInclusive, endExclusive)
        System.out.print("\nPrinting first 100 numbers: ");
        IntStream.range(1, 101).forEach(i -> System.out.print(" " + i));
        System.out.print("\nPrinting first 50 even numbers: ");
        IntStream.range(1, 101).filter(i -> i % 2 == 0).forEach(i -> System.out.print(" " + i));
        System.out.print("\nPrinting first 50 odd numbers: ");
        IntStream.range(1, 101).filter(i -> i % 2 != 0).forEach(i -> System.out.print(" " + i));

        //Stream rangeClosed (startInclusive, endInclusive)
        System.out.print("\nPrinting first 10 natural numbers: ");
        IntStream.rangeClosed(1, 10).forEach(i -> System.out.print(" " + i));

        //Stream Iterate
        Stream<Integer> tableOf5 = Stream.iterate(5, n -> n + 5).limit(10);
        System.out.println("\nTable of 5 : " + tableOf5.collect(Collectors.toList()));


        //Stream of chars (both will give same result e.g. 656667
        IntStream streamOfChars1 = "ABC".codePoints();
        IntStream streamOfChars2 = "ABC".chars();
        streamOfChars1.forEach(System.out::print);

        Stream<String> streamOfString =
                Pattern.compile(", ").splitAsStream("i, n, d, i, a");
        streamOfString.forEach(System.out::print);


        Path path = Paths.get("C:\\Users\\10738316\\sample.txt");
        Stream<String> streamOfStrings = Files.lines(path);
        Stream<String> streamWithCharset =
                Files.lines(path, StandardCharsets.UTF_8);
        System.out.println("\nPrinting from streamOfStrings: \n" + streamOfStrings.collect(Collectors.toList()));
        System.out.println("\nPrinting from streamWithCharset: \n" + streamWithCharset.collect(Collectors.toList()));

        //Referencing a Stream
        /***
         * Below code will throw errors,
         * Exception in thread "main" java.lang.IllegalStateException: stream has already been operated
         * upon or closed
         */
        /*Stream<String> stream = Stream.of("a", "b", "c").filter(item->item.contains("b"));
        System.out.println(stream.collect(Collectors.toList()));
        Optional<String> anyItem = stream.findAny();
        System.out.println(anyItem.get());*/

        List<String> elements = Stream.of("a", "b", "c", "abc").filter(element -> element.contains("b"))
                .collect(Collectors.toList());
        Optional<String> anyElement = elements.stream().findAny();
        Optional<String> firstElement = elements.stream().findFirst();

        System.out.println("findAny(): " + anyElement.orElse("Not found"));
        System.out.println("findFirst(): " + firstElement.orElse("Not found"));


        System.out.print("twiceModifiedStream : ");
        Stream<String> onceModifiedStream = Stream.of("abcd", "bbcd", "cbcd").skip(1);
        onceModifiedStream.forEach(i -> System.out.printf(" %s", i));


        System.out.print("\ntwiceModifiedStream : ");
        Stream<String> twiceModifiedStream = Stream.of("abcd1", "bbcd2", "cbcd3").skip(1)
                .map(element -> element.substring(2, 5));
        twiceModifiedStream.forEach(i -> System.out.printf(" %s", i));

        System.out.print("\nSkip, sorted and Map: ");
        List<String> list = Arrays.asList("abc1", "abc3", "abc2");
        list.stream().skip(1)
                .map(element -> element.substring(1, 4)).sorted().forEach(System.out::print);

    }
}
