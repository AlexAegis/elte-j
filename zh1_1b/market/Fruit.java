package market;

import java.util.Iterator;

public class Fruit {

	private String name;
	private int price;

	private static Fruit cheapestFruit = null;

	private Fruit(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public static Fruit make(String name, int price) {
		if(name.length() >= 2
			&& name.matches("[a-zA-Z]+") 
			&& price <= 5000
			&& price >= 5
			&& (price % 5 == 0 || price % 10 == 0)) {
			Fruit result = new Fruit(name, price);
			if(cheapestFruit == null || result.cheaperThan(cheapestFruit)) {
				cheapestFruit = result;
			}
			return result;
		} else {
			return null;
		}
	}

	public static Fruit getCheapestFruit() {
		return cheapestFruit == null ? null : new Fruit(cheapestFruit.name, cheapestFruit.price);
	}

	public int getPrice() {
		return price;
	}

	public boolean cheaperThan(Fruit fruit) {
		return fruit != null && this.getPrice() < fruit.getPrice();
	}

	public String show() {
		StringBuilder sb = new StringBuilder();
		Iterator i = new StringBuffer(Integer.toString(price)).reverse()
				.chars().mapToObj(c -> (char) c).iterator();
		int count = 0;
		while(i.hasNext()) {
			if(count != 0 && count % 3 == 0) {
				sb.append(" ");
			} else {
				sb.append(i.next());
			}
			count++;
		}
		return name + " (" + sb.reverse().toString() + " Ft)";
	}
}