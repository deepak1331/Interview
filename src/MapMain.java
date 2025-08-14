package src;

import src.model.City;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapMain {
    public static void main(String[] args) {

        List<Integer> numList = List.of(1, 3, 5, 7, 9, 11, 13, 15);
        List<Integer> sqNumList = numList.stream().map(n -> n * n).collect(Collectors.toList());
        Map<Integer, Integer> squareMap = numList.stream().collect(Collectors.toMap(k -> k, k -> k * k));

        List<Integer> cubeList = numList.stream().map(n -> n * n * n).toList();

        System.out.println("Initial list: " + numList);
        System.out.println("Square list: " + sqNumList);
        System.out.println("Square Map: " + squareMap);
        System.out.println("Cube list: " + cubeList);

        squareMap.forEach((k, v) -> System.out.printf("Square of %d = %d%n", k, v));

        List<City> cityList = List.of(
                new City("Prayagraj", "U.P", 200),
                new City("Lucknow", "U.P", 100),
                new City("Kanpur", "U.P", 150),
                new City("Chennai", "TamilNadu", 125),
                new City("Coimbatore", "TamilNadu", 75),
                new City("Tiruneveli", "TamilNadu", 50),
                new City("Delhi", "New Delhi", 175),
                new City("Noida", "U.P", 120)
        );


        Map<String, String> cityMap = cityList.stream().collect(Collectors.toMap(City::getName, City::getState));
        Map<String, List<City>> stateMap = cityList.stream().collect(Collectors.groupingBy(City::getState));
        System.out.println(cityMap);
        System.out.println("State wise city : ");

        stateMap.forEach((k, v) -> {
            System.out.printf("\n%d cities found for state  %s are as follows: ", v.size(),k);
            //v.forEach(City::print);
            v.forEach(c-> System.out.print(c.getName().concat(" ")));
        });
    }
}
