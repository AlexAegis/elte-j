package utils;

public class Cryptor {
	
	public static String encode(String s, char encryption) {
		String result = "";
		for(char ch : s.toCharArray()) {
			result += ch^encryption;
		}
		return result;
	}


	public static String decode(String s, char encryption) {

		return encode(encode(s, encryption));
	}

}