package ch.bbw.m326.media;

public class Game extends Media {

    private String platform;

    public Game() {
        super();
        platform = "N/A";

    }
    public Game(String title, String genre, String type, int year, boolean isDigital, String info, String platform) {
        super(title, genre, type, year, isDigital, info);
        this.platform = platform;
    }

    public String getPlatform() {
        return platform;
    }

}