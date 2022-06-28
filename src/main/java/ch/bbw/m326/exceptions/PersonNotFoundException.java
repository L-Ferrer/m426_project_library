package ch.bbw.m326.exceptions;

/**
 * @author Leandro Ferrer
 * @version 1.0
 *
 * The PersonNotFoundException is thrown when a person not found.
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
