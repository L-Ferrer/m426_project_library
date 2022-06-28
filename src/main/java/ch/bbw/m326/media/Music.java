package ch.bbw.m326.media;

/**
 * @author Leandro Ferrer
 * @version 1.0
 *
 * The Music class is the base class for all music objects.
 */
public class Music extends Media {

    private String artist;
    private String album;
    private int duration;

    public Music() {
        super();
        artist = "N/A";
        album = "N/A";
        duration = 0;
    }
    public Music(String title, String genre, String type, int year, boolean isDigital, String info, String artist, String album, int duration) {
        super(title, genre, type, year, isDigital, info);
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }

    /**
     * @return The artist of the song.
     */
    public String getArtist() {
        return artist;
    }

    /**
     * @return The album of the song.
     */
    public String getAlbum() {
        return album;
    }

    /**
     * @return The duration of the song.
     */
    public int getDuration() {
        return duration;
    }
}