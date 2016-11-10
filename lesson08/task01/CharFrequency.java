import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class CharFrequency {

	public static void main(String[] args) {

		try(Scanner scn = new Scanner(System.in)) {

			Set<Character> freq = new HashSet<>();

			while(scn.hasNextLine()) {
				
				char[] line = scn.nextLine().toCharArray();
				for(char c : line) {
					freq.add(c);
				}

				StringBuilder sb = new StringBuilder();
				for(Character c : freq) {
					sb.append(c + " ");
				}
				System.out.println("Chars: " + sb.toString());
			}
		}
	}
}