package com.crusnikatelier.oauth2.utilities;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.SecureRandom;

public class Randomizer {
	public final static String alphanumerics = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	SecureRandom generator;
	
	public Randomizer(){
		generator = new SecureRandom();
	}
	
	public byte getByte(){
		return getBytes(1)[0];
	}
	
	public byte[] getBytes(int size) {
		byte[]bArr = new byte[size];
		generator.nextBytes(bArr);
		return bArr;
	}
	
	public short getShort(){
		return ByteBuffer.wrap(getBytes(2)).order(ByteOrder.LITTLE_ENDIAN).getShort();
	}
	
	public int getInt(){
		return generator.nextInt();
	}
	
	public long getLong(){
		return ByteBuffer.wrap(getBytes(8)).order(ByteOrder.LITTLE_ENDIAN).getLong();
	}
	
	public float getFloat(){
		return  ByteBuffer.wrap(getBytes(4)).order(ByteOrder.LITTLE_ENDIAN).getFloat();
	}
	
	public double getDouble(){
		return ByteBuffer.wrap(getBytes(8)).order(ByteOrder.LITTLE_ENDIAN).getDouble();
	}
	
	public char getChar(){
		return ByteBuffer.wrap(getBytes(2)).order(ByteOrder.LITTLE_ENDIAN).getChar();
	}
	
	public String getAlphanumeric(int characterCount){
		return getRandomCharacterSubset(alphanumerics, characterCount);
	}
	
	public String getRandomCharacterSubset(String original, int characterCount) {
		String s = "";
		for(int i = 0; i < characterCount; i++){
			s += original.charAt(generator.nextInt(original.length()));
		}
		return s;
	}
}
