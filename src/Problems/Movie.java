package src.Problems;

public class Movie {

    private String title;

    private String director;

    private String genre;

    private double rating;

    private int year;

    public Movie(String title, String director, String genre, double rating, int year) {

        this.title = title;

        this.director = director;

        this.genre = genre;

        this.rating = rating;

        this.year = year;

    }
    // Getters

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public int getYear() {
        return year;
    }
    // Setters

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return  title + " (" + genre + ") | By: " + director + " | Rating: " +
                +rating +
                " | Released in: " + year +"\n";
    }
}