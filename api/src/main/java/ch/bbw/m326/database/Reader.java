package ch.bbw.m326.database;

import ch.bbw.m326.media.Book;
import ch.bbw.m326.media.Film;
import ch.bbw.m326.media.Game;
import ch.bbw.m326.media.Music;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * The Reader class manages all file reading related functions.
 *
 * @author Leandro Ferrer
 * @version 1.0
 */
public class Reader {
    String libraryDB = "database/library.json";
    String userDB = "database/users.json";

    /**
     * Reads the library from the json file and inserts the data into the library arraylist.
     * @param lib The library object.
     * @throws IOException
     */
    public void readLibraryDB(Library lib) throws IOException {
        // Reads the database file and parses it into a JSONArray
        FileReader fr = new FileReader(libraryDB);
        BufferedReader br = new BufferedReader(fr);
        JSONArray JSONarray = new JSONArray(br.readLine());
        br.close();
        fr.close();

        // Parses the JSONArray into the Library
        for (int i = 0; i < JSONarray.length(); i++) {
            JSONObject obj = JSONarray.getJSONObject(i);
            int id = obj.getInt("id");
            String c = obj.getString("class");
            String title = obj.getString("title");
            String genre = obj.getString("genre");
            String type = obj.getString("type");
            int year = obj.getInt("year");
            boolean isDigital = obj.getBoolean("isDigital");
            String info = obj.getString("info");
            switch (c) {
                case "Book" -> {
                    String author = obj.getString("author");
                    String publisher = obj.getString("publisher");
                    int pages = obj.getInt("pages");
                    Book b = new Book(title, genre, type, year, isDigital, info, author, publisher, pages);
                    b.setId(id);
                    lib.addMedia(b);
                }
                case "Film" -> {
                    String director = obj.getString("director");
                    int duration = obj.getInt("duration");
                    Film f = new Film(title, genre, type, year, isDigital, info, director, duration);
                    f.setId(id);
                    lib.addMedia(f);
                }
                case "Game" -> {
                    String platform = obj.getString("platform");
                    Game g = new Game(title, genre, type, year, isDigital, info, platform);
                    g.setId(id);
                    lib.addMedia(g);
                }
                case "Music" -> {
                    String artist = obj.getString("artist");
                    String album = obj.getString("album");
                    int duration = obj.getInt("duration");
                    Music m = new Music(title, genre, type, year, isDigital, info, artist, album, duration);
                    m.setId(id);
                    lib.addMedia(m);
                }
            }
        }
    }

    /**
     * Reads the users.json file and returns the data in a JSONArray.
     * @throws IOException
     */
    public JSONArray readUserDB() throws IOException {
        // Reads the database file and parses it into a JSONArray
        FileReader fr = new FileReader(userDB);
        BufferedReader br = new BufferedReader(fr);
        JSONArray JSONarray = new JSONArray(br.readLine());
        br.close();
        fr.close();

        return JSONarray;
    }
}
