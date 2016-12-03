# A feladat összefoglaló leírása

Ebben a feladatban egy órarendkészítő programot és annak részeit fogjuk elkészíteni. Az órarend készítése során óráknak fogunk megfelelő típusú és méretű üres termet keresni.

_A részfeladatok megoldása során ügyeljünk arra, hogy a megadottakon kívül egyetlen osztály se tartalmazzon más publikus metódust vagy adattagot, illetve egyik csomag se tartalmazzon más osztályokat! A megoldást egyetlen `.zip` állományként kell feltölteni, amely tartalmazza a csomagnak megfelelő könyvtárszerkezetben az összes forráskódot. A fordítás során keletkező `.class` állományokat viszont már nem szabad mellékelni! A fordításhoz legalább a Java Standard Edition 8 használata kötelező._

A feladathoz tartozik egy [letölthető segédlet](https://bead.inf.elte.hu/files/java/TimeTable.zip), ahol megtaláljuk a feladat leírásában hivatkozott összes állományt.

# Tesztelés

Az egyes részfeladatokhoz tartoznak külön tesztesetek, amelyeket a feladatok végén jelöltük meg. Ezek önállóan is fordítható és futtatható `.java` állományok a mellékelt `.jar` segítségével. Például Windows alatt az első feladathoz tartozó tesztesetek így fordíthatóak és futtathatóak:

    > javac -cp .;tests-TimeTable.jar tests/DayTest.java
    > java -cp .;tests-TimeTable.jar tests/DayTest

Ugyanezeket a teszteseteket használja a komplett feladathoz tartozó tesztelést végző `Test` osztály is. Ezt Windows alatt így lehet futtatni:

    > java -cp .;tests-TimeTable.jar Test

Linux alatt mindent ugyanúgy lehet fordítani és futtatni, csak a `-cp` paraméterében a pontosvesszőt kell kettőspontra cserélni.

# A feladat részletes ismertetése

## `interval.time.Day`

Hozzuk létre az `interval.time` csomagban a `Day` felsorolási típust, amely egy napot reprezentál. Mivel a tanórák csak hétköznap lehetnek, így a felsorolási típusban csak a következő elemek szerepeljenek: `MONDAY`, `TUESDAY`, `WEDNESDAY`, `THURSDAY` és `FRIDAY`.

*   A `Day` tartalmazzon egy nyilvános, `String` visszatérési értékű, paraméter nélküli `toString()` metódust, amely az adott naphoz visszaadja a nap magyar megfelelőjét, ékezetek nélkül (például `"hetfo"`).

_Tesztesetek:_ `tests/DayTest.java`

## `interval.time.Time`

Ez az osztály a tanórákhoz tartozó időpontot reprezentálja.

Hozzuk létre az `interval.time` csomagban a `Time` osztályt, amelynek legyenek a következő elemei:

*   Két rejtett adattag, ami az órát és a percet tárolja.

*   Egy rejtett konstruktor, amelynek két `int` paramétere van: az óra és a perc. Az itt átadott értékeket ellenőrzés nélkül tároljuk el az objektumban.

*   Egy nyilvános, osztályszintű `make()` metódus, amely szintén az órát és a percet kapja meg paraméterül. A metódus feladata, hogy ellenőrizze, hogy a kapott időpont szabályos-e: az időpont nem lehet korábban, mint `8:00` és nem lehet későbbi, mint `18:00` (és a perc természetesen csak 0 és 59 között lehet). Ha az időpont megfelelő, akkor a rejtett konstruktor segítségével hozzunk létre a `Time` objektumot és a referenciáját adjuk eredményül. Amennyiben ezek a kitételek nem teljesülnek, ne hozzunk létre új objektumot, hanem adjunk vissza egy üres, `null` referenciát!

*   Egy `toString()` metódus, amely legyen az `Object`-beli `toString()` felüldefiniálása. A metódus az időpontot `óra`:`perc` formátumban adja vissza, ahol a perc mindig legyen kétkarakteres (10-nél kisebb szám kapjon egy vezető 0-t). Például `9:05` vagy `14:30`.

*   Egy publikus `add()` metódus, amelynek egy `Time` objektumot ad vissza és egy `int` paramétere van: egy időtartam percben kifejezve. Az időtartam csak nemnegatív lehet, ezért, ha a metódus negatív számot kap paraméterül, akkor azonnal adjon vissza `null`-t. Ha a paraméter nemnegatív, akkor a metódus számolja ki, hogy milyen időpont lenne, ha az objektum által tárolt időpontot eltolnánk a paraméterben kapott perccel. Amennyiben ez az eltolt időpont megfelel a `make()` metódusban részletezett kikötéseknek, akkor a metódus hozza létre és adja vissza az új időpontot. Ha az eltolt időpont nem megfelelő, akkor a metódus adjon vissza `null`-t. A metódus semelyik esetben se változtassa meg az objektum aktuális állapotát! Például ha `09:05`-höz hozzáadunk 90 percet az eredmény `10:35`.

*   Az osztály definiálja felül az `Object`-beli `hashCode()` és `equals()` metódusokat, és valósítsa meg a `Comparable<Time>` interfészt.

_Tesztesetek:_ `tests/TimeTest.java`

## `interval.Interval`

Ez az osztály a tanórákhoz tartozó időintervallumot reprezentálja.

Hozzuk létre az `interval` csomagban az `Interval` osztályt, amelynek legyenek a következő elemei:

*   Megfelelő (rejtett) adattagok, amelyek képesek tárolni, hogy mikor van a tanóra.

*   Egy rejtett konstruktor, amely megkapja a tanóra napját (`Day` típusú), a kezdés időpontját (`Time` típusú) és az óra hosszát percben kifejezve (egész szám). Az itt átadott értékeket ellenőrzés nélkül tároljuk el az objektumban.

*   Egy nyilvános, osztályszintű `make()` metódus, amelynek paraméterül várja a napot (`Day` típusú), az órát, a percet és az óra hosszát, melyek `int` típusúak. A metódus feladata, hogy ellenőrizze, hogy a kapott paraméterek megfelelőek-e: mind az óra kezdetének, mind az óra végének meg kell felelnie a `Time` osztály `make()` metódusában leírt kikötéseknek és az óra hossza legalább 30 perc, de legfeljebb 180 perc lehet. Ha minden paraméter megfelelő, akkor a rejtett konstruktor segítségével hozzunk létre az `Interval` objektumot és a referenciáját adjuk eredményül. Amennyiben ezek a kitételek nem teljesülnek, ne hozzunk létre új objektumot, hanem adjunk vissza egy üres, `null` referenciát!

*   Legyen négy nyilvános "getter" metódus: `getDay()`, `getStartTime()`, `getEndTime()` és `getLength()`, amelyek adják vissza a napot (`Day` típusú), a kezdő és a befejező időpontot (mindkettő `Time` típusú) és az óra hosszát percben kifejezve (`int` típusú érték).

*   Egy `toString()` metódus, amely legyen az `Object`-beli `toString()` felüldefiniálása. A metódus az időpontot `nap kezdő-időpont - befejező-időpont` formátumban adja vissza, ahol nap, a kezdő és a befejező időpont olyan formátumban szerepel, ahogy a `Day` és `Time` osztály `toString()` metódusa előállítja. Például `"hetfo 8:15 - 8:45"`.

*   Az osztály definiálja felül az `Object`-beli `hashCode()` és `equals()` metódusokat, és valósítsa meg a `Comparable<Interval>` interfészt. Egy `Interval` objektum akkor tekinthető kisebbnek egy másiknál, ha vagy korábbi napon van, vagy egyező nap esetén korábban kezdődik; ha pedig mind a nap, mint a kezdő időpont megegyezik, akkor az óra hossza dönt (rövidebb intervallum a kisebb).

*   Egy nyilvános, logikai visszatérési értékű `endsBefore()` metódus, amely paraméterül egy másik `Interval` objektumot kap. A metódus akkor adjon vissza igazat, ha az aktuális intervallum legkésőbb a paraméterben kapott intervallum kezdetéig befejeződik (az egyezőség még elfogadott).

*   Egy nyilvános, logikai visszatérési értékű `overlapsWith()` metódus, amely paraméterül egy másik `Interval` objektumot kap. A metódus akkor ad vissza igazat, ha a két időpont ütközik, azaz van átfedés közöttük (de az még elfogadható, ha az egyik pont akkor ér véget, amikor a másik kezdődik és fordítva - tehát ezekben az esetekben nincs átfedés a két időpont között).

_Tesztesetek:_ `tests/IntervalTest.java`

## `classroom.ClassRoom`

Hozzuk létre az `classroom` csomagban az `ClassRoom` absztrakt osztályt, amely egy tantermet reprezentál. Az osztálynak legyenek a következő elemei:

*   Három `protected` láthatóságú adattag:

    *   egy szöveges típusú, ami a tanterem nevét tárolja

    *   egy egész típusú adattag, amely azt tárolja, hogy hány szék van a teremben

    *   és egy `TreeMap<Interval, String>` típusú adattag, amely a tanterem beosztását tárolja (milyen időintervallumra és milyen nevű órához foglalták le)

*   Egy nyilvános konstruktor, amely megkapja a tanterem nevét és a székek számát. A konstruktor tárolja el az adatokat. Kezdetben a teremre még nincsenek foglalások.

*   Egy nyilvános `getName()` nevű metódus, amely visszaadja a terem nevét.

*   Egy nyilvános, `numberOfSpots()` nevű, `int` visszatérési értékű _absztrakt_ metódus, amely azt fogja megadni, hogy hány hallgató befogadására alkalmas a terem.

*   Egy nyilvános, `hasComputers()` nevű, `boolean` visszatérési értékű _absztrakt_ metódus, amely azt fogja megadni, hogy vannak-e számítógépek a teremben.

*   Egy nyilvános, logikai visszatérési értékű `book()` metódus, amellyel le lehet foglalni a termet egy adott óra számára. A metódus paraméterben kapja meg, hogy milyen időintervallumra és milyen nevű óra számára szeretnénk foglalni. Ha az intervallum semmilyen korábbi foglalással nem ütközik, akkor a metódus tárolja el a kérést és adjon vissza igazat. Ha az intervallum valamilyen korábbi foglalással ütközik, akkor ne tároljon el semmit, és adjon vissza hamisat.

*   Egy nyilvános, szöveges visszatérési értékű `toString()` metódus, amely a következő formátumban adja vissza a foglalásokat: a foglalásokat szögletes zárójelben kell felsorolni, minden elem közé egy vesszőt és egy szóközt szúrva (az utolsó után természetesen nem), ahol egy foglalás a következőképpen néz ki: `intervallum (óranév)`, ahol az intervallumot olyan formában jelenítsük meg, ahogy az `Interval` osztály `toString()` metódusa előállítja. Például: `"[hetfo 8:15 - 8:45 (java gyakorlat), kedd 10:00 - 11:30 (forditoprogramok gyakorlat)]"`

_Tesztesetek:_ `tests/ClassRoomTest.java`

## `classroom.ComputerLab`

Hozzuk létre az `classroom` csomagban a `ComputerLab` osztályt, amely legyen a `ClassRoom` leszármazottja. Az osztály egy géptermet reprezentál. Az osztálynak legyenek a következő elemei:

*   Egy nyilvános konstruktor, amely megkapja a tanterem nevét, a székek számát és a számítógépek számát. A konstruktor tárolja el az adatokat.

*   Az osztály valósítsa meg a `numberOfSpots()` metódust, amely megadja, hogy hány hallgató befogadására alkalmas a terem. Mivel több hallgató saját laptopot használ, így a számítógépek számát túl lehet lépni 10%-kal (lefelé kerekítve), de több hallgatót nem lehet beengedni, mint ahány szék van. Tehát például 20 gép és 25 szék esetén a terem 22 fő számára alkalmas, míg 20 gép és 21 szék esetén csak 21 hallgató számára.

*   Az osztály valósítsa meg a `hasComputers()` metódust, amely igazat ad vissza.

*   Definiáljuk felül az ősosztály `toString()` metódusát. Az összeállított szöveg kezdődjön a `"gepterem"` szöveggel, majd ezt kövesse szóközzel elválasztva a terem neve kerek zárójelben, majd ezt kövesse szintén szóközzel elválasztva a foglalások listája (a `ClassRoom` osztályban részletezett formátumban). Például: `"gepterem (pc-9) [hetfo 8:15 - 8:45 (java gyakorlat), kedd 10:00 - 11:30 (forditoprogramok gyakorlat)]"`

_Tesztesetek:_ `tests/ComputerLabTest.java`

## `classroom.LectureRoom`

Hozzuk létre az `classroom` csomagban a `LectureRoom` osztályt, amely legyen a `ClassRoom` leszármazottja. Az osztály egy előadótermet reprezentál. Az osztálynak legyenek a következő elemei:

*   Egy nyilvános konstruktor, amely megkapja a tanterem nevét és a székek számát. A konstruktor tárolja el az adatokat.

*   Az osztály valósítsa meg a `numberOfSpots()` metódust, amely megadja, hogy hány hallgató befogadására alkalmas a terem. Mivel az előadások nyilvánosak, így azért, hogy helyet hagyjunk "külsős" érdeklődőknek is, hallgatókkal csak a terem 90%-át lehet feltölteni (lefelé kerekítve).

*   Az osztály valósítsa meg a `hasComputers()` metódust, amely hamisat ad vissza.

*   Definiáljuk felül az ősosztály `toString()` metódusát. Az összeállított szöveg kezdődjön a `"eloadoterem"` szöveggel, majd ezt kövesse szóközzel elválasztva a terem neve kerek zárójelben, majd ezt kövesse szintén szóközzel elválasztva a foglalások listája (a `ClassRoom` osztályban részletezett formátumban).

_Tesztesetek:_ `tests/LectureRoomTest.java`

## `classroom.SeminarRoom`

Hozzuk létre az `classroom` csomagban a `SeminarRoom` osztályt, amely legyen a `ClassRoom` leszármazottja. Az osztály egy gyakorlati termet reprezentál. Az osztálynak legyenek a következő elemei:

*   Egy nyilvános konstruktor, amely megkapja a tanterem nevét és a székek számát. A konstruktor tárolja el az adatokat.

*   Az osztály valósítsa meg a `numberOfSpots()` metódust, amely megadja, hogy hány hallgató befogadására alkalmas a terem. Ez a szám pontosan a székek számával azonos.

*   Az osztály valósítsa meg a `hasComputers()` metódust, amely hamisat ad vissza.

*   Definiáljuk felül az ősosztály `toString()` metódusát. Az összeállított szöveg kezdődjön a `"gyakorlati terem"` szöveggel, majd ezt kövesse szóközzel elválasztva a terem neve kerek zárójelben, majd ezt kövesse szintén szóközzel elválasztva a foglalások listája (a `ClassRoom` osztályban részletezett formátumban).

_Tesztesetek:_ `tests/SeminarRoomTest.java`

## `timetable.BookingException`

Hozzuk létre az `timetable` csomagban a `BookingException` osztályt, amely a foglalás során keletkező kivételt reprezentálja. Az osztály legyen az `Exception` leszármazottja. Az osztály tartalmazzon egy nyilvános konstruktort, amely paraméterben megkapja a hibaüzenetet. A konstruktor a hibaüzenettel hívja meg a szülő osztályának konstruktorát.

## `timetable.TimeTable`

Hozzuk létre az `timetable` csomagban a `TimeTable` osztályt, amely egy órarendet reprezentál.

*   Legyen egy rejtett `ArrayList<ClassRoom>` típusú adattag, amely a termeket tárolja.

*   Legyen egy nyilvános, `void` visszatérési értékű `add()` metódus, amely paraméterül egy `ClassRoom` típusú objektumot kap. A metódus ellenőrizze, hogy ilyen nevű terem szerepel-e már a tárolt listájában, és amennyiben igen, úgy dobjon egy `IllegalArgumentException` típusú kivételt, ahol a hiba szövege a következő: `"multiple names: a-hozzáadni-kívánt-terem-neve"`. Ha ilyen nevű terem még nem szerepelt a listában, akkor a metódus tárolja el a termet.

*   Egy rejtett, osztályszintű, logikai visszatérési értékű, `accept()` nevű metódus, amely paraméterül megkapja, hogy melyik teremben szeretnénk foglalást végezni (`ClassRoom` típusú objektum), hogy hány fő számára szeretnénk foglalni (egész szám), és hogy szükség van-e számítógépekre (logikai érték). A metódusnak el kell döntenie, hogy az adott terem megfelelő-e: befér-e a kívánt számú hallgató. Ha szükség van számítógépre az órához, akkor van-e számítógép a teremben, de ha nincs szükség számítógépekre, akkor ne legyen a teremben sem (ne foglaljunk fölöslegesen géptermeket, mert kevés van belőlük).

*   Egy nyilvános `void` visszatérési értékű `book()` metódus, amely segítségével időpontot foglalhatunk egy óra számára. A metódus paraméterei a következők: az óra neve, mikor van az óra (`Interval` típusú objektum), hány fő számára foglalunk, és hogy szükség van-e számítógépekre (logikai érték). A metódus végignézi a termeket, és amelyik típus és létszám szerint elfogadható, abban megpróbálja lefoglalni az adott időpontot az adott nevű óra számára. Ha valamelyik teremben sikeres a foglalás, akkor a metódus befejezi a munkáját. Ha semelyik terem nem volt megfelelő, akkor a metódus `BookingException` kivételt dob. Ha voltak olyan termek, melyek méret és típus szerint megfelelők voltak, de egyikben sem volt szabad az adott időpont, akkor a hibaüzenet (amit a kivétel konstruktorának átadunk) legyen `There is no room of the specified type available in the given interval.` Ha egyáltalán nem is volt olyan terem, mely méret és típus szerint jó lett volna, akkor pedig a hibaüzenet legyen `No room available in the given interval.`

*   Egy nyilvános, szöveges visszatérés értékű, paraméter nélküli `toString()` metódus, amely visszaadja az órarend szöveges reprezentációját. A formátum legyen a következő: az adott termek szöveges reprezentációja sortörésekkel elválasztva (az utolsó után is legyen).

_Tesztesetek:_ `tests/TimeTableTest.java`

Jó munkát!