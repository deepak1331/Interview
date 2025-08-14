package src.MethodRef;

import java.util.List;
import java.util.stream.Collectors;

class Hello {
    private String name;

    public Hello(String name) {
        this.name = name;
        System.out.println("Hello Parametrized Constructor called.");
    }

    public Hello() {
        this.name = "Default name";
        System.out.println("Hello Constructor called.");
    }

    public static void hi() {
        System.out.println("Good Morning !");
    }

    public void bye() {
        System.out.println("Good Bye " + name + " !");
    }
}

public class MyMain {

    public static void main(String[] args) {
        //Static method reference
        MyInterface myInterface = Hello::hi;
        myInterface.greet();


        //Instance method reference
        Hello obj = new Hello("Tommy");
        MyInterface myInterface2 = obj::bye;
        myInterface2.greet();

        //Constructor reference
        MyInterface myInterface3 = Hello::new;
        myInterface3.greet();

        List<String> namelist = List.of("Jerry", "Mickey", "Simba");
        List<Hello> helloList = namelist.stream().map(Hello::new).collect(Collectors.toList());
        helloList.forEach(Hello::bye);


        Provider provider = Student::new;
        Student student = provider.getStudent();
        student.display();

        String str = "Deepak";
        provider= ()-> new Student(str);
        Student student2 = provider.getStudent();
        student2.show();

    }
}