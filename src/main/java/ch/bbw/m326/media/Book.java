package ch.bbw.m326.media;

public class Book extends Media {

    private String author;
    private String publisher;
    private int pages;

    public Book() {
        super();
        author = "N/A";
        publisher = "N/A";
        pages = 0;
    }
    public Book(String title, String genre, String type, int year, boolean isDigital, String info, String author, String publisher, int pages) {
        super(title, genre, type, year, isDigital, info);
        this.author = author;
        this.publisher = publisher;
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPages() {
        return pages;
    }
}