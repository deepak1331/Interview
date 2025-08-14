package src;

import src.model.City;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorVsComparableMain {
    public static void main(String[] args) {

        List<City> cityList = new ArrayList<City>();
        cityList.add(new City("Prayagraj", "U.P", 20));
        cityList.add(new City("Lucknow", "U.P", 10));
        cityList.add(new City("Kanpur", "U.P", 15));
        cityList.add(new City("Chennai", "TamilNadu", 12));
        cityList.add(new City("Coimbatore", "TamilNadu", 8));
        cityList.add(new City("Tirunelveli", "TamilNadu", 5));
        cityList.add(new City("Delhi", "New Delhi", 16));
        cityList.add(new City("Noida", "U.P", 12));


        //We have used implements Comparable<City> where comparison is done by CityName
        //so when we call sort on this city list, it will be sorted by cityname.
        //Limitation of comparable is that we can sort it only by one property at a time.
        System.out.println("Before sorting : ");
        cityList.forEach(City::print);

        System.out.println("After sorting : ");
        cityList.sort((o1, o2) -> o2.getName().compareTo(o1.getName()));
        cityList.forEach(City::print);


        System.out.println("After sorting by State: ");
        Collections.sort(cityList);
        cityList.forEach(City::print);


        System.out.println("After sorting by State, Population, Name : ");
        cityList.stream().sorted(Comparator.comparing(City::getState)
                        .thenComparing(City::getPopulation)
                        .thenComparing(City::getName))
                .forEach(City::print);

        System.out.println("After sorting by Population (descending order): ");
        cityList.stream()
                .sorted((o1, o2) -> o2.getPopulation().compareTo(o1.getPopulation()))
                .forEach(City::print);
    }
}
