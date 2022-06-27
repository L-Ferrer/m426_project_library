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

public class LibraryTest {
    Manager manager = new Manager();
    @BeforeEach
    void setUp() {
        try {
            manager.initialize();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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
