package ch.bbw.m326.persons;

/**
 * @author Leandro Ferrer
 * @version 1.0
 *
 * The Admin is a user with administration rights.
 * The Admin has all functions of the User class including the rights to add, edit and remove media to/from the library.
 */
public class Admin extends Person{

    public Admin(String email, String username, String password) {
        super(email, username, password);
        
    }
    
}
