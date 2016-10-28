# B csoport

# Általános tudnivalók

Ebben az ismertetésben az osztályok, valamint a minimálisan szükséges metódusok leírásai fognak szerepelni. A feladatmegoldás során fontos betartani az elnevezésekre és típusokra vonatkozó megszorításokat, illetve a szövegek formázási szabályait.

Segédfüggvények létrehozhatóak, a feladatban nem megkötött adattagok és elnevezéseik is a feladat megoldójára vannak bízva. Törekedjünk arra, hogy az osztályok belső reprezentációját a _lehető legjobban védjük_, tehát csak akkor engedjünk, és csak olyan hozzáférést, amelyre a feladat felszólít, vagy amit azt osztályt használó kódrészlet megkíván!

A beadott megoldásodnak működnie kell a mellékelt tesztprogramokkal, de ez nem elégséges feltétele az elfogadásnak. A megírt forráskód legyen kellően általános és újrafelhasználható!

Használható segédanyagok: [Java dokumentáció](/files/java/api/index.html), legfeljebb egy üres lap és toll. Ha bármilyen kérdés, észrevétel felmerül, azt a felügyelőknek kell jelezni, _NEM_ a diáktársaknak!

_Figyelem!_ Az a metódus, mely fordítási hibát tartalmaz, automatikusan _nulla_ pontot ér!

# Tesztelés

Az egyes részfeladatokhoz tartoznak külön tesztesetek, amelyeket a feladatok végén jelöltük meg. Ezek önállóan is fordítható és futtatható `.java` állományok a mellékelt `.jar` segítségével. Például Windows alatt az első feladathoz tartozó tesztesetek így fordíthatóak és futtathatóak:

    > javac -cp .;WeightLifter-tests.jar tests/Part1.java
    > java -cp .;WeightLifter-tests.jar tests/Part1

Ugyanezeket a teszteseteket használja a komplett feladathoz tartozó tesztelést végző `Test` osztály is. Ezt Windows alatt így lehet futtatni:

    > java -cp .;WeightLifter-tests.jar Test

Linux alatt mindent ugyanúgy lehet fordítani és futtatni, csak a `-cp` paraméterében a pontosvesszőt kell kettőspontra cserélni.

# A feladat összefoglaló leírása

A feladatban súlyemelők közötti versenyt fogunk szimulálni.

A programhoz tartozik [egységtesztelő](/files/java/WeightLifter-tests.zip), benne egy `weightlifters.txt` mintafájl, amely az egyes osztályok funkcionalitását teszteli.

# A feladat részletes ismertetése

## 1\. rész (6 + 1 pont)

`weightlifting.WeightLifter` osztály:

Az osztály egy súlyemelőt reprezentál.

*   Az osztálynak két rejtett adattagja van: egy szöveges típusú `name`, amely a súlyemelő nevét tárolja és egy egész szám típusú `weight`, ami azt tárolja, hogy mekkora az a maximális súly, amit a súlyemelő fel tud emelni.

*   Az osztálynak legyen egy rejtett konstruktora, amely paraméterben megkapja a nevet és a súlyt, és beállítja a megfelelő adattagokat.

*   Legyen egy statikus `make` metódus, amely szintén egy nevet és egy súlyt kap. A metódusnak ellenőriznie kell a paramétereket, és amennyiben azok megfelelőek, akkor hozza létre, és adja vissza a paramétereknek megfelelő `WeightLifter` objektumot. Ha a paraméterek nem jók, akkor a metódus `null`-t adjon vissza. A nevet tartalmazó paraméter akkor megfelelő, ha csak betűkből vagy szóközből áll és legalább 2 karakter hosszú (azt, hogy ezek a karakterek milyen eloszlásban szerepelnek, nem kell vizsgálni). A súlyt tartalmazó paraméter pedig akkor helyes, ha az értéke pozitív, de legfeljebb 300\. _Segítség_: használhatod a `Character` osztály `isLetter` metódusát.

*   Legyen egy paraméter nélküli `getWeight`, ami visszaadja a súly értékét.

*   Az osztály tartalmazzon egy `strongerThan` metódust, ami eldönti, hogy az aktuális súlyemelő erősebb-e (nagyobb súlyt tud-e felemelni), mint a paraméterben kapott súlyemelő.

*   Az osztályban legyen egy paraméter nélküli `show` metódus, amely visszaadja az objektum szöveges reprezentációját. A formátum legye a következő: `név - súly-jobbra-igazítva kg` (ha a súly egyszámjegyű, akkor kettő, ha kétszámjegyű, akkor egy _extra_ szóközt kell beszúrni a szám elé).

*   Az osztály tartalmazzon egy `strongestWeightLifter` nevű osztályszintű adattagot, ami a legerősebb súlyemelő referenciáját tartalmazza, amit valaha létrehoztak (ha több ilyen van, akkor ezek közül az elsőt). Ha még nem hoztak létre `WeightLifter` objektumot, akkor az adattag értéke legyen `null`. Figyelj rá, hogy a konstruktor mindig aktualizálja ezt az objektumot, amikor az összes eddiginél erősebb súlyemelőt hoz létre.

*   Legyen egy osztályszintű `getStrongestWeightLifter` metódus, ami visszaadja az előbbi `WeightLifter` objektumot.

Tesztelő: `tests.Part1`

## 2\. rész (7 + 2 pont)

`weightlifting.Championship` osztály:

Az osztály egy egyszerűsített súlyemelő bajnokságot reprezentál.

*   Az osztály egy rejtett láncolt lista típusú adattagban tartsa nyilván, hogy kik indulnak a bajnokságon (`WeightLifter` típusú objektumok).

*   Az osztálynak egy publikus konstruktora legyen, ami egy fájlnevet kap paraméterként, amely súlyemelőket tartalmaz. A metódus dolgozza fel a fájlt, szűrje ki belőle a hibás adatokat, majd töltse fel a súlyemelőket a láncolt listába. Ha a fájl nem létezik, vagy nem olvasható, akkor a súlyemelők listája legyen üres, a konstruktor pedig ne engedje ki a keletkező kivételt. Az inputfájl minden sora egy súlyemelőt tartalmaz `név:súly` formában. Ha a sor nem ilyen szerkezetű, vagy a `súly` nem konvertálható számmá, vagy a megadott adatokból a `WeightLifter` objektum nem hozható létre, akkor a sort figyelmen kívül kell hagyni és a feldolgozást a következő sorral kell folytatni.

    Azt, hogy egy szöveg egy egész számot tartalmaz kétféleképpen is ellenőrizhetjük.

    1.  Elkapjuk az [`Integer.parseInt()`](https://bead.inf.elte.hu/files/java/api/java/lang/Integer.html#parseInt-java.lang.String-) által sikertelen számmá konvertáláskor dobott [`java.lang.NumberFormatException`](https://bead.inf.elte.hu/files/java/api/java/lang/NumberFormatException.html) kivételt.

    2.  Megvizsgáljuk a szöveget, hogy minden karaktere számjegy-e vagy sem a `Character.isDigit()` metódussal.

*   Legyen egy `numberOfWeightLifters` metódus, amely visszaadja a bajnokságon még versenyben lévő súlyemelők számát. Kezdetben az összes súlyemelő versenyben van.

*   Legyen egy paraméter nélküli `show` metódus, ami szöveges típusban visszaadja a még játékban lévő versenyzőket. A szöveg összeállításakor a versenyzők olyan sorrendben szerepeljenek, amilyen sorrendben a konstruktor beolvasta őket, és olyan formában, ahogy a `WeightLifter` `show` metódusa előállítja. Figyeljünk rá, hogy az utolsó versenyző után már ne legyen sortörés!

Tesztelő: `tests.Part2`

# 3\. rész (6 + 1 pont)

A `weightlifting.Championship` osztályba vegyük fel az alábbi publikus metódusokat:

*   `strongerThan`: a metódus egy `WeightLifter` típusú objektumot vár, és ilyen objektumok láncolt listáját adja vissza. A metódus gyűjtse össze azokat a versenyzőket, akik erősebbek, mint a paraméterben kapott súlyemelő. A súlyemelők a visszaadott listában olyan sorrendben szerepeljenek, ahogy a konstruktor beolvasta őket.

*   `average`: a metódus egy valós számot (`double`) adjon vissza, azt, hogy a súlyemelők átlagosan mekkora súlyt képesek felemelni. Ha nincsenek súlyemelők, akkor a metódus adjon vissza `-1`-et.

    Figyelem: ha két egész számot osztunk egymással, akkor az eredmény mindig egész lesz (lefelé kerekít).

Tesztelő: `tests.Part3`

# 4\. rész (6 + 1 pont)

A `weightlifting.Championship` osztályba vegyük fel az alábbi publikus metódusokat:

*   `round`: a metódusnak nincsen paramétere, és a verseny egy körét szimulálja. A versenyben minden körben kiesik a leggyengébb súlyemelő. Ha a leggyengébb játékossal azonos erősségű is van, akkor az esik ki, akit a konstruktor korábban olvasott be. A kieső súlyemelőt el kell távolítani a listából, és ez a súlyemelő lesz a metódus visszatérési értéke is. Ha a kör elején egyetlen súlyemelő sem volt játékban, akkor a metódus `null`-t adjon vissza.

*   `championship`: a metódusnak nincs paramétere és egy bajnokságot szimulál. A bajnokságban annyi körből áll, ahány súlyemelő van. A metódus egy súlyemelőket tartalmazó láncolt listába gyűjtse össze, hogy a versenyzők az egyes körökben milyen sorrendben estek ki. Ez a lista lesz a metódus visszatérési értéke.

Tesztelő: `tests.Part4`

## Pontozás (elmélet + gyakorlat)

*   0 -- 20: elégtelen (1)
*   21 -- 25: elégséges (2)
*   26 -- 30: közepes (3)
*   31 -- 35: jó (4)
*   36 -- 40: jeles (5)

</div>