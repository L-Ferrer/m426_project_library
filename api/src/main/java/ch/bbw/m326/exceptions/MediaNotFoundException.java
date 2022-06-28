package ch.bbw.m326.exceptions;

/**
 * The MediaNotFoundException is thrown when a media object is not found in the library.
 *
 * @author Leandro Ferrer
 * @version 1.0
 */
public class MediaNotFoundException extends Exception{

    /**
     * Constructs a new MediaNotFoundException with the specified detail message.
     * @param message The detail message.
     */
    public MediaNotFoundException(String message) {
        super(message);
    }
}
