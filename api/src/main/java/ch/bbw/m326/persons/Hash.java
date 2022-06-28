package ch.bbw.m326.persons;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * The Hash class contains the hash function used for passwords.
 *
 * @author Leandro Ferrer
 * @version 1.0
 */
public abstract class Hash {

    /**
     * Hashes the input string using SHA3-256.
     * @param input The password to be hashed.
     * @return The hashed password.
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public String hashString(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        MessageDigest digest = MessageDigest.getInstance("SHA3-256");
        digest.reset();
	    digest.update(input.getBytes("utf8"));
	    return String.format("%040x", new BigInteger(1, digest.digest()));
    }
}
