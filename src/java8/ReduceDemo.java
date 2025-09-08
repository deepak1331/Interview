package src.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class ReduceDemo {

    public static void main(String[] args) {

        List<Integer> list = IntStream.range(1, 6).boxed().toList();
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println("Elements of list: "+ list);

       int sum =  list.stream().reduce(0, (a, b)-> a+b);
      //  int sum =  list.stream().reduce(0, Integer::sum);
        int product = list.stream().reduce(1, (a, b)-> a*b);

        System.out.println("Sum of list: "+ list.stream().reduce(Integer::sum).orElse(0));

        System.out.println("Product of list: "+ product);

        System.out.println("First Match : "+ list.stream().findFirst().get());

        System.out.println("FindAny Match : "+ list.stream().findAny().get());
        // throws  UnsupportedOperationException as immutable lists are unmodifiable
        //list.sort(Comparator.reverseOrder());
        list2.sort(Comparator.reverseOrder());
        System.out.println("FindLast (using reversed) : "+  list2.stream().findFirst().get());

        System.out.println("FindLast (using reduced) : "+
                list.stream().reduce((first, second)-> second).get()
                );

        int key = 2;
        int i = Collections.binarySearch(list, key);
        System.out.printf("Key %d found at index: %d ", key, i);


    }
}
