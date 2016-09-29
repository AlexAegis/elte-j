import utils.Cryptor;

public class Main {

	public static void main(String[] args) {
		String a = Cryptor.encode("asd", '^');
		System.out.println(a);
		String b = Cryptor.decode(a, '^');
		System.out.println(b);
	}
}