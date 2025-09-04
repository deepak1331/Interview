package src.Problems;

import java.time.Year;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/*
 * Use Stream API for below requirements:
 *    Find the last occurrence of movie named "Pulp Fiction" and print its length
 *    Group movies by director
 *    Find the highest-rated movie per genre
 *    List all movies released in the last 5 years with rating > 8
 *    Count how many movies each genre has
 */
public class MovieProblem {

    public static void main(String[] args) {

        List<Movie> movies = getMovieList();

        Optional<Movie> result = movies.stream().filter(movie -> movie.getTitle().equalsIgnoreCase("Pulp Fiction"))
                .findFirst();

        System.out.println(result.get());

        String movieNames = movies.stream().map(Movie::getTitle).collect(Collectors.joining(", "));
        // movieNames.forEach(System.out::print);
        System.out.println(movieNames);

        Map<String, List<Movie>> groupedByDirectors = movies.stream()
                .collect(Collectors.groupingBy(Movie::getDirector));
        System.out.println("Movies grouped by Directors : " + groupedByDirectors);

        Map<String, Optional<Movie>> maxRatingByGenre = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre,
                        Collectors.reducing(BinaryOperator.maxBy(
                                Comparator.comparingDouble(Movie::getRating)))));

        System.out.println("Highest-rated movie per genre: " + maxRatingByGenre);


        List<Movie> moviesInLastFiveYears = movies.stream().filter(movie -> movie.getRating() > 8)
                .filter(movie -> (Year.now().getValue() - movie.getYear()) < 5).toList();
        System.out.println("\nAll movies released in the last 5 years with rating > 8\n" + moviesInLastFiveYears);

        //Count how many movies each genre has
        Map<String, Long> countByGenre = movies.stream().collect(Collectors.groupingBy(Movie::getGenre, Collectors.counting()));
        System.out.println("many movies each genre has : " + countByGenre);
    }


    private static List<Movie> getMovieList() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Inception", "Christopher Nolan", "Sci-Fi", 8.8, 2010));
        movies.add(new Movie("Interstellar", "Christopher Nolan", "Sci-Fi", 8.6, 2014));
        movies.add(new Movie("The Dark Knight", "Christopher Nolan", "Action", 9.0, 2008));
        movies.add(new Movie("Pulp Fiction", "Quentin Tarantino", "Crime", 8.9, 1994));
        movies.add(new Movie("Django Unchained", "Quentin Tarantino", "Western", 8.4, 2012));
        movies.add(new Movie("Parasite", "Bong Joon-ho", "Thriller", 8.6, 2019));
        movies.add(new Movie("The Matrix", "Lana Wachowski", "Sci-Fi", 8.7, 1999));
        movies.add(new Movie("The Grand Budapest Hotel", "Wes Anderson", "Comedy", 8.1, 2014));
        movies.add(new Movie("Whiplash", "Damien Chazelle", "Drama", 8.5, 2014));
        movies.add(new Movie("Everything Everywhere All at Once", "Daniel Kwan", "Sci-Fi", 8.1, 2022));
        return movies;
    }
}
