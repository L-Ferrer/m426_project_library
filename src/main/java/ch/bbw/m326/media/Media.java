package ch.bbw.m326.media;

/**
 * The Media class is the base class for all media objects.
 *
 * @author Leandro Ferrer
 * @version 1.0
 */
public abstract class Media {
    private String title, genre, type, info;
    private int id, year;
    private boolean isDigital;

    /**
     * Constructor for Media objects.
     */
    public Media(String title, String genre, String type, int year, boolean isDigital, String info) {
        this.title = title;
        this.genre = genre;
        this.type = type;
        this.year = year;
        this.isDigital = isDigital;
        this.info = info;
    }

    /**
     * @return The title of the media.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the title of the media.
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The genre of the media.
     */
    public String getGenre() {
        return this.genre;
    }

    /**
     * Sets the genre of the media.
     * @param genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * @return The type of the media.
     */
    public String getType() {
        return this.type;
    }

    /**
     * Sets the type of the media.
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The description of the media.
     */
    public String getInfo() {
        return this.info;
    }

    /**
     * Sets the description of the media.
     * @param info
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * @return The year of when the media was published.
     */
    public int getYear() {
        return this.year;
    }

    /**
     * Sets the year of when the media was published.
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return Whether the media is digital or not.
     */
    public boolean getIsDigital() {
        return this.isDigital;
    }

    /**
     * Sets whether the media is digital or not.
     * @param isDigital
     */
    public void setIsDigital(boolean isDigital) {
        this.isDigital = isDigital;
    }

    /**
     * @return The ID of the media.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets the ID of the media.
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

}
