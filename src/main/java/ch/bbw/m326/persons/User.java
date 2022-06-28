package ch.bbw.m326.persons;

/**
 * @author Leandro Ferrer
 * @version 1.0
 *
 * The User is the base level of all accounts.
 * The User can borrow and reserve media from the library.
 */
public class User extends Person{

    public User(String email, String username, String password) {
        super(email, username, password);
    }
    
}
