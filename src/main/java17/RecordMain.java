package org.example.java17;

record Student(int rollNo, String name) {
}

record Car(String make, String model) {

    public Car {
        if (make.isEmpty())
            throw new IllegalArgumentException("Make cannot be empty");
    }
}


public class RecordMain {

    public static void main(String[] args) {
        Student s1 = new Student(1, "Deepak Yadav");
        Student s2 = new Student(1, "Deepak Yadav");

        System.out.println("Student Details : " + s1);
        System.out.println(s1.equals(s2));

        Car c1 = new Car("Tata", "Indica");
        Car c2 = new Car("Mahindra", "BE6E");

        System.out.println(c1);
        System.out.println(c2);
    }
}
