package utils;

public class NumericArrays {


	public static double sum(double[] a) {
		double sum = 0;
		for (double d : a) {
			sum += d;
		}
		return sum;
	}

	public static double average(double[] a) {
		return sum(a) / a.length;
	}

	public static void normalize(double[] a) {
		double s = sum(a);
		for(int i = 0; i < a.length; i++) {
			a[i] /= s;
		}
	}

}