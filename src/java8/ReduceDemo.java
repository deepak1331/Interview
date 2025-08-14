package src.java8;

import java.util.List;
import java.util.stream.IntStream;

public class ReduceDemo {

    public static void main(String[] args) {

        List<Integer> list = IntStream.range(1, 6).boxed().toList();

        System.out.println("Elements of list: "+ list);

       int sum =  list.stream().reduce(0, (a, b)-> a+b);
      //  int sum =  list.stream().reduce(0, Integer::sum);
        int product = list.stream().reduce(1, (a, b)-> a*b);

        System.out.println("Sum of list: "+ list.stream().reduce(Integer::sum).orElse(0));

        System.out.println("Product of list: "+ product);
    }
}
