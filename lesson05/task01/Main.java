import utils.IntList;
import utils.DoubleMatrix;
import utils.IntTree;
import tests.IntTreeTest;

public class Main {
    public static void main(String[] args) {
        IntList l = new IntList(new int[]{1, 3});
        l.add(2, 2);
        l.add(4);
        l.show();

        l.remove();
        l.show();
		
		System.out.println();
		
		DoubleMatrix dm = new DoubleMatrix(2, 3, 5);
		dm.set(4d, 2, 2);
		System.out.println(dm.get(2, 2));

		System.out.println();
		
		IntTree it = new IntTree(10);
		it.insert(5).insert(12).insert(40);
		if(it.contains(5)) {
			System.out.println("it contains 5");
		}
		
		IntTreeTest.main(new String[]{});
		
    }
}
