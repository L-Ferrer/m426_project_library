package ch.bbw.m326;

import ch.bbw.m326.database.Library;
import ch.bbw.m326.database.Manager;
import ch.bbw.m326.media.Media;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.test.context.event.annotation.BeforeTestExecution;

/**
 * This class contains junit5 test functions for the {@link ch.bbw.m326.database.Manager} class.
 * @author Leandro Ferrer
 * @version 1.0
 */
class ManagerTest {
    Manager manager = new Manager();

    /**
     * This method is called before each test.
     * @throws IOException If the database could not be initialized.
     */
    @BeforeTestExecution
    void setUp() {
        try {
            manager.initialize();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This test function tests the {@link ch.bbw.m326.database.Manager#getMediaById(int)} method.
     */
    @Test
    void testGetMediaById() {
        Library lib = manager.getLibraryObject();
        ArrayList<Media> media = lib.getLibrary();

        for(Media m : media){
            if(m.getId() == 1){
                Assertions.assertEquals(m.getTitle(), "The Lord of the Rings");
            }
        }
    }

    /**
     * This test function tests the {@link ch.bbw.m326.MediaNotFoundException} exception.
     */
    @Test
    void testGetMediaByIdException() {
        Library lib = manager.getLibraryObject();
        ArrayList<Media> media = lib.getLibrary();

        int index = media.size();
        Assertions.assertThrows(MediaNotFoundException.class, () -> manager.getMediaById(index));
    }
}
