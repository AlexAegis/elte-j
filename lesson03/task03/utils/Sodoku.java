package utils;

import java.util.Arrays;

public class Sodoku {

	public static boolean check(byte[][] square) {
		boolean result = true;
		result &= (square.length == 3);
		for(byte[] row : square) {
			result &= (row.length == 3);
			for(byte element : row) result &= element < 10 && element > 0;
		}
		result &= checkSudoku(square);
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

	private static boolean checkSudoku(byte[][] grid) {

	    for (int i = 0; i < 9; i++) {
	        byte[] row = new byte[9];
	        byte[] square = new byte[9];
	        byte[] column = grid[i].clone();

	        for (byte j = 0; j < 9; j ++) {
	            row[j] = grid[j][i];
	            square[j] = grid[(i / 3) * 3 + j / 3][i * 3 % 9 + j % 3];
	        }
	        if (!(validate(column) && validate(row) && validate(square)))
	            return false;
	    }
	    return true;
	}

	private static boolean validate(byte[] check) {
	    byte i = 0;
	    Arrays.sort(check);
	    for (byte number : check) {
	        if (number != ++i)
	            return false;
	    }
	    return true;
	}
}
