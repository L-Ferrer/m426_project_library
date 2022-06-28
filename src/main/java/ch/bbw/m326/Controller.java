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
     * Returns the library object.
     * @since 1.0
     * @return The library object.
     */
    @GetMapping("/library")
    public String library() {
        return writer.libToJson(lib).toString();
    }

    /**
     * Adds a new book to the library.
     * @since 1.0
     * @param m The Book object to add.
     */
    @PostMapping(value="/library/add/book", consumes="application/json")
    public void addBook(
            @RequestBody(required = true) Book m
    ) {
        String title = m.getTitle();
        String genre = m.getGenre();
        int year = m.getYear();
        String author = m.getAuthor();
        String publisher = m.getPublisher();
        int pages = m.getPages();
        boolean isDigital = m.getIsDigital();
        String info = m.getInfo();
        String type = m.getType();
        lib.addMedia(new Book(title, genre, type, year, isDigital, info, author, publisher, pages));
    }

    /**
     * Adds a new film to the library.
     * @since 1.0
     * @param m The Film object to add.
     */
    @PostMapping(value="/library/add/film", consumes="application/json")
    public void addFilm(
            @RequestBody(required = true) Film m
    ) {
        String title = m.getTitle();
        String genre = m.getGenre();
        int year = m.getYear();
        String director = m.getDirector();
        int duration = m.getDuration();
        boolean isDigital = m.getIsDigital();
        String info = m.getInfo();
        String type = m.getType();
        lib.addMedia(new Film(title, genre, type, year, isDigital, info, director, duration));
    }

    /**
     * Adds a new game to the library.
     * @since 1.0
     * @param m The Game object to add.
     */
    @PostMapping(value="/library/add/film", consumes="application/json")
    public void addGame(
            @RequestBody(required = true) Game m
    ) {
        String title = m.getTitle();
        String genre = m.getGenre();
        int year = m.getYear();
        boolean isDigital = m.getIsDigital();
        String info = m.getInfo();
        String type = m.getType();
        String platform = m.getPlatform();
        lib.addMedia(new Game(title, genre, type, year, isDigital, info, platform));
    }

    /**
     * Adds a new music to the library.
     * @since 1.0
     * @param m The Music object to add.
     */
    @PostMapping(value="/library/add/film", consumes="application/json")
    public void addMusic(
            @RequestBody(required = true) Music m
    ) {
        String title = m.getTitle();
        String genre = m.getGenre();
        int year = m.getYear();
        String artist = m.getArtist();
        boolean isDigital = m.getIsDigital();
        String info = m.getInfo();
        String type = m.getType();
        String album = m.getAlbum();
        int duration = m.getDuration();
        lib.addMedia(new Music(title, genre, type, year, isDigital, info, artist, album, duration));
    }
}
