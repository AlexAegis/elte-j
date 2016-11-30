package weightlifting;

import java.text.DecimalFormat;

public class WeightLifter {

	private String name;
	private int weight;

	private static WeightLifter strongestWeightLifter = null;

	private WeightLifter(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	public static WeightLifter make(String name, int weight) {
		if(name.length() >= 2
				&& name.matches("[a-zA-Z0-9 ]+")
				&& weight > 0
				&& weight <= 300) {
			WeightLifter result = new WeightLifter(name, weight);
			if(strongestWeightLifter == null || result.strongerThan(strongestWeightLifter)) {
				strongestWeightLifter = result;
			}
			return result;
		} else {
			return null;
		}
	}

	public int getWeight() {
		return weight;
	}

	public static WeightLifter getStrongestWeightLifter() {
		return strongestWeightLifter;
	}

	public boolean strongerThan(WeightLifter weightLifter) {
		return getWeight() > weightLifter.getWeight();
	}

	public String show() {
		DecimalFormat formatter = new DecimalFormat("### kg");
		return name + " - " + String.format("%6s", formatter.format(weight));
	}
}