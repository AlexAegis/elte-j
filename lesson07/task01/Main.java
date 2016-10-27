public class Main {
	public static void main(String[] args) {
		int[] values = new int[] {3, 1, 2};
		ChainList cl = new ChainList();
		for(int i : values) {
			cl.add(i);
		}
		System.out.println("length(): " + cl.length());
		System.out.println("getFirst(): " + cl.getFirst());
		System.out.println("getRest().getFirst(): " + cl.getRest().getFirst());
		System.out.println("getRest().getRest().getFirst():" + cl.getRest().getRest().getFirst());
	}
}