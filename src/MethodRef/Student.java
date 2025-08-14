package src.MethodRef;

public class Student {

    private String name;

    public Student() {
        System.out.println("Student constructor called.");
    }

    public Student(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("I'm a Student ");
    }

    public void show() {
        System.out.println("I'm a Student, my name is " + name);
    }
}
