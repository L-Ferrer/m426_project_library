package ch.bbw.m326.persons;

/**
 * The User is the base level of all accounts.
 *  The User can borrow and reserve media from the library.
 *
 * @author Leandro Ferrer
 * @version 1.0
 */
public class User extends Person{

    /**
     * Constructs a new User.
     */
    public User(String email, String username, String password) {
        super(email, username, password);
    }
    
}
