package org.example.java8;

import src.main.java8.NameInterface;
import src.main.java8.RandomNameGenerator;

import java.util.Optional;

public class ElseGetMain {

    public static void main(String[] args) {

        NameInterface n = RandomNameGenerator::generate;

        Optional<String> player = Optional.ofNullable("Deepak Yadav");

        String orElseResult = player.orElse(n.generate());
        String orElseGetResult = player.orElseGet(n::generate);


        System.out.println("value in orElse Result: " + orElseResult);
        System.out.println("value in orElseGet Result: " + orElseGetResult);
    }
}

/*

        Optional<String> optional = Optional.ofNullable("Deepak");

        String orElseGetResult = optional.orElseGet(ElseGetMain::getFunctionForTest);
        System.out.println("value in orElseGet Result: " + orElseGetResult);

        String orElseResult = optional.orElse(getFunctionForTest());
        System.out.println("value in orElse Result: " + orElseResult);

    }

    public static String getFunctionForTest() {
        System.out.println("\n ===== function called ===== \n");
        return "default value";
    }
}*/
