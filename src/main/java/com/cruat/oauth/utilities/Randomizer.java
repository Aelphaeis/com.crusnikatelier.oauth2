package com.cruat.oauth.utilities;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.SecureRandom;

public class Randomizer {
	public static final String DIGITS = "0123456789";
	public static final String LOWERS = "abcdefghijklmnopqrstuvwxyz";
	public static final String UPPERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String ALPHANUMS = UPPERS + LOWERS + DIGITS;
	SecureRandom generator;

	public Randomizer() {
		generator = new SecureRandom();
	}

	public byte[] getBytes(int size) {
		byte[] bArr = new byte[size];
		generator.nextBytes(bArr);
		return bArr;
	}

	public int getInt() {
		return generator.nextInt();
	}

	public String getAlphanumeric(int characterCount) {
		return getRandomCharacterSubset(ALPHANUMS, characterCount);
	}

	public String getRandomCharacterSubset(String original, int count) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < count; i++) {
			int index = generator.nextInt(original.length());
			builder.append(original.charAt(index));
		}
		return builder.toString();
	}

	public byte getByte() {
		return getBytes(1)[0];
	}

	public short getShort() {
		return wrapBytes(2).getShort();
	}

	public long getLong() {
		return wrapBytes(8).getLong();
	}

	public float getFloat() {
		return wrapBytes(4).getFloat();
	}

	public double getDouble() {
		return wrapBytes(8).getDouble();
	}

	public char getChar() {
		return wrapBytes(2).getChar();
	}

	private ByteBuffer wrapBytes(int size) {
		return ByteBuffer.wrap(getBytes(size)).order(ByteOrder.LITTLE_ENDIAN);
	}
}
