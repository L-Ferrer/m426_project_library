package ch.bbw.m326.database;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import ch.bbw.m326.media.*;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * The Writer class manages all file writing related functions.
 *
 * @author Leandro Ferrer
 * @version 1.0
 */
public class Writer {

    /**
     * Writes the library into a JSON array and returns it.
     * @param lib The library object.
     * @return The library JSON array.
     */
    public JSONArray libToJson(Library lib){
        JSONArray array = new JSONArray();
        for (Media media : lib.getLibrary()) {
            Class<? extends Media> c = media.getClass();
            JSONObject obj = new JSONObject();
            obj.put("id", media.getId());
            obj.put("title", media.getTitle());
            obj.put("genre", media.getGenre());
            obj.put("type", media.getType());
            obj.put("year", media.getYear());
            obj.put("isDigital", media.getIsDigital());
            obj.put("info", media.getInfo());
            if(c == Book.class){
                obj.put("author", ((Book) media).getAuthor());
                obj.put("publisher", ((Book) media).getPublisher());
                obj.put("pages", ((Book) media).getPages());
                obj.put("class", "Book");
            }
            else if(c == Film.class){
                obj.put("director", ((Film) media).getDirector());
                obj.put("duration", ((Film) media).getDuration());
                obj.put("class", "Film");
            }
            else if(c == Game.class){
                obj.put("platform", ((Game) media).getPlatform());
                obj.put("class", "Game");
            }
            else if(c == Music.class){
                obj.put("artist", ((Music) media).getArtist());
                obj.put("album", ((Music) media).getAlbum());
                obj.put("duration", ((Music) media).getDuration());
                obj.put("class", "Music");
            }
            array.put(obj);
        }
        return array;
    }

    /**
     * Writes the library to a json file.
     * @param lib The library object.
     * @throws FileNotFoundException
     */
    public void writeLibJSON(Library lib, String output) throws FileNotFoundException{
        PrintWriter pw = new PrintWriter(output);
        pw.print(libToJson(lib));
        pw.flush();
        pw.close();
        System.out.println("Library written to " + output);
    }
}
