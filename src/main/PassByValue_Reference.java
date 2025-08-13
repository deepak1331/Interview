package src.main;

public class PassByValue_Reference {

    public static void main(String[] args) {

        int intVar = 1;
        Integer integerVar = 20;
        String str = new String("Java");

        System.out.println("\nValues Before update:");
        System.out.println("intVar = " + intVar);
        System.out.println("integerVar = " + integerVar);
        System.out.println("string = " + str);

        updateInt(intVar);
        updateInteger(integerVar);
        updateString(str);

        System.out.println("\nValues After update:");
        System.out.println("intVar = " + intVar);
        System.out.println("integerVar = " + integerVar);
        System.out.println("string = " + str);
    }

    public static void updateInt(int x) {
        x = 10;
    }

    public static void updateInteger(Integer x) {
        x = 100;
    }

    public static void updateString(String x) {
        x += " World !";
    }
}