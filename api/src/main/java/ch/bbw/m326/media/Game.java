package ch.bbw.m326.media;

/**
 * The Game class is the base class for all game objects.
 *
 * @author Leandro Ferrer
 * @version 1.0
 */
public class Game extends Media {

    private final String platform;

    /**
     * Constructs a new Game object.
     */
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