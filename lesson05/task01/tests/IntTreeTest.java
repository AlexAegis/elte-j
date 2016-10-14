package tests;

import utils.IntTree;

public class IntTreeTest {
	public static void main(String[] args) {
		IntTree it = new IntTree(5);
		int[] values = new int[]{2, 4, 8, 10, 60, 30, 21, -3, 32, 100, 1};
		for(int i = 0; i < values.length; i++) {
			it.insert(values[i]);
		}
		for(int i = -15; i < 15; i++) {
			System.out.println(i + " " + it.contains(i));
		}
	}
}