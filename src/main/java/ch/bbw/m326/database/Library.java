package ch.bbw.m326.database;

import ch.bbw.m326.media.Media;

import java.io.IOException;
import java.util.ArrayList;

public class Library {
    /**
     * The library is an ArrayList of Media objects.
     * The library is initialized with the initialize() method.
     *
     */
    ArrayList<Media> mediaList = new ArrayList<>();

    /**
     * @param lib
     * @throws IOException
     */
    protected void initialize(Library lib) throws IOException {
        Reader reader = new Reader();
        reader.readDB(lib);
    }

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

    public void removeMedia(Media media) {
        Media toRemove = null;
        for(Media m : mediaList) {
            if(media.getId() == m.getId()) {
                toRemove = m;
            }
        }
        mediaList.remove(toRemove);
    }

    public ArrayList<Media> getLibrary() {
        return mediaList;
    }

    public void printAll() {
        for (Media media : mediaList) {
            System.out.println(media.getTitle());
        }
    }
}
