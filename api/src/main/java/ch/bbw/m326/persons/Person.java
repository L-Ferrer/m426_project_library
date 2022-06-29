package ch.bbw.m326.persons;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import ch.bbw.m326.media.Media;

/**
 *  The Person class is the base class for all Users and Admins.
 *
 * @author Leandro Ferrer
 * @version 1.0
 */
public abstract class Person extends Hash{
    private String email, username, password, token, privilege;
    private int id;
    ArrayList<Media> borrowList = new ArrayList<>();
    ArrayList<Media> reservationList = new ArrayList<>();

    /**
     * Constructor for Person objects.
     */
    public Person(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
