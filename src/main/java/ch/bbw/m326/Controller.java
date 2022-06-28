package ch.bbw.m326;

import ch.bbw.m326.database.Library;
import ch.bbw.m326.database.Manager;
import ch.bbw.m326.database.Writer;
import ch.bbw.m326.media.Book;
import ch.bbw.m326.media.Film;
import ch.bbw.m326.media.Game;
import ch.bbw.m326.media.Music;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author Leandro Ferrer
 * @version 1.0
 *
 * The Controller class manages all REST related functions.
 */
@CrossOrigin
@RestController
public class Controller {
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
}
