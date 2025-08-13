package src.main;

import java.lang.reflect.Method;

class A {
    public void display() {
        System.out.println("Class A Display called.");
    }

    private void privateShow() {
        System.out.println("Class A privateShow called.");
    }

    public void show() {
        System.out.println("Class A Show called.");
    }


    public static void print() {
        System.out.println("Class A Print called.");
    }
}

class B extends A {

    public void display() {
        System.out.println("Class B Display called.");
    }

    public static void print() {
        System.out.println("Class B Print called.");
    }

    public void show() {
        try {
            System.out.println("Class B Show called.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

public class RunTimeMain {
    public static void main(String[] args) {
        B obj = new B();
        obj.display();
        obj.print();

        obj.show();

        try {
            Object reflectionObj = new A();
            Method method = reflectionObj.getClass().getDeclaredMethod("privateShow");
            method.setAccessible(true);
            method.invoke(reflectionObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
