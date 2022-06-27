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

@CrossOrigin
@RestController
public class Controller {
    Manager mng = new Manager();
    Writer writer = new Writer();
    Library lib = mng.getLibraryObject();

    @GetMapping("/library")
    public String library() {
        try {
            return writer.libToJson(lib).toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping(value="/library/add/book", consumes="application/json")
    public void addBook(
            @RequestBody(required = true) Book b
    ) {
        String title = b.getTitle();
        String genre = b.getGenre();
        int year = b.getYear();
        String author = b.getAuthor();
        String publisher = b.getPublisher();
        int pages = b.getPages();
        boolean isDigital = b.getIsDigital();
        String info = b.getInfo();
        String type = b.getType();
        lib.addMedia(new Book(title, genre, type, year, isDigital, info, author, publisher, pages));
    }
    @PostMapping(value="/library/add/film", consumes="application/json")
    public void addFilm(
            @RequestBody(required = true) Film b
    ) {
        String title = b.getTitle();
        String genre = b.getGenre();
        int year = b.getYear();
        String director = b.getDirector();
        int duration = b.getDuration();
        boolean isDigital = b.getIsDigital();
        String info = b.getInfo();
        String type = b.getType();
        lib.addMedia(new Film(title, genre, type, year, isDigital, info, director, duration));
    }
    @PostMapping(value="/library/add/film", consumes="application/json")
    public void addGame(
            @RequestBody(required = true) Game b
    ) {
        String title = b.getTitle();
        String genre = b.getGenre();
        int year = b.getYear();
        boolean isDigital = b.getIsDigital();
        String info = b.getInfo();
        String type = b.getType();
        String platform = b.getPlatform();
        lib.addMedia(new Game(title, genre, type, year, isDigital, info, platform));
    }
    @PostMapping(value="/library/add/film", consumes="application/json")
    public void addMusic(
            @RequestBody(required = true) Music b
    ) {
        String title = b.getTitle();
        String genre = b.getGenre();
        int year = b.getYear();
        String artist = b.getArtist();
        boolean isDigital = b.getIsDigital();
        String info = b.getInfo();
        String type = b.getType();
        String album = b.getAlbum();
        int duration = b.getDuration();
        lib.addMedia(new Music(title, genre, type, year, isDigital, info, artist, album, duration));
    }
}
