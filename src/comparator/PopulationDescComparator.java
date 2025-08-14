package src.comparator;

import src.model.City;

import java.util.Comparator;

public class PopulationDescComparator implements Comparator<City> {
    @Override
    public int compare(City o1, City o2) {
        return o2.getPopulation().compareTo(o1.getPopulation());
    }
}