package ch.bbw.m326.database;

import ch.bbw.m326.media.Media;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The library is an ArrayList of Media objects.
 * It is initialized by the Manager class {@link ch.bbw.m326.database.Manager}
 * so that there is always one single instance of the library.
 *
 * @author Leandro Ferrer
 * @version 1.0
 */
public class Library {
    ArrayList<Media> mediaList = new ArrayList<>();

    /**
     * Reads the library from the json file.
     * Only called by the Manager class.
     * @param lib
     * @throws IOException
     */
    protected void initialize(Library lib) throws IOException {
        Reader reader = new Reader();
        reader.readDB(lib);
    }

    /**
     * Adds a media object to the library.
     * @param media The media object to add.
     */
    public void addMedia(Media media) {
        int largestId = 0;
        for(int i = 0; i < mediaList.size(); i++) {
            if(mediaList.get(i).getId() > largestId) {
                largestId = mediaList.get(i).getId();
            }
        }
        media.setId(largestId + 1);
        mediaList.add(media);
    }

    /**
     * Removes a media object from the library.
     * @param media The media object to remove.
     */
    public void removeMedia(Media media) {
        Media toRemove = null;
        for(Media m : mediaList) {
            if(media.getId() == m.getId()) {
                toRemove = m;
            }
        }
        mediaList.remove(toRemove);
    }

    /**
     * @return The library as an ArrayList of Media objects.
     */
    public ArrayList<Media> getLibrary() {
        return mediaList;
    }
}
