package ch.bbw.m326.persons;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class Hash {
    public String hashString(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        MessageDigest digest = MessageDigest.getInstance("SHA3-256");
        digest.reset();
	    digest.update(input.getBytes("utf8"));
	    return String.format("%040x", new BigInteger(1, digest.digest()));
    }
}
