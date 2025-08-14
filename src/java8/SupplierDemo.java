package src.java8;

import java.util.function.Supplier;

public class SupplierDemo implements Supplier<String> {
    /**
     * Gets a result.
     *
     * @return a result
     */
    @Override
    public String get() {
        return "Hello from Supplier";
    }

    public static void main(String[] args) {
        Supplier<String> supplier = new SupplierDemo();

        System.out.println(supplier.get());
    }
}
