package ch.bbw.m326.database;

import ch.bbw.m326.MediaNotFoundException;
import ch.bbw.m326.media.Media;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * The Manager class manages the database.
 *
 * @author Leandro Ferrer
 * @version 1.0
 */
public class Manager {
    private static final Library lib = new Library();

    /**
     * @return The library object.
     */
    public Library getLibraryObject(){
        return lib;
    }

    /**
     * Returns a Media object from the library by its id.
     * @param id The id of the media object.
     * @return The media object.
     * @throws MediaNotFoundException If the media object is not found.
     */
    public Media getMediaById(int id) throws MediaNotFoundException {
        for(Media media : lib.getLibrary()){
            if(media.getId() == id){
                return media;
            }
            else {
                throw new MediaNotFoundException("Media with id " + id + " wasn't found in the library.");
            }
        }
        throw new MediaNotFoundException("Media with id " + id + " wasn't found in the library.");
    }

    /**
     * Initializes the library by calling the initialize method in the {@link ch.bbw.m326.database.Library} class.
     * Starts a backup thread that backups the library periodically.
     * Starts a hook that saves the library before the program exits.
     * @throws IOException
     */
    public static void initialize() throws IOException {
        // Initialize library
        try {
            lib.initialize(lib);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Library initialized");
        Writer writer = new Writer();

        // Save the database before shutting down the server
        libraryBackup(60, 600, lib);
        Runtime.getRuntime().addShutdownHook(
                new Thread("app-shutdown-hook") {
                    @Override
                    public void run() {
                        System.out.println("Backing library up before shutdown...");
                        try {
                            writer.writeLibJSON(lib, "database/library.json");
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Library backed up...shutting down");}});
    }

    /**
     * Starts a backup thread that backups the library periodically.
     * @param delay The delay before the first backup in seconds.
     * @param interval The interval of backups in seconds.
     * @param lib The library object.
     */
    private static void libraryBackup(int delay, int interval, Library lib){
        //Creates a backup of the library
        Writer writer = new Writer();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    System.out.println("Backup started");
                    writer.writeLibJSON(lib, "database/library_backup.json");
                    System.out.println("Backup finished");
                }catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }, 1000*delay, 1000*interval);
    }
}
