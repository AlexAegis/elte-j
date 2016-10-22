package tests;

import main.Main;
import utest.*;

public class MainTest extends Testable {
	String input = "Simon Marlow,Parallel and Concurrent Programming in Haskell,O'Reilly,2013\n"
			+ "Gerald Huet,Functional Pearl: The Zipper,,1997\n" + "Bryan O'Sullivan,Real World Haskell,O'Reilly,2008\n"
			+ "Duncat Coutts,Stream Fusion: From Lists to Streams to Nothing at All,,2007\n"
			+ "Paul Hudak,The Haskell School of Expression,Cambridge University Press,2000\n"
			+ "Simon Thompson,Haskell: The Craft of Functional Programming,Addison-Wesley,2011\n"
			+ "Ralf Hinze,Finger Trees: A Simple General-purpose Data Structure,,2006\n"
			+ "Ralf Hinze,Functional Pearl: A fresh look at binary search trees,,2002\n"
			+ "Chris Okasaki,Purely Functional Data Structures,,1998\n"
			+ "Simon Marlow,Multicore Garbage Collection with Local Heaps,,2011\n"
			+ "Simon Marlow,Runtime Support for Multicore Haskell,,2009\n" + "Oleg Kiselyov,Iteratees,,2012\n"
			+ "Graham Hutton,Programming in Haskell,Cambridge University Press,2007\n"
			+ "Joshua Bloch,Effective Java: Programming Language Guide,Addison-Wesley,2001\n"
			+ "David Chisnall,The Definitive Guide to the Xen Hypervisor,Prentice Hall,2007\n";

	String output1 = "[0] Marlow, S. Parallel and Concurrent Programming in Haskell, O'Reilly, 2013\n"
			+ "[1] Huet, G. Functional Pearl: The Zipper, 1997\n"
			+ "[2] O'Sullivan, B. Real World Haskell, O'Reilly, 2008\n"
			+ "[3] Coutts, D. Stream Fusion: From Lists to Streams to Nothing at All, 2007\n"
			+ "[4] Hudak, P. The Haskell School of Expression, Cambridge University Press, 2000\n"
			+ "[5] Thompson, S. Haskell: The Craft of Functional Programming, Addison-Wesley, 2011\n"
			+ "[6] Hinze, R. Finger Trees: A Simple General-purpose Data Structure, 2006\n"
			+ "[7] Hinze, R. Functional Pearl: A fresh look at binary search trees, 2002\n"
			+ "[8] Okasaki, C. Purely Functional Data Structures, 1998\n"
			+ "[9] Marlow, S. Multicore Garbage Collection with Local Heaps, 2011\n"
			+ "[10] Marlow, S. Runtime Support for Multicore Haskell, 2009\n" + "[11] Kiselyov, O. Iteratees, 2012\n"
			+ "[12] Hutton, G. Programming in Haskell, Cambridge University Press, 2007\n"
			+ "[13] Bloch, J. Effective Java: Programming Language Guide, Addison-Wesley, 2001\n"
			+ "[14] Chisnall, D. The Definitive Guide to the Xen Hypervisor, Prentice Hall, 2007\n";

	String output2 = "[Marlow2013] Marlow, S. Parallel and Concurrent Programming in Haskell, O'Reilly, 2013\n"
			+ "[Huet1997] Huet, G. Functional Pearl: The Zipper, 1997\n"
			+ "[O'Sullivan2008] O'Sullivan, B. Real World Haskell, O'Reilly, 2008\n"
			+ "[Coutts2007] Coutts, D. Stream Fusion: From Lists to Streams to Nothing at All, 2007\n"
			+ "[Hudak2000] Hudak, P. The Haskell School of Expression, Cambridge University Press, 2000\n"
			+ "[Thompson2011] Thompson, S. Haskell: The Craft of Functional Programming, Addison-Wesley, 2011\n"
			+ "[Hinze2006] Hinze, R. Finger Trees: A Simple General-purpose Data Structure, 2006\n"
			+ "[Hinze2002] Hinze, R. Functional Pearl: A fresh look at binary search trees, 2002\n"
			+ "[Okasaki1998] Okasaki, C. Purely Functional Data Structures, 1998\n"
			+ "[Marlow2011] Marlow, S. Multicore Garbage Collection with Local Heaps, 2011\n"
			+ "[Marlow2009] Marlow, S. Runtime Support for Multicore Haskell, 2009\n"
			+ "[Kiselyov2012] Kiselyov, O. Iteratees, 2012\n"
			+ "[Hutton2007] Hutton, G. Programming in Haskell, Cambridge University Press, 2007\n"
			+ "[Bloch2001] Bloch, J. Effective Java: Programming Language Guide, Addison-Wesley, 2001\n"
			+ "[Chisnall2007] Chisnall, D. The Definitive Guide to the Xen Hypervisor, Prentice Hall, 2007\n";

	String output3 = "[Ma13] Marlow, S. Parallel and Concurrent Programming in Haskell, O'Reilly, 2013\n"
			+ "[Hu97] Huet, G. Functional Pearl: The Zipper, 1997\n"
			+ "[O'08] O'Sullivan, B. Real World Haskell, O'Reilly, 2008\n"
			+ "[Co07] Coutts, D. Stream Fusion: From Lists to Streams to Nothing at All, 2007\n"
			+ "[Hu00] Hudak, P. The Haskell School of Expression, Cambridge University Press, 2000\n"
			+ "[Th11] Thompson, S. Haskell: The Craft of Functional Programming, Addison-Wesley, 2011\n"
			+ "[Hi06] Hinze, R. Finger Trees: A Simple General-purpose Data Structure, 2006\n"
			+ "[Hi02] Hinze, R. Functional Pearl: A fresh look at binary search trees, 2002\n"
			+ "[Ok98] Okasaki, C. Purely Functional Data Structures, 1998\n"
			+ "[Ma11] Marlow, S. Multicore Garbage Collection with Local Heaps, 2011\n"
			+ "[Ma09] Marlow, S. Runtime Support for Multicore Haskell, 2009\n"
			+ "[Ki12] Kiselyov, O. Iteratees, 2012\n"
			+ "[Hu07] Hutton, G. Programming in Haskell, Cambridge University Press, 2007\n"
			+ "[Bl01] Bloch, J. Effective Java: Programming Language Guide, Addison-Wesley, 2001\n"
			+ "[Ch07] Chisnall, D. The Definitive Guide to the Xen Hypervisor, Prentice Hall, 2007\n";

	String output4 = "[Thompson2011] Thompson, S. Haskell: The Craft of Functional Programming, Addison-Wesley, 2011\n"
			+ "[Bloch2001] Bloch, J. Effective Java: Programming Language Guide, Addison-Wesley, 2001\n";

	String output5 = "[Marlow2013] Marlow, S. Parallel and Concurrent Programming in Haskell, O'Reilly, 2013\n"
			+ "[Marlow2011] Marlow, S. Multicore Garbage Collection with Local Heaps, 2011\n"
			+ "[Marlow2009] Marlow, S. Runtime Support for Multicore Haskell, 2009\n";

	String output6 = "[0] Marlow, S. Parallel and Concurrent Programming in Haskell, O'Reilly, 2013\n"
			+ "[9] Marlow, S. Multicore Garbage Collection with Local Heaps, 2011\n"
			+ "[10] Marlow, S. Runtime Support for Multicore Haskell, 2009\n";

	String output7 = "[Hinze2006] Hinze, R. Finger Trees: A Simple General-purpose Data Structure, 2006\n"
			+ "[Hinze2002] Hinze, R. Functional Pearl: A fresh look at binary search trees, 2002\n";

	String output8 = "[Hu00] Hudak, P. The Haskell School of Expression, Cambridge University Press, 2000\n"
			+ "[Hu07] Hutton, G. Programming in Haskell, Cambridge University Press, 2007\n";

	String output9 = "[Ma13] Marlow, S. Parallel and Concurrent Programming in Haskell, O'Reilly, 2013\n"
			+ "[Ma11] Marlow, S. Multicore Garbage Collection with Local Heaps, 2011\n"
			+ "[Ma09] Marlow, S. Runtime Support for Multicore Haskell, 2009\n";

	public void assertion() {
		new Main();

		check("Alapertelmezes szerint nem megfelelo formatumba kerulnek beolvasasra az adatok.", new String[] {},
				output1);

		check("A format= raw parametert nem jol kezeli a program.", new String[] { "format=", "raw" }, output1);

		check("A format= authorYear parametert nem jol kezeli a program.", new String[] { "format=", "authorYear" },
				output2);

		check("A format= authorYearCompact parametert nem jol kezeli a program.",
				new String[] { "format=", "authorYearCompact" }, output3);

		check("A publisher= szuresi parametert nem jol kezeli a program.",
				new String[] { "publisher=", "Addison-Wesley", "format=", "authorYear" }, output4);

		check("Az author= szuresi parametert nem jol kezeli a program.",
				new String[] { "format=", "authorYear", "author=", "Simon Marlow" }, output5);

		check("A tobbszoros format= formazasi parametert nem jol kezeli a program.",
				new String[] { "format=", "authorYear", "author=", "Simon Marlow", "format=", "raw" }, output6);

		check("A tobbszoros author= szuresi parametert nem jol kezeli a program.",
				new String[] { "format=", "authorYear", "author=", "Simon Marlow", "author=", "Ralf Hinze" }, output7);

		check("A tobbszoros publisher= szuresi parametert nem jol kezeli a program.", new String[] { "publisher=",
				"Addison-Wesley", "publisher=", "Cambridge University Press", "format=", "authorYearCompact" },
				output8);

		check("Az egyszerre meglevo author= es publisher= szuresi parametereket nem jol kezeli a program.",
				new String[] { "publisher=", "Addison-Wesley", "format=", "authorYearCompact", "author=",
						"Simon Marlow" },
				output9);

	}

	private void check(String message, String[] arguments, String expectedOutput) {
		grabSystemOut();
		feedSystemIn(input);
		Main.main(arguments);
		releaseSystemIn();
		releaseSystemOut();
		String out = getSystemOut();
		check(message, out.equals(expectedOutput));
	}

	public String description() {
		return "main.Main";
	}

	public String className() {
		return "main.Main";
	}

	public Object[] expectedMethods() throws Exception {
		return new Object[] { staticMethod(className() + ".main", String[].class), constructor(className()) };
	}

	public Object[] expectedFields() throws Exception {
		return new Object[] {};
	}

	public static void main(String... args) {
		Test.main(new MainTest());
	}
}
