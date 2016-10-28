# B csoport

# Általános tudnivalók

Ebben az ismertetésben az osztályok, valamint a minimálisan szükséges metódusok leírásai fognak szerepelni. A feladatmegoldás során fontos betartani az elnevezésekre és típusokra vonatkozó megszorításokat, illetve a szövegek formázási szabályait.

Segédfüggvények létrehozhatóak, a feladatban nem megkötött adattagok és elnevezéseik is a feladat megoldójára vannak bízva. Törekedjünk arra, hogy az osztályok belső reprezentációját a _lehető legjobban védjük_, tehát csak akkor engedjünk, és csak olyan hozzáférést, amelyre a feladat felszólít, vagy amit azt osztályt használó kódrészlet megkíván!

A beadott megoldásodnak működnie kell a mellékelt tesztprogramokkal, de ez nem elégséges feltétele az elfogadásnak. A megírt forráskód legyen kellően általános és újrafelhasználható!

Használható segédanyagok: [Java dokumentáció](/files/java/api/index.html), legfeljebb egy üres lap és toll. Ha bármilyen kérdés, észrevétel felmerül, azt a felügyelőknek kell jelezni, _NEM_ a diáktársaknak!

_Figyelem!_ Az a metódus, mely fordítási hibát tartalmaz, automatikusan _nulla_ pontot ért!

# Tesztelés

Az egyes részfeladatokhoz tartoznak külön tesztesetek, amelyeket a feladatok végén jelöltük meg. Ezek önállóan is fordítható és futtatható `.java` állományok a mellékelt `.jar` segítségével. Például Windows alatt az első feladathoz tartozó tesztesetek így fordíthatóak és futtathatóak:

    > javac -cp .;Market-tests.jar tests/Part1.java
    > java -cp .;Market-tests.jar tests/Part1

Ugyanezeket a teszteseteket használja a komplett feladathoz tartozó tesztelést végző `Test` osztály is. Ezt Windows alatt így lehet futtatni:

    > java -cp .;Market-tests.jar Test

Linux alatt mindent ugyanúgy lehet fordítani és futtatni, csak a `-cp` paraméterében a pontosvesszőt kell kettőspontra cserélni.

# A feladat összefoglaló leírása

A feladatban egy piac nagyon leegyszerűsített működését fogjuk szimulálni.

A programhoz tartozik [egységtesztelő és egy mintafájl](/files/java/Market-tests.zip) amely az egyes osztályok funkcionalitását teszteli.

# A feladat részletes ismertetése

## 1\. rész (6 + 1 pont)

`market.Fruit` osztály:

Az osztály egy gyümölcsöt reprezentál.

*   Az osztálynak két rejtett adattagja van: egy szöveges típusú `name`, amely a gyümölcs nevét tárolja és egy egész szám típusú `price`, ami a gyümölcs árát tárolja.

*   Az osztálynak legyen egy rejtett konstruktora, amely paraméterben megkapja a nevet és az árat, és beállítja a megfelelő adattagokat.

*   Legyen egy statikus `make` metódus, amely szintén egy nevet és egy árat kap. A metódusnak ellenőriznie kell a paramétereket, és amennyiben azok megfelelőek, akkor hozza létre, és adja vissza a paramétereknek megfelelő `Fruit` objektumot. Ha a paraméterek nem jók, akkor a metódus `null`-t adjon vissza. A nevet tartalmazó paraméter akkor megfelelő, ha csak betűt tartalmaz és legalább 2 karakter hosszú. Az árat tartalmazó paraméter pedig akkor helyes, ha pozitív, de legfeljebb 5000 és 0-ra vagy 5-re végződik. _Segítség_: használhatod a `Character` osztály `isLetter` metódusát.

*   Legyen egy paraméter nélküli `getPrice`, ami visszaadja a gyümölcs árát.

*   Az osztály tartalmazzon egy `cheaperThan` metódust, ami eldönti, hogy az aktuális gyümölcs olcsóbb-e, mint a paraméterben kapott gyümölcs.

*   Az osztályban legyen egy paraméter nélküli `show` metódus, amely visszaadja az objektum szöveges reprezentációját. A formátum legye a következő: `név (ár-ezres-tagolással Ft)` (ha az ár 1000-nél nagyobb, akkor ezres tagolásként egy szóközt kell használni, pl. `3 065`).

*   Az osztály tartalmazzon egy `cheapestFruit` nevű osztályszintű adattagot, ami a legolcsóbb gyümölcsöt tartalmazza, amit valaha létrehoztak (ha több ilyen van, akkor ezek közül az elsőt). Ha még nem hoztak létre `Fruit` objektumot, akkor az adattag értéke legyen `null`. Figyelj rá, hogy a konstruktor mindig aktualizálja ezt az objektumot, amikor az összes eddiginél olcsóbb gyümölcsöt hoz létre.

*   Legyen egy osztályszintű `getCheapestFruit` metódus, ami visszaadja az előbbi `Fruit` objektumot.

Tesztelő: `tests.Part1`

## 2\. rész (7 + 2 pont)

`market.Market` osztály:

Az osztály egy egyszerűsített piacot reprezentál.

*   Az osztály egy rejtett láncolt lista típusú adattagban tartsa nyilván, hogy milyen gyümölcsöket lehet kapni a piacon (`Fruit` típusú objektumok).

*   Az osztálynak egy publikus konstruktora legyen, ami egy fájlnevet kap paraméterként, amely gyümölcsöket tartalmaz. A metódus dolgozza fel a fájlt, szűrje ki belőle a hibás adatokat, majd töltse fel a gyümölcsöket a láncolt listába. Ha a fájl nem létezik, vagy nem olvasható, akkor a gyümölcsök listája legyen üres, a konstruktor pedig ne engedje ki a keletkező kivételt. Az inputfájl minden sora egy gyümölcsöt tartalmaz `név,ár` formában. Ha a sor nem ilyen szerkezetű, vagy az `ár` nem konvertálható számmá, vagy a megadott adatokból a `Fruit` objektum nem hozható létre, akkor a sort figyelmen kívül kell hagyni és a feldolgozást a következő sorral kell folytatni.

    Azt, hogy egy szöveg egy egész számot tartalmaz kétféleképpen is ellenőrizhetjük.

    1.  Elkapjuk az [`Integer.parseInt()`](https://bead.inf.elte.hu/files/java/api/java/lang/Integer.html#parseInt-java.lang.String-) által sikertelen számmá konvertáláskor dobott [`java.lang.NumberFormatException`](https://bead.inf.elte.hu/files/java/api/java/lang/NumberFormatException.html) kivételt.

    2.  Megvizsgáljuk a szöveget, hogy minden karaktere számjegy-e vagy sem a `Character.isDigit()` metódussal.

*   Legyen egy `numberOfFruits` metódus, amely visszaadja a piacon még kapható gyümölcsök számát. Kezdetben az összes gyümölcs kapható.

*   Legyen egy paraméter nélküli `show` metódus, ami szöveges típusban visszaadja a még kapható gyümölcsöket. A szöveg összeállításakor a gyümölcsök olyan sorrendben szerepeljenek, amilyen sorrendben a konstruktor beolvasta őket, és olyan formában, ahogy a `Fruit` `show` metódusa előállítja. Figyeljünk rá, hogy az utolsó gyümölcs után már ne legyen sortörés!

Tesztelő: `tests.Part2`

# 3\. rész (6 + 1 pont)

A `market.Market` osztályba vegyük fel az alábbi publikus metódusokat:

*   `cheaperThan`: a metódus egy `Fruit` típusú objektumot vár, és ilyen objektumok láncolt listáját adja vissza. A metódus gyűjtse össze azokat a gyümölcsöket, amelyek olcsóbbak, mint a paraméterben kapott gyümölcs. A gyümölcsök a visszaadott listában olyan sorrendben szerepeljenek, ahogy a konstruktor beolvasta őket.

*   `average`: a metódus egy valós számot (`double`) adjon vissza, azt, hogy mennyi a gyümölcsök átlagos ára. Ha nincsenek gyümölcsök, akkor a metódus adjon vissza `-1`-et.

    Figyelem: ha két egész számot osztunk egymással, akkor az eredmény mindig egész lesz (lefelé kerekít).

Tesztelő: `tests.Part3`

# 4\. rész (6 + 1 pont)

A `market.Market` osztályba vegyük fel az alábbi publikus metódusokat:

*   `buyCheapestFruit`: a metódusnak nincsen paramétere, és egy vásárlást szimulál. Egy vásárló mindig a legolcsóbb terméket veszi meg. Ha a legolcsóbb gyümölccsel azonos árú is van, akkor azt, amelyiket a konstruktor korábban vett fel a listába. A megvásárolt gyümölcsöt el kell távolítani a listából, és ez a gyümölcs lesz a metódus visszatérési értéke is. Ha a vásárlás elején egyetlen gyümölcs sem volt már a piacon, akkor a metódus `null`-t adjon vissza.

*   `sale`: a metódusnak nincs paramétere és egy kiárusítást szimulál. A kiárusítás addig tart, amíg el nem fogy az összes gyümölcs. A metódus egy gyümölcsöket tartalmazó láncolt listába gyűjtse össze, hogy a gyümölcsöket milyen sorrendben vásárolták meg. Ez a lista lesz a metódus visszatérési értéke.

Tesztelő: `tests.Part4`

## Pontozás (elmélet + gyakorlat)

*   0 -- 20: elégtelen (1)
*   21 -- 25: elégséges (2)
*   26 -- 30: közepes (3)
*   31 -- 35: jó (4)
*   36 -- 40: jeles (5)

</div>