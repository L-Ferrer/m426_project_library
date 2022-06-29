package ch.bbw.m326.media;

/**
 * The Book class is the base class for all book objects.
 *
 * @author Leandro Ferrer
 * @version 1.0
 */

public class Book extends Media {

    private final String author;
    private final String publisher;
    private final int pages;

    /**
     * Constructs a new Book object.
     */
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