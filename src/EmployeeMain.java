package src;

public class EmployeeMain {

    public static void main(String[] args) {


        Employee e1 = new Employee("Deepak", "Male", 35);
        Employee e2 = new Employee("Shipra", "Female", 35);
        Employee e3 = new Employee("Deepak", "Male", 36);
        Employee e4 = new Employee("Deepak", "Male", 35);
        Employee e5 = e2;

        System.out.println(e1.equals(e4));
        System.out.println(e1 == e4);
        System.out.println(e1.equals(e2));
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e1.equals(e4));
        System.out.println(e2.equals(e5));

        System.out.println(e4.toString());
        System.out.println(e4.hashCode());


    }
}
