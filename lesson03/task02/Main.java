import utils.Cryptor;

public class Main {

	public static void main(String[] args) {
		String a = Cryptor.encode("asd", "^");
		String r = Cryptor.decode(a, "^");
		System.out.println(a);
		System.out.println(r);
	}
}