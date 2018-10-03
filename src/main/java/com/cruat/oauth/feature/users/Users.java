package com.cruat.oauth.feature.users;

import java.math.BigInteger;
import java.util.UUID;

import org.bouncycastle.crypto.generators.OpenBSDBCrypt;

import com.cruat.oauth.utilities.Randomizer;

public class Users {
	
	public static final int HASH_COST = 13;
	public static final String SALT_CHARACTER_SET = Randomizer.ALPHANUMS + "./";
	
	/**
	 * Returns a randomly generated hex string 32 characters long
	 * @return
	 */
	public static String generateUserSalt() {
		Randomizer randomizer = new Randomizer();
		byte[] generatedBytes = randomizer.getBytes(16);
		BigInteger buffer = new BigInteger(1, generatedBytes);
		return buffer.toString(16);
	}
	
	/**
	 * Converts a hex string to a byte array.
	 * @param hex
	 * @return
	 */
	public static byte [] hexToByteArray(String hex) {
	    int len = hex.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
	                             + Character.digit(hex.charAt(i+1), 16));
	    }
	    return data;
	}
	
	/**
	 * Generates a universally unique identifier 36 characters long
	 * @return
	 */
	public static String generateUserGuid() {
		UUID guid = UUID.randomUUID();
		return guid.toString();
	}
	
	/**
	 * Takes a password and a salt (32 character hex string) and 
	 * returns a 60 character length hash.
	 * 
	 * @param password
	 * @param salt
	 * @return
	 */
	public static String hashPassword(String password, String salt) {
		byte[] saltBytes = hexToByteArray(salt);
		char[] pwdCharArr = password.toCharArray();
		return OpenBSDBCrypt.generate(pwdCharArr, saltBytes, HASH_COST);
	}
	
	private Users() { }
}
