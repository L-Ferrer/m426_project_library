package ch.bbw.m326.database;

import ch.bbw.m326.exceptions.MediaNotFoundException;
import ch.bbw.m326.media.Media;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Manager {
    Writer writer = new Writer();
    static final Library lib = new Library();

    public Library getLibraryObject(){
        return lib;
    }

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
        libraryBackup(lib);
        Runtime.getRuntime().addShutdownHook(
                new Thread("app-shutdown-hook") {
                    @Override
                    public void run() {
                        System.out.println("Backing library up before shutdown...");
                        try {
                            writer.writeJSON(lib, "database/library.json");
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Library backed up...shutting down");}});
    }
    private static void libraryBackup(Library lib){
        //Creates a backup of the library every 10 minutes after 1 minute
        Writer writer = new Writer();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    System.out.println("Backup started");
                    writer.writeJSON(lib, "database/backup.json");
                    System.out.println("Backup finished");
                }catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }, 1000*60, 1000*600);
    }
}
