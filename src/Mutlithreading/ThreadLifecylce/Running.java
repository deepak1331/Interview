package src.Mutlithreading.ThreadLifecylce;

public class Running {

    public static void main(String[] args) {
        Runnable obj1 = () -> System.out.println(Thread.currentThread().getName());
        Thread t = new Thread(obj1);
        System.out.println(t.getState()); //new State

        t.start();
        System.out.println(t.getState()); //Runnable State

        System.out.println(t.getState());

    }
}
