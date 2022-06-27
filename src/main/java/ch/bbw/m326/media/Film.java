package ch.bbw.m326.media;

public class Film extends Media {

    private String director;
    private int duration;

    public Film() {
        super();
        director = "N/A";
        duration = 0;
    }
    public Film(String title, String genre, String type, int year, boolean isDigital, String info, String director, int duration) {
        super(title, genre, type, year, isDigital, info);
        this.director = director;
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public int getDuration() {
        return duration;
    }
}
