package ch.bbw.m326.media;

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

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public int getDuration() {
        return duration;
    }
}