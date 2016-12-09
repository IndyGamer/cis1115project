package listpackage;

import java.time.Clock;

/**
 * Anime Class. This class represents a single anime.
 *
 * @author 55jphillip
 */
public class Anime {

    private int id;
    private String name;
    private String genre;
    private String studio;
    private int episodenumber;
    private double rating;

    public Anime(int id, String name, String genre, String studio, int episodenumber, double rating) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.studio = studio;
        this.episodenumber = episodenumber;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public int getEpisodenumber() {
        return episodenumber;
    }

    public void setEpisodenumber(int episodenumber) {
        this.episodenumber = episodenumber;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Anime() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%5d %-25s %-20s %-20s %-10d %-10f", id, name, genre, studio, episodenumber, rating);
    }

}
