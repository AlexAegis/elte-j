package utils;

public class DoubleMatrix {
	
	private double[][] matrix;
	
	public DoubleMatrix(int... lineLengths) {
		this.matrix = new double[lineLengths.length][];
		for(int i = 0; i < lineLengths.length; i++) {
			this.matrix[i] = new double[lineLengths[i]];
		}
	}
	
	public DoubleMatrix set(double value, int x, int y) {
		this.matrix[x][y] = value;
		return this;
	} 
	
	public double get(int x, int y) {
		return this.matrix[x][y];
	}
	
}