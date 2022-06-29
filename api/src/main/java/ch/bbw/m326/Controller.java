package ch.bbw.m326;

import ch.bbw.m326.database.Library;
import ch.bbw.m326.database.Manager;
import ch.bbw.m326.database.Reader;
import ch.bbw.m326.database.Writer;
import ch.bbw.m326.media.Book;
import ch.bbw.m326.media.Film;
import ch.bbw.m326.media.Game;
import ch.bbw.m326.media.Music;
import ch.bbw.m326.persons.*;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * @author Leandro Ferrer
 * @version 1.0
 *
 * The Controller class manages all REST related functions.
 */
@CrossOrigin
@RestController
public class Controller extends Hash {
    Manager mng = new Manager();
    Writer writer = new Writer();
    Library lib = mng.getLibraryObject();

    /**
     * Returns all media in the library as a JSON String.
     * @return All media as JSON String.
     */
    @GetMapping("/library")
    public String library() {
        return writer.libToJson(lib).toString();
    }

    /**
     * Adds a new media to the library.
     *
     * @param objClass The class of the media to be added.
     *                  Possible values: "Book", "Film", "Game", "Music".
     * @param title The title of the media.
     * @param genre The genre of the media.
     * @param type The type of the media.
     * @param year The release year of the media.
     * @param isDigital True if the media is digital, false if it is physical.
     * @param info The description of the media.
     * @param director The director of the film.
     *                 Only used if the media is a film.
     * @param duration The duration of the film or song.
     *                 Only used if the media is a film or song.
     * @param artist The artist of the song.
     *               Only used if the media is a song.
     * @param album The album of the song.
     *              Only used if the media is a song.
     * @param platform The platform of the game.
     *                 Only used if the media is a game.
     */
    @GetMapping(value="/library/add/media")
    public void addMedia(
            @RequestParam(required = true) String objClass,
            @RequestParam(required = true) String title,
            @RequestParam(required = true) String genre,
            @RequestParam(required = true) String type,
            @RequestParam(required = true) Integer year,
            @RequestParam(required = true) boolean isDigital,
            @RequestParam(required = true) String info,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String publisher,
            @RequestParam(required = false) Integer pages,
            @RequestParam(required = false) String director,
            @RequestParam(required = false) Integer duration,
            @RequestParam(required = false) String artist,
            @RequestParam(required = false) String album,
            @RequestParam(required = false) String platform
    ) {
        if(objClass.equals("Book")) {
            lib.addMedia(new Book(title, genre, type, year, isDigital, info, author, publisher, pages));
        } else if(objClass.equals("Film")) {
            lib.addMedia(new Film(title, genre, type, year, isDigital, info, director, duration));
        } else if(objClass.equals("Game")) {
            lib.addMedia(new Game(title, genre, type, year, isDigital, info, platform));
        } else if(objClass.equals("Music")) {
            lib.addMedia(new Music(title, genre, type, year, isDigital, info, artist, album, duration));
        }
    }

    /**
     * Returns the login token of the user
     * @param req The users credentials. (username, password)
     * @return The login token of the user.
     */
    @PostMapping(value="/user/login/auth", consumes="application/json", produces="application/json")
    public String login(@RequestBody String req) {
        Reader reader = new Reader();
        JSONObject obj = new JSONObject(req);
        JSONObject tokenObj = new JSONObject();
        try {
            JSONArray array = reader.readUserDB();
            for(int i = 0; i < array.length(); i++) {
                if(array.getJSONObject(i).getString("username").equals(obj.getString("username")) &&
                        array.getJSONObject(i).getString("password").equals(obj.getString("password"))) {
                    String token = array.getJSONObject(i).getString("token");
                    String uname = array.getJSONObject(i).getString("username");
                    tokenObj.put("token", token);
                    tokenObj.put("username", uname);
                    return tokenObj.toString();
                }
            }
            tokenObj.put("token", "");
            tokenObj.put("username", "");
            return tokenObj.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping(value="/user/add", consumes="application/json")
    public String addUser(@RequestBody User u){
        JSONObject obj = new JSONObject();
        PersonManager pm = new PersonManager();
        try {
            pm.addUser(u);
            obj.put("status", "success");
            return obj.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        obj.put("status", "failed");
        return obj.toString();
    }
}
