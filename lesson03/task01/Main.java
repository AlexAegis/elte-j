import utils.NumericArrays;

public class Main {

	public static void main(String[] args) {
		double[] a = new double[5];
	
		for(int i = 0; i < a.length; i++) {
			a[i] = i + 1;
		}
		for(double d : a) {
			System.out.println(d);
		}
		System.out.println();

		System.out.println(NumericArrays.sum(a));
		System.out.println(NumericArrays.average(a));
		System.out.println(NumericArrays.normalize(a));
	}
}