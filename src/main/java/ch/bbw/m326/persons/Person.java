package ch.bbw.m326.persons;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import ch.bbw.m326.media.Media;

/**
 * @author Leandro Ferrer
 * @version 1.0
 *
 * The Person class is the base class for all Users and Admins.
 */
public abstract class Person extends Hash{
    private String email, username, password;
    ArrayList<Media> borrowList = new ArrayList<>();
    ArrayList<Media> reservationList = new ArrayList<>();

    public Person(String email, String username, String password) {
        this.email = email;
        this.username = username;
        try {
            this.password = hashString(password);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Media> getBorrowList() {
        return this.borrowList;
    }

    public void addBorrow(Media media) {
        this.borrowList.add(media);
    }

    public void removeBorrow(Media media) {
        this.borrowList.remove(media);
    }

    public ArrayList<Media> getReservationList() {
        return this.reservationList;
    }

    public void addReservation(Media media) {
        this.reservationList.add(media);
    }

    public void removeReservation(Media media) {
        this.reservationList.remove(media);
    }
}
