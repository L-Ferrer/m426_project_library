package ch.bbw.m326.media;

/**
 * @author Leandro Ferrer
 * @version 1.0
 *
 * The Game class is the base class for all game objects.
 */
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

    /**
     * @return The platform of the game.
     */
    public String getPlatform() {
        return platform;
    }

}