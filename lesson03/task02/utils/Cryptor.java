package utils;

public class Cryptor {
	

	public static String encode(String s, String secret) {
		char[] buffer = s.toCharArray();
		int j = 0;
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] ^= secret.charAt(j);
			j = (j + 1) % secret.toCharArray().length;
		}
		return new String(buffer);
	}


	public static String decode(String s, String secret) {
		return encode(s, secret);
	}

}