package utils;

public class Sodoku {

	public static boolean check(byte[][] square) {
		boolean result = true;
		result &= (square.length == 3);
		for(byte[] row : square) {
			result &= (row.length == 3);
			for(byte element : row) result &= element < 10 && element > 0;
		}
		return result;
	}

	public static String show(byte[][] square) {
		String result = "";
		for(byte[] row : square) {
			for(byte element : row) {
				result += element;
				result += " ";
			}
			result += "\n";
		}
		return result;
	}

}