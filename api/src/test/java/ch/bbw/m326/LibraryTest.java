package ch.bbw.m326;

import ch.bbw.m326.database.Library;
import ch.bbw.m326.database.Manager;
import ch.bbw.m326.media.Book;
import ch.bbw.m326.media.Media;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This class contains junit5 test functions for the {@link ch.bbw.m326.database.Library} class.
 * @author Leandro Ferrer
 * @version 1.0
 */
public class LibraryTest {
    Manager manager = new Manager();

    /**
     * This method is called before each test.
     * @throws IOException If the database could not be initialized.
     */
    @BeforeEach
    void setUp() {
        try {
            manager.initialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This test function tests the {@link ch.bbw.m326.database.Library#addMedia(Media)}
     *      and {@link ch.bbw.m326.database.Library#removeMedia(Media)} method.
     *
     */
    @Test
    void addMediaAndRemoveMediaTest() {
        Library lib = manager.getLibraryObject();
        ArrayList<Media> media = lib.getLibrary();
        Media book = new Book("Book Title", "Book Genre", "Book type", 2000, true, "Book Info", "Book Author", "Book Publisher", 100);
        media.add(book);
        int index = media.size() - 1;
        Assertions.assertEquals(book, media.get(index));
        lib.removeMedia(book);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> media.get(index));
    }
}
