package ch.bbw.m326.media;

public abstract class Media {
    private String title, genre, type, info;
    private int id, year;
    private boolean isDigital;

    public Media() {
        title = "N/A";
        genre = "N/A";
        type = "N/A";
        info = "N/A";
        year = 0;
        isDigital = false;
    }
    public Media(String title, String genre, String type, int year, boolean isDigital, String info) {
        this.title = title;
        this.genre = genre;
        this.type = type;
        this.year = year;
        this.isDigital = isDigital;
        this.info = info;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isIsDigital() {
        return this.isDigital;
    }

    public boolean getIsDigital() {
        return this.isDigital;
    }

    public void setIsDigital(boolean isDigital) {
        this.isDigital = isDigital;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
