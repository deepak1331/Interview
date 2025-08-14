package src.java8;

import java.util.function.Consumer;

public class ConsumerDemo {

    public static void main(String[] args) {

        //Lambda Style
        Consumer<Integer> consumer = t ->
                System.out.printf("\nSquare of %d is = %d", t, t * t);
        consumer.accept(10);

        //Static Method reference
        consumer = ConsumerDemo::cube;
        consumer.accept(6);


        //Override accept method
        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.printf("\nLength of %s is %d", s, s.length());
            }
        };
        consumer1.accept("India");

    }

    public static void cube(int n) {
        System.out.printf("\nCube of %d is = %d", n, n * n * n);
    }
}
