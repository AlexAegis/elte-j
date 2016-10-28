
# A csoport

# Általános tudnivalók

Ebben az ismertetésben az osztályok, valamint a minimálisan szükséges metódusok leírásai fognak szerepelni. A feladatmegoldás során fontos betartani az elnevezésekre és típusokra vonatkozó megszorításokat, illetve a szövegek formázási szabályait.

Segédfüggvények létrehozhatóak, a feladatban nem megkötött adattagok és elnevezéseik is a feladat megoldójára vannak bízva. Törekedjünk arra, hogy az osztályok belső reprezentációját a _lehető legjobban védjük_, tehát csak akkor engedjünk, és csak olyan hozzáférést, amelyre a feladat felszólít, vagy amit azt osztályt használó kódrészlet megkíván!

A beadott megoldásodnak működnie kell a mellékelt tesztprogramokkal, de ez nem elégséges feltétele az elfogadásnak. A megírt forráskód legyen kellően általános és újrafelhasználható!

Használható segédanyagok: [Java dokumentáció](/files/java/api/index.html), legfeljebb egy üres lap és toll. Ha bármilyen kérdés, észrevétel felmerül, azt a felügyelőknek kell jelezni, _NEM_ a diáktársaknak!

_Figyelem!_ Az a metódus, mely fordítási hibát tartalmaz, automatikusan _nulla_ pontot ért!

# Tesztelés

Az egyes részfeladatokhoz tartoznak külön tesztesetek, amelyeket a feladatok végén jelöltük meg. Ezek önállóan is fordítható és futtatható `.java` állományok a mellékelt `.jar` segítségével. Például Windows alatt az első feladathoz tartozó tesztesetek így fordíthatóak és futtathatóak:

    > javac -cp .;Railway-tests.jar tests/Part1.java
    > java -cp .;Railway-tests.jar tests/Part1

Ugyanezeket a teszteseteket használja a komplett feladathoz tartozó tesztelést végző `Test` osztály is. Ezt Windows alatt így lehet futtatni:

    > java -cp .;Railway-tests.jar Test

Linux alatt mindent ugyanúgy lehet fordítani és futtatni, csak a `-cp` paraméterében a pontosvesszőt kell kettőspontra cserélni.

# A feladat összefoglaló leírása

A feladatban egy ország vasúthálózatát fogjuk ábrázolni.

A programhoz tartozik egy [egységtesztelő](/files/java/Railway-tests.zip), benne egy `railway.txt` mintafájl, amely az egyes osztályok funkcionalitását teszteli.

# A feladat részletes ismertetése

A feladatban a `rail.Railway` és `rail.RailMap` osztályokat fogjuk több lépésben megvalósítani.

Legyen minden nyilvános, kivéve ott, ahol a feladat mást határoz meg.

A városokat `String`-ként, a távolságot `int`-ként ábrázoljuk.

## 1\. rész (5 + 1 pont)

Készítsük el a `rail.Railway` osztályt. Szerepeljenek benne az alábbi rejtett adattagok.

*   Két `String` városnév (továbbiakban röviden csak város) és egy `int` távolság.

Valósítsuk meg továbbá az alábbi nyilvános metódusokat.

*   Egy konstruktor, mely paraméterül vár két várost és egy távolságot, ezekkel inicializálja az adattagokat.

*   Egy paraméter nélküli `getCities()`, mely egy (kételemű) tömbben adja vissza a két várost. A sorrend tetszőleges.

*   Egy paraméter nélküli `getDistance()`, mely visszaadja a távolságot.

Tesztelő: `tests.Part1`

## 2\. rész (5 + 1 pont)

A `rail.Railway` osztályba vegyük fel az alábbi nyilvános konstanst és metódusokat.

*   Egy osztályszintű, `Railway` típusú konstanst `KESZTHELY_BUDAPEST` névvel. A két város legyen Keszthely és Budapest, a távolság 190.

*   Egy osztályszintű `make()` metódust, mely egy `String`-et vár, és egy `Railway`-t ad vissza. A helyes paraméter két város és egy távolság szóközzel, például: `Budapest Eger 140`. A `make()` vizsgálja meg, hogy megvan-e mindhárom rész, a két városnév nem üres szöveg, és a harmadik rész valóban egy szám.

    Azt, hogy egy szöveg egy egész számot tartalmaz kétféleképpen is ellenőrizhetjük.

    1.  Elkapjuk az [`Integer.parseInt()`](https://bead.inf.elte.hu/files/java/api/java/lang/Integer.html#parseInt-java.lang.String-) által sikertelen számmá konvertáláskor dobott [`java.lang.NumberFormatException`](https://bead.inf.elte.hu/files/java/api/java/lang/NumberFormatException.html) kivételt.

    2.  Megvizsgáljuk a szöveget, hogy minden karaktere számjegy-e vagy sem a `Character.isDigit()` metódussal.

*   Egy objektumszintű `hasEnd()` metódust, mely egy várost vár és egy logikai értéket ad vissza. Ha a paraméter város megegyezik valamelyik valamelyik város adattaggal, akkor igazat ad a metódus, különben hamisat.

*   Egy objektumszintű `getOtherCity()` metódust, mely paraméterül is vár egy várost és vissza is ad egy várost. Ha a paraméter megegyezik a két város adattag közül valamelyikkel, akkor a másikat adja vissza a metódus. Ha a paraméter egyik adattaggal sem egyezik, akkor az eredmény `null`.

    Például Keszthely-Budapest viszonylatban a `getOtherCity("Budapest")` eredménye `"Keszthely"`, míg a `getOtherCity("Debrecen")` eredménye `null`.

Tesztelő: `tests.Part2`

## 3\. rész (5 + 1 pont)

Valósítsuk meg a `rail.RailMap` osztályt is, mely egy ország vasúthálózatát ábrázolja. Legyenek benne az alábbi rejtett adattagok.

*   Egy `String` országnév és egy `Railway` objektumokat tároló láncolt lista.

Továbbá legyenek az osztályban az alábbi nyilvános metódusok.

*   Egy konstruktor, mely paraméterül vár egy `String` országnevet és egy `String` fájlnevet. A konstruktor inicializálja az adattagokat és beolvassa a fájlból a vasútvonalakat a listába. Ügyeljünk, hogy ne kerüljön `null` a listába.

    A fájlkezelésből származó kivételeket nem kell lekezelni, elég, ha a metódus fejlécében specifikáljuk, hogy dobhatunk `java.io.IOException`-t.

*   Egy paraméter nélküli `getCities()` metódust, egy `String`-ekből álló láncolt listában adja vissza az összes várost. Ügyeljünk, hogy minden város csak egyszer szerepeljen a listában.

Tesztelő: `tests.Part3`

## 4\. rész (5 + 1 pont)

*   Bővítsük ki a `rail.Railway` osztályt egy nyilvános `toString()` metódussal. Példaként a Keszthely-Budapest viszonylatban az alábbi szöveget adja vissza: `Railway(Keszthely - Budapest 190)`.

*   Bővítsük ki a `rail.RailMap` osztályt egy nyilvános `toString()` metódussal, mely a fentihez hasonlóan az országnevet és a vasútvonalakat adja vissza. Például `RailMap(Magyarorszag,[Railway(Keszthely - Budapest 190), Railway(Budapest - Salakszentmotoros 40)])`.

*   Bővítsük ki a `rail.RailMap` osztályt egy nyilvános `getNeighbours()` metódussal, mely egy várost vár paraméterül, és ennek városnak a szomszédos városait adja vissza egy láncolt listában.

Tesztelő: `tests.Part4`

## 5\. rész (5 + 1 pont)

*   Bővítsük ki a `rail.RailMap` osztályt egy paraméter nélküli, `String` visszatérési típusú `getCapitalCity()` metódussal, mely visszaadja azt a várost, melynek legtöbb szomszédja van.

Tesztelő: `tests.Part5`

## Pontozás (elmélet + gyakorlat)

*   0 -- 20: elégtelen (1)
*   21 -- 25: elégséges (2)
*   26 -- 30: közepes (3)
*   31 -- 35: jó (4)
*   36 -- 40: jeles (5)