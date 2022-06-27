package ch.bbw.m326.database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import ch.bbw.m326.media.*;
import org.json.JSONArray;
import org.json.JSONObject;

public class Writer {
    public JSONArray libToJson(Library lib) throws IOException {
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

    public void writeJSON(Library lib, String output) throws FileNotFoundException{
        PrintWriter pw = new PrintWriter(output);
        try {
            pw.print(libToJson(lib));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pw.flush();
        pw.close();
        System.out.println("Library written to " + output);
    }
}
