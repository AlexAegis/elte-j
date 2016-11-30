# A csoport

# Általános tudnivalók

Ebben az ismertetésben az osztályok, valamint a minimálisan szükséges metódusok leírásai fognak szerepelni. A feladatmegoldás során fontos betartani az elnevezésekre és a típusokra vonatkozó megszorításokat, illetve a szövegek formázási szabályait. Segédfüggvények is létrehozhatók, a feladatban nem megkötött adattagok és elnevezéseik is a feladat megoldójára vannak bízva. Törekedjünk arra, hogy az osztályok belső reprezentációját a lehető legjobban védjük, tehát csak akkor engedjünk meg, és csak olyan hozzáférést, amelyre a feladat felszólít, vagy amit az osztályt használó kódrészlet megkíván!

A beadott megoldásnak működnie kell a mellékelt tesztprogrammal, de ez nem elégséges feltétele az elfogadásnak. Törekedjünk arra, hogy a megírt forráskód kellően általános és újrafelhasználható legyen!

Használható segédanyagok: [Java dokumentáció](/files/java/api/), legfeljebb egy üres lap és toll. Ha bármilyen kérdés, észrevétel felmerül, azt a felügyelőknek kell jelezni, _NEM_ a diáktársaknak!

_Figyelem!_ Az a metódus, amely fordítási hibát tartalmaz, automatikusan _nulla_ pontot ér!

# Tesztelés

Az egyes részfeladatokhoz tartoznak külön tesztesetek, amelyeket a feladatok végén jelöltük meg. Ezek önállóan is fordítható és futtatható `.java` állományok a mellékelt `.jar` segítségével. Például Windows alatt az első feladathoz tartozó tesztesetek így fordíthatóak és futtathatóak:

    > javac -cp .;Rental-tests.jar tests/Part1.java
    > java -cp .;Rental-tests.jar tests/Part1

Ugyanezeket a teszteseteket használja a komplett feladathoz tartozó tesztelést végző `Test` osztály is. Ezt Windows alatt így lehet futtatni:

    > java -cp .;Rental-tests.jar Test

Linux alatt mindent ugyanúgy lehet fordítani és futtatni, csak a `-cp` paraméterében a pontosvesszőt kell kettőspontra cserélni.

# A feladat összefoglaló leírása

A feladatban egy autókölcsönző leegyszerűsített működését fogjuk szimulálni.

A programhoz tartozik [egységtesztelő](/files/java/Rental-tests.zip), amely az egyes osztályok funkcionalitását teszteli.

# A feladat részletes ismertetése

## 1\. rész (6 + 1 pont)

`rental.Car` osztály:

Az osztály egy autót reprezentál.

*   Az osztálynak három rejtett adattagja van: egy szöveges típusú `brand`, amely az autó márkáját, egy szöveges típusú `licensePlate`, amely az autó rendszámát és egy valós (`double`) típusú `price`, amely az autó kölcsönzési díját tárolja.

*   Az osztálynak legyen egy rejtett konstruktora, amely paraméterként megkapja a márkát, a rendszámtáblát és a kölcsönzési díjat, és beállítja a megfelelő adattagokat.

*   Az osztály rendelkezik továbbá két rejtett, konstans, osztályszintű adattaggal is. A valós típusú `MAX_PRICE` az autók maximális kölcsönzési díját tárolja, értéke 500.0\. A `Car` típusú `CAR_OF_THE_YEAR` az év autóját tárolja, a márkája `Alfa Romeo`, a rendszáma `ABC 123`, a kölcsönzési díja pedig megegyezik a maximális kölcsönzési díjjal.

*   Definiáljunk egy osztályszintű `make` nevű metódust is. A `make` metódus szintén a márkát, a rendszámtáblát és a kölcsönzési díjat kapja meg paraméterként. A metódus először ellenőrzi, hogy a paraméterek megfelelőek. Amennyiben igen, akkor létrehozza és visszaadja a paramétereknek megfelelő `Car` típusú objektumot. Ha a paraméterek nem megfelelőek, akkor a metódus `null`-t adjon vissza. A márkát tartalmazó paraméter akkor megfelelő, ha csak betűkből vagy szóközből áll és legalább 2 karakter hosszú (azt, hogy ezek a karakterek milyen eloszlásban szerepelnek, nem kell vizsgálni). A rendszámtábla akkor megfelelő, ha pontosan 7 karakter hosszú: 3 nagybetűből és 3 számjegyből áll, amelyeket egy szóköz választ el egymástól (annak eldöntésére, hogy a rendszámtábla megfelelő, vezessük be a `validLicensePlate` nevű metódust, l. később). A kölcsönzési díjat tartalmazó paraméter akkor helyes, ha pozitív és a maximális kölcsönzési díjat nem haladja meg (legfeljebb a maximális kölcsönzési díjjal lehet egyenlő).

    _Segítség_: a metódusban használható a `Character` osztály [`isLetter()`](https://bead.inf.elte.hu/files/java/api/java/lang/Character.html#isLetter-char-) metódusa.

*   Legyen a `validLicensePlate` nevű metódus rejtett, osztályszintű, amely eldönti, hogy a szöveges típusú paraméterként kapott rendszámtábla megfelelő-e vagy sem.

    _Segítség_: a metódusban használható a `Character` osztály [`isUpperCase()`](https://bead.inf.elte.hu/files/java/api/java/lang/Character.html#isUpperCase-char-) és [`isDigit()`](https://bead.inf.elte.hu/files/java/api/java/lang/Character.html#isDigit-char-) metódusa.

*   Definiáljunk az osztályban egy paraméter nélküli `getPrice` nevű metódust, amely visszaadja az autó kölcsönzési díját.

*   Az osztálynak van egy `decreasePrice` nevű metódusa, amely az aktuális autó kölcsönzési díját 10-zel csökkenti, ha az eredeti kölcsönzési díj 10-nél nagyobb, feltéve, hogy nem egyezik meg a maximális kölcsönzési díjjal.

*   Az osztály tartalmazzon egy `cheaperThan` nevű metódust, amely eldönti, hogy az aktuális autó kölcsönzési díja alacsonyabb-e a paraméterben kapott autó kölcsönzési díjánál.

*   Definiáljunk egy paraméter nélküli `toString` nevű metódust is, amely visszaadja az objektum szöveges reprezentációját. A formátum legyen a következő: `márka (rendszámtábla) ár EUR`, ahol az árat egy tizedesjegy pontossággal jelenítse meg és az egyes helyiértékek egymás alá kerüljenek. Pl. `Volvo (JSD 856) 500,0 EUR`, `BMW (ABC 123) 40,0 EUR`, `Alfa Romeo (DEF 234) 9,0 EUR`.

Tesztelő: `tests.Part1`

## 2\. rész (7 + 2 pont)

`rental.CarRental` osztály:

Az osztály egy egyszerűsített autókölcsönzőt reprezentál.

*   Az osztály egy rejtett tömbös lista ([`java.util.ArrayList`](https://bead.inf.elte.hu/files/java/api/java/util/ArrayList.html)) típusú adattagban tartsa nyilván, hogy milyen autókat lehet kölcsönözni (`Car` típusú objektumok).

*   Az osztálynak legyen egy publikus konstruktora, amely egy fájlnevet kap paraméterként. A fájl autókat tartalmaz. A metódus dolgozza fel a fájlt, szűrje ki belőle a hibás adatokat, majd tárolja el az autókat a listában. Ha a fájl nem létezik, vagy nem olvasható, akkor az autók listája legyen üres, a konstruktor pedig ne engedje ki a keletkező kivételt. Az inputfájl minden sora egy autót tartalmaz `márka:rendszám,kölcsönzési díj` formában. Ha a sor nem ilyen szerkezetű, vagy a kölcsönzési díj nem konvertálható számmá, vagy a megadott adatokból a `Car` objektum nem hozható létre, akkor a sort figyelmen kívül kell hagyni és a feldolgozást a következő sorral kell folytatni.

    _Segítség_: Az, hogy egy szöveg egy valós számot tartalmaz, ellenőrizhető úgy, hogy elkapjuk a [`Double.parseDouble()`](https://bead.inf.elte.hu/files/java/api/java/lang/Double.html#parseDouble-java.lang.String-) által számmá történő konvertáláskor dobott [`java.lang.NumberFormatException`](https://bead.inf.elte.hu/files/java/api/java/lang/NumberFormatException.html) kivételt.

*   Definiáljunk egy `numberOfCars` nevű metódust, amely visszaadja a kölcsönzőből kölcsönözhető autók számát.

*   Definiáljunk egy paraméter nélküli `toString` nevű metódust is, amely visszaadja az autókölcsönző szöveges reprezentációját (a még kölcsönözhető autókat). A szöveg összeállításakor az autók olyan sorrendben szerepeljenek, amilyen sorrendben a konstruktor beolvasta, és olyan formában, ahogyan a `Car` `toString` nevű metódusa előállítja őket. Figyeljünk arra, hogy az utolsó autó után már ne legyen sortörés!

Tesztelő: `tests.Part2`

# 3\. rész (6 + 1 pont)

A `rental.CarRental` osztályban definiáljuk az alábbi publikus metódusokat:

*   `insertionSort`: a metódus a kölcsönözhető autók listáját beszúró rendezéssel a kölcsönzési díjuk szerint növekvő sorrendbe rendezi. Tehát a lista elején az az autó áll, amelynek a kölcsönzési díja a legkisebb, a végén pedig az, amelynek a legnagyobb.

    _Segítség_: A beszúró rendezés a következőképpen működik: feltesszük, hogy az egy elemből álló lista eleve rendezett. Minden menetben, minden egyes elemére a listának az 1-es indexűtől kezdve, egészen a lista legutolsó eleméig, ellenőrizzük, hogy az aktuális elem hogyan viszonyul a már rendezett részlistában lévő elemekhez. Az aktuális elemnél nagyobb elemeket jobbra toljuk. Ha egy kisebb elem következik, vagy pedig a lista végére érünk, az adott elemet beszúrhatjuk.

*   `weightedAverage`: a metódus az autók árainak súlyozott átlagát számolja ki, egy valós számot ad vissza eredményként. A súlyozott ár kiszámítása a következőképpen történjen (ha vannak autók): egy autó árát szorozzuk azzal a számmal (súllyal), ahányadik az autó a listában (pl. a 0-dik indexű autó súlya 1 lesz), majd ezen szorzatokat összeadjuk. Az így kapott összeget elosztjuk a súlyok összegével. Ha nincsenek autók, akkor a metódus -1-et adjon vissza.

Tesztelő: `tests.Part3`

# 4\. rész (6 + 1 pont)

A `rental.CarRental` osztályban definiáljuk az alábbi publikus metódusokat:

*   `rentCheapest`: a metódusnak nincsen paramétere és egy autó kölcsönzését szimulálja. Az ügyfél mindig a legalacsonyabb árú autót kölcsönzi. A megvalósításhoz használjuk a korábban megírt beszúró rendezést, amely az autókat kölcsönzési díjuk szerint növekvő sorrendbe rendezi. A kölcsönözni kívánt autót el kell távolítani a listából, ez lesz a metódus visszatérési értéke. Ha a kölcsönzés elején egyetlen autó sincs a kölcsönzőben, akkor a metódus `null`-t adjon vissza.

*   `sale`: a metódusnak nincs paramétere és az autók kölcsönzési díjának véletlenszerű csökkentését szimulálja (a kölcsönzési díjat véletlenszerűen vagy csökkentjük, vagy nem csökkentjük). Az aktualizált kölcsönzési díjú autókat egy listába gyűjtsük össze, ez lesz a metódus visszatérési értéke.

    _Segítség_: használható a [`java.util.Random`](https://bead.inf.elte.hu/files/java/api/java/util/Random.html) osztály véletlen adat generálására.

*   `simulate`: a metódusnak nincs paramétere és a kölcsönzést szimulálja (az összes autó kölcsönzését az autókölcsönző működése során). A kölcsönzés megkezdése előtt az autók kölcsönzési díját aktualizáljuk (l. a `sale` metódust). A kölcsönzés addig tart, amíg el nem fogy az összes kölcsönözhető autó. A metódus az autókat egy tömbös listába gyűjtse össze, olyan sorrendben, ahogy az autókat kölcsönözték. Ez a lista lesz a metódus visszatérési értéke.

Tesztelő: `tests.Part4`

## Pontozás (elmélet + gyakorlat)

*   0 -- 20: elégtelen (1)
*   21 -- 25: elégséges (2)
*   26 -- 30: közepes (3)
*   31 -- 35: jó (4)
*   36 -- 40: jeles (5)