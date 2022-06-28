package ch.bbw.m326.exceptions;

/**
 * The PersonNotFoundException is thrown when a person not found.
 *
 * @author Leandro Ferrer
 * @version 1.0
 */
public class PersonNotFoundException extends Exception{

    /**
     * Constructs a new PersonNotFoundException with the specified detail message.
     * @param message The detail message.
     */
    public PersonNotFoundException(String message) {
        super(message);
    }
}
