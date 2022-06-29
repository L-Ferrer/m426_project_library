package ch.bbw.m326.media;

/**
 * The Film class is the base class for all film objects.
 *
 * @author Leandro Ferrer
 * @version 1.0
 */
public class Film extends Media {


    private final String director;
    private final int duration;

    /**
     * Constructs a new Film object.
     */
    public Film(String title, String genre, String type, int year, boolean isDigital, String info, String director, int duration) {
        super(title, genre, type, year, isDigital, info);
        this.director = director;
        this.duration = duration;
    }

    /**
     * @return The director of the film.
     */
    public String getDirector() {
        return director;
    }

    /**
     * @return The duration of the film.
     */
    public int getDuration() {
        return duration;
    }
}
