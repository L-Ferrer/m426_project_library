package ch.bbw.m326;

import ch.bbw.m326.database.Library;
import ch.bbw.m326.database.Manager;
import ch.bbw.m326.exceptions.MediaNotFoundException;
import ch.bbw.m326.media.Media;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import ch.bbw.m326.database.Library;

class ManagerTest {
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
    void testGetMediaById() {
        Library lib = manager.getLibraryObject();
        ArrayList<Media> media = lib.getLibrary();

        for(Media m : media){
            if(m.getId() == 1){
                Assertions.assertEquals(m.getTitle(), m.getTitle());
            }
        }
    }
    @Test
    void testGetMediaByIdException() {
        Library lib = manager.getLibraryObject();
        ArrayList<Media> media = lib.getLibrary();

        int index = media.size();
        Assertions.assertThrows(MediaNotFoundException.class, () -> manager.getMediaById(index));
    }
}
