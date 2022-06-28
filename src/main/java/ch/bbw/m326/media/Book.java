package ch.bbw.m326.media;

/**
 * @author Leandro Ferrer
 * @version 1.0
 *
 * The Book class is the base class for all book objects.
 */
public class Book extends Media {

    private String author;
    private String publisher;
    private int pages;

    public Book(String title, String genre, String type, int year, boolean isDigital, String info, String author, String publisher, int pages) {
        super(title, genre, type, year, isDigital, info);
        this.author = author;
        this.publisher = publisher;
        this.pages = pages;
    }

    /**
     * @return The author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @return The publisher of the book.
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @return The number of pages of the book.
     */
    public int getPages() {
        return pages;
    }
}