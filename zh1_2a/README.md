# A csoport

# Általános tudnivalók

Ebben az ismertetésben az osztályok, valamint a minimálisan szükséges metódusok leírásai fognak szerepelni. A feladatmegoldás során fontos betartani az elnevezésekre és típusokra vonatkozó megszorításokat, illetve a szövegek formázási szabályait.

Segédfüggvények létrehozhatóak, a feladatban nem megkötött adattagok és elnevezéseik is a feladat megoldójára vannak bízva. Törekedjünk arra, hogy az osztályok belső reprezentációját a _lehető legjobban védjük_, tehát csak akkor engedjünk, és csak olyan hozzáférést, amelyre a feladat felszólít, vagy amit azt osztályt használó kódrészlet megkíván!

A beadott megoldásodnak működnie kell a mellékelt tesztprogramokkal, de ez nem elégséges feltétele az elfogadásnak. A megírt forráskód legyen kellően általános és újrafelhasználható!

Használható segédanyagok: [Java dokumentáció](/files/java/api/index.html), legfeljebb egy üres lap és toll. Ha bármilyen kérdés, észrevétel felmerül, azt a felügyelőknek kell jelezni, _NEM_ a diáktársaknak!

_Figyelem!_ Az a metódus, mely fordítási hibát tartalmaz, automatikusan _nulla_ pontot ér!

# Tesztelés

Az egyes részfeladatokhoz tartoznak külön tesztesetek, amelyeket a feladatok végén jelöltük meg. Ezek önállóan is fordítható és futtatható `.java` állományok a mellékelt `.jar` segítségével. Például Windows alatt az első feladathoz tartozó tesztesetek így fordíthatóak és futtathatóak:

    > javac -cp .;Company-tests.jar tests/Part1.java
    > java -cp .;Company-tests.jar tests/Part1

Ugyanezeket a teszteseteket használja a komplett feladathoz tartozó tesztelést végző `Test` osztály is. Ezt Windows alatt így lehet futtatni:

    > java -cp .;Company-tests.jar Test

Linux alatt mindent ugyanúgy lehet fordítani és futtatni, csak a `-cp` paraméterében a pontosvesszőt kell kettőspontra cserélni.

# A feladat összefoglaló leírása

A feladatban egy céget fogunk ábrázolni.

A programhoz tartozik [egységtesztelő](/files/java/Company-tests.zip), benne egy `company.txt` mintafájl, amely az egyes osztályok funkcionalitását teszteli.

# A feladat részletes ismertetése

A feladatban a `company.Contract` és `company.Company` osztályokat fogjuk több lépésben megvalósítani. Az előbbi egy munkaszerződést munkavállaló és munkáltató között megadott fizetéssel, a második egy céget fog ábrázolni.

Legyen minden nyilvános, kivéve ott, ahol a feladat mást határoz meg.

A dolgozókat `String`-ként, a fizetést `int`-ként ábrázoljuk.

## 1\. rész (5 + 1 pont)

Készítsük el a `company.Contract` osztályt. Szerepeljenek benne az alábbi rejtett adattagok.

*   Két `String` személynév (munkavállaló és munkáltató) és egy `int` fizetés.

Valósítsuk meg továbbá az alábbi nyilvános metódusokat.

*   Egy konstruktor, mely paraméterül várja a munkavállaló nevét, munkáltató nevét és a fizetést, ezekkel inicializálja az adattagokat.

*   Egy paraméter nélküli `getWage()`, mely visszaadja a fizetést.

*   Egy paraméter nélküli `getEmployee()`, mely visszaadja a munkavállaló nevét.

*   Egy paraméter nélküli `getEmployer()`, mely visszaadja a munkáltató nevét.

Tesztelő: `tests.Part1`

## 2\. rész (5 + 1 pont)

A `company.Contract` osztályba vegyük fel az alábbi nyilvános konstanst és metódusokat.

*   Egy osztályszintű, `Contract` típusú konstanst `VADER` névvel. A munkavállaló legyen `Vader`, a munkáltató `Emperor`, a fizetés
*   Egy osztályszintű `make()` metódust, mely egy `String`-et vár, és egy `Contract`-ot ad vissza. A helyes paraméter két név és egy fizetés vesszővel elválasztva, például: `Gomboc Artur,Picur,200`. A `make()` vizsgálja meg az alábbiakat.

    1.  Megvan-e mindhárom rész.

    2.  Két személynév nem üres szöveg.

    3.  A harmadik rész valóban egy szám.

    4.  A fizetés nem lehet negatív.

    Ha valamelyik nem teljesül, akkor adjon vissza `null` referenciát.

    Azt, hogy egy szöveg egy egész számot tartalmaz kétféleképpen is ellenőrizhetjük.

    1.  Elkapjuk az [`Integer.parseInt()`](https://bead.inf.elte.hu/files/java/api/java/lang/Integer.html#parseInt-java.lang.String-) által sikertelen számmá konvertáláskor dobott [`java.lang.NumberFormatException`](https://bead.inf.elte.hu/files/java/api/java/lang/NumberFormatException.html) kivételt.

    2.  Megvizsgáljuk a szöveget, hogy minden karaktere számjegy-e vagy sem a [`Character.isDigit()`](https://bead.inf.elte.hu/files/java/api/java/lang/Character.html#isDigit-char-) metódussal.

*   Egy objektumszintű `hasEmployer()`, mely egy `String`-et vár paraméterül és logikai értéket ad vissza. Az eredmény igaz lesz, ha a paraméter megegyezik a munkáltató adattaggal, különben hamis.

*   Egy objektumszintű `toString()`, mely visszaadja a szerződést szöveges ábrázolásban. Például: `Contract(Gomboc Artur,Picur,200)`, ha a munkavállaló `Gomboc Artur`, a munkáltató `Picur` és a fizetés 200.

Tesztelő: `tests.Part2`

## 3\. rész (5 + 1 pont)

Valósítsuk meg a `company.Company` osztályt is, mely egy céget ábrázol. Legyenek benne az alábbi két rejtett adattag.

*   Egy `String` típusú név, és a szerződések, mely egy `Contract` objektumokat tároló [`java.util.LinkedList`](https://bead.inf.elte.hu/files/java/api/java/util/LinkedList.html).

Továbbá legyenek az osztályban az alábbi nyilvános metódusok.

*   Egy konstruktor, mely paraméterül vár egy `String` cégnevet és egy `String` fájlnevet. A konstruktor inicializálja az adattagokat és beolvassa a fájlból a szerződéseket a listába. Ügyeljünk, hogy ne kerüljön `null` a listába.

    A fájlkezelésből származó kivételeket nem kell lekezelni, elég, ha a metódus fejlécében specifikáljuk, hogy dobhatunk `java.io.IOException`-t.

*   Egy `employeesOf()` metódus, mely paraméterül vár egy `String` munkáltatót, és visszaadja a közvetlen beosztottjainak nevét egy `String`-ekből álló [`java.util.LinkedList`](https://bead.inf.elte.hu/files/java/api/java/util/LinkedList.html) objektumban.

    Tehát azokból a szerződésekből kell kigyűjteni a munkavállalót, ahol a munkáltató a paraméterrel egyezik.

    Az ismétlésekre nem kell odafigyelni, feltesszük, hogy nem fordulhat elő.

Tesztelő: `tests.Part3`

## 4\. rész (5 + 1 pont)

Bővítsük ki a `company.Company` osztályt az alábbi két nyilvános metódussal.

*   Egy nyilvános `toString()` metódussal, mely visszaadja a cég szöveges ábrázolását. Az eredmény például `Company(Aperture Science,[Contract(Abigail,Jackie,12),Contract(Bob,Jackie,15)])`, ha cég neve `Aperture Science` és `Jackie`-nek két besztottja van.

*   Egy paraméter nélküli `employees()` metódussal, mely visszaadja a cég összes dolgozójának (munkavállaló vagy munkáltató) a nevét egy `String`-eket tartalmazó [`java.util.LinkedList`](https://bead.inf.elte.hu/files/java/api/java/util/LinkedList.html) objektumban.

    Figyeljünk, hogy elkerüljük az ismétlést. Egy dolgozó több beosztottnak is lehet munkáltatója. A sorrend tetszőleges.

Tesztelő: `tests.Part4`

## 5\. rész (5 + 1 pont)

Bővítsük ki a `company.Company` osztályt az alábbi két nyilvános metódussal.

*   Egy paraméter nélküli `bosses()` metódussal, mely `String`-eket tartalmazó [`java.util.LinkedList`](https://bead.inf.elte.hu/files/java/api/java/util/LinkedList.html) objektumban adja vissza a cég összes munkáltatójának a nevét.

    Figyeljünk, hogy elkerüljük az ismétlést. Egy dolgozó több beosztottnak is lehet munkáltatója. A sorrend tetszőleges.

*   Egy paraméter nélküli `bestBoss()` metódussal, mely egyetlen `String`-et, a legtöbb közvetlen beosztottal rendelkező főnök nevét adja vissza.

Tesztelő: `tests.Part5`

## Pontozás (elmélet + gyakorlat)

*   0 -- 20: elégtelen (1)
*   21 -- 25: elégséges (2)
*   26 -- 30: közepes (3)
*   31 -- 35: jó (4)
*   36 -- 40: jeles (5)

</div>