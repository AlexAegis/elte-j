# elte-proglang-java

## ELTE Programozási Nyelvek 2 - 2016/2017-1

### Halló mindenki!

#### Írjuk meg Javaban a hagyományos "Hello world" programot!

/**

- "Hello world" program. */

public class HelloWorld { public static void main(String[] args) { System.out.println("Hello World!"); } } Fontos, hogy az állomány neve megegyezzen a benne definiált publikus osztály nevével. Vagyis, ha Foo.java az állomány neve, akkor legyen benne egy Foo nevű osztály, amelyet a public class Foo definícióval fejtünk ki.

Kiírás a konzolra

Hasonlóan más nyelvekhez, a konzolra itt is többféle módon lehet írni, a java.lang.System osztályon keresztül:

Szabványos bemenet ("standard input"): System.in objektum. Szabványos kimenet ("standard output"): System.out objektum. Szabványos hibakimenet ("standard error"): System.err objektum. A kiírandó szövegben szerepelhetnek vezérlőkarakterek (escape sequence), pl. \r, \n, \t, \b, stb. A System osztály további segédműveleteket is tartalmaz, pl. System.exit(). A környezet beállítása

A program lefordításához és futtatásához először gondoskodnunk kell a környezet beállításáról.

Windows esetén indítsuk el a parancssort, például a Windows + R gombkombináció lenyomása után a cmd.exe elindításával. Ezt követően a PATH környezeti változót kell módosítanunk:

$ PATH=%PATH%;"C:\Program Files\Java\jdk1.8.0_77\bin" $ echo %PATH% ...;C:\Program Files\Java\jdk1.8.0_77\bin Ekkor a következőnek működnie kell:

$ javac -version javac 1.8.0_77 GNU/Linux vagy UNIX rendszereken is lényegében ugyanezt kell megcsinálni, de ennek konkrét szintaxisa az adott shelltől függ. Illetve jobb esetben a csomagkezelő erről gondoskodik a JDK telepítésekor.

Fordítás

A programokat a javac ("Java compiler") segítségével tudjuk lefordítani.

$ javac HelloWorld.java Amennyiben a program fordítási hibákat tartalmaz, úgy a fordító erről tájékoztat:

$ javac HelloWorldBad.java HelloWorldBad.java:1: error: class, interface, or enum expected public HelloWorldBad { ^ HelloWorldBad.java:2: error: class, interface, or enum expected public static void main(String[] args) { ^ HelloWorldBad.java:4: error: class, interface, or enum expected } ^ 3 errors ahol a hibás kód ez volt:

public HelloWorldBad { public static void main(String[] args) { return 0; } } Futtatás

A sikeres fordítás eredményétől függően nulla vagy több .class kiterjesztésű (byte-kódot tartalmazó) állomány keletkezik. Ezeket az állományokat lehet futtatni a Java virtuális gép (Virtual Machine, VM), azaz a java segítségével.

$ java HelloWorld Hello World! Megjegyzés: A java csak olyan .class állományt tud futtatni, amelynek van publikus statikus main() metódusa (ld. a fenti példaprogramot)!

Egy olyan program, ahol nincs main() metódus:

public class HelloWorldWrong {} Lefordul hiba nélkül:

$ javac HelloWorldWrong.java Azonban nem fog tudni futni:

$ java HelloWorldWrong Error: Main method not found in class HelloWorldWrong, please define the main method as: public static void main(String[] args) Dokumentáció generálása

A forráskódból, a megjegyzések segítségével a programhoz tartozó (API) dokumentáció készíthető a javadoc felhasználásával. Ehhez a programban speciális formátumú megjegyzéseket kell írni.

$ javadoc HelloWorld.java Loading source file HelloWorld.java... Constructing Javadoc information... Standard Doclet version 1.8.0_77 Building tree for all the packages and classes... Generating /HelloWorld.html... Generating /package-frame.html... Generating /package-summary.html... Generating /package-tree.html... Generating /constant-values.html... Building index for all the packages and classes... Generating /overview-tree.html... Generating /index-all.html... Generating /deprecated-list.html... Building index for all classes... Generating /allclasses-frame.html... Generating /allclasses-noframe.html... Generating /index.html... Generating /help-doc.html...
