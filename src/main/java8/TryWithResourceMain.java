package src.main.java8;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourceMain {
    public static void main(String[] args) {
        String filePath = "example.txt"; // Assuming example.txt exists

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
