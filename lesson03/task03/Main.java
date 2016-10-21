import utils.Sodoku;

public class Main {

	public static void main(String[] args) {
		byte[][] b = new byte[][]{
			{1,1,1},
			{2,2,2},
			{3,3,3}
		};

		System.out.println(Sodoku.show(b));

		if(Sodoku.check(b)) {
			System.out.println("Checked");
		}
	}
}