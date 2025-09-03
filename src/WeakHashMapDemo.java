package src;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

public class WeakHashMapDemo {

    public static void main(String[] args) throws InterruptedException {

        User user1 = new User("Deepak Yadav", 30);
        User user2 = new User("Abhijit Ghute", 40);
        User user3 = new User("Rahul Khadse", 39);
        User user4 = new User("Pawan Soni", 45);
        User user5 = new User("Rinchin", 45);

        Map<User, String> userMap = new HashMap<>();
        userMap.put(user1, "This is a dummy value");
        userMap.put(user3, "This is a dummy value");
        userMap.put(user4, "This is a dummy value");
        userMap.put(user5, "This is a dummy value");

        Map<User, String> userMap2 = new WeakHashMap<>();
        userMap2.put(user1, "Dummy Value for WeakHashMapDemo");
        userMap2.put(user2, "Dummy Value for WeakHashMapDemo");
        userMap2.put(user3, "Dummy Value for WeakHashMapDemo");
        userMap2.put(user4, "Dummy Value for WeakHashMapDemo");


        user1 = null;
        user2 = null;
        System.gc();
        Thread.sleep(100);

        System.out.println("HashMap after nullyfying one of its key: " + userMap);
        System.out.println("WeakHashMap after nullyfying one of its key: " + userMap2);
    }
}

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getAge() == user.getAge() && Objects.equals(getName(), user.getName());
    }

    @Override
    public String toString() {
        return "\n " + name +
                " is " + age + " years old.";
    }
}
