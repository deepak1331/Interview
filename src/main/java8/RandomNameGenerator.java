package src.main.java8;

import java.util.Random;

public class RandomNameGenerator {

    static final String[] firstName = {"Ajay", "Deepak", "Rahul", "Divya", "Poornima",
            "Rashmi", "Arjun", "Aditi", "Shipra", "Shikha"};
    static final String[] lastName = {"Singh", "Tiwari", "Chaube", "Yadav", "Dixit",
            "Rao", "Kumar", "Mishra", "Maurya", "Rai"};

    public static String generate() {
        System.out.println("Initiating random name generator");
        Random random = new Random();
        short firstNameIndex = (short) random.nextInt(0, 10);
        short lastNameIndex = (short) random.nextInt(0, 10);
        System.out.println("Name generated successfully");
        return firstName[firstNameIndex] + " " + lastName[lastNameIndex];
    }

    public static void main(String[] args) {
        for(int i=1;i<=10;i++)
            System.out.println(i + " ) "+generate());
    }
}
