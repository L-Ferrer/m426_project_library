package ch.bbw.m326.persons;

/**
 * The Admin is a user with administration rights.
 * It has all functions of the User class including the rights to add, edit and remove media to/from the library.
 *
 * @author Leandro Ferrer
 * @version 1.0
 */
public class Admin extends Person{

    /**
     * Constructs a new Admin.
     */
    public Admin(String email, String username, String password) {
        super(email, username, password);
        
    }
    
}
