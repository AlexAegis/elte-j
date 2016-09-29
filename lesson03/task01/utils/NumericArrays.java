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

	public static double[] normalize(double[] a) {
		double[] normalized = new double[a.length];
		//FIXME
		return normalized;
	}

}