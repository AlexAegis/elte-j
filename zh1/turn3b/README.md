# B csoport

# Általános tudnivalók

Ebben az ismertetésben az osztályok, valamint a minimálisan szükséges metódusok leírásai fognak szerepelni. A feladatmegoldás során fontos betartani az elnevezésekre és típusokra vonatkozó megszorításokat, illetve a szövegek formázási szabályait. Segédfüggvények is létrehozhatók, a feladatban nem megkötött adattagok és elnevezéseik is a feladat megoldójára vannak bízva. Törekedjünk arra, hogy az osztályok belső reprezentációját a lehető legjobban védjük, tehát csak akkor engedjünk meg, és csak olyan hozzáférést, amelyre a feladat felszólít, vagy amit az osztályt használó kódrészlet megkíván!

A beadott megoldásnak működnie kell a mellékelt tesztprogrammal, de ez nem elégséges feltétele az elfogadásnak. Törekedjünk arra, hogy a megírt forráskód kellően általános és újrafelhasználható legyen!

Használható segédanyagok: [Java dokumentáció](/files/java/api/), legfeljebb egy üres lap és toll. Ha bármilyen kérdés, észrevétel felmerül, azt a felügyelőknek kell jelezni, _NEM_ a diáktársaknak!

_Figyelem!_ Az a metódus, amely fordítási hibát tartalmaz, automatikusan _nulla_ pontot ér!

# Tesztelés

Az egyes részfeladatokhoz tartoznak külön tesztesetek, amelyeket a feladatok végén jelöltük meg. Ezek önállóan is fordítható és futtatható `.java` állományok a mellékelt `.jar` segítségével. Például Windows alatt az első feladathoz tartozó tesztesetek így fordíthatóak és futtathatóak:

    > javac -cp .;Raffle-tests.jar tests/Part1.java
    > java -cp .;Raffle-tests.jar tests/Part1

Ugyanezeket a teszteseteket használja a komplett feladathoz tartozó tesztelést végző `Test` osztály is. Ezt Windows alatt így lehet futtatni:

    > java -cp .;Raffle-tests.jar Test

Linux alatt mindent ugyanúgy lehet fordítani és futtatni, csak a `-cp` paraméterében a pontosvesszőt kell kettőspontra cserélni.

# A feladat összefoglaló leírása

A feladat egy tombolát szimulál, amelyben utazásokat lehet nyerni a világ különböző városaiba.

A programhoz tartozik [egységtesztelő](https://bead.inf.elte.hu/files/java/Raffle-tests.zip), amely az egyes osztályok funkcionalitását teszteli.

# A feladat részletes ismertetése

## 1\. rész (6 + 1 pont)

`raffle.Destination` osztály:

Az osztály egy úticélt reprezentál.

*   Az osztálynak három rejtett adattagja van: egy szöveges típusú `city`, amely a várost, egy szöveges típusú `date`, amely az utazás dátumát és egy egész típusú `price`, amely a nyeremény értékét tárolja.

*   Az osztálynak legyen egy rejtett konstruktora, amely paraméterként megkapja a várost, a dátumot és a nyeremény értékét, és beállítja a megfelelő adattagokat.

*   Az osztály rendelkezik továbbá két rejtett, konstans, osztályszintű adattaggal is. Az egész típusú `MAX_PRICE` a nyeremények maximális értékét tárolja (ez az érték 7500). A `Destination` típusú `DESTINATION_OF_THE_YEAR` az év úticélját tárolja, az úticél New York, az utazás dátuma 2017/12/31, a nyeremény értéke pedig megegyezik a nyeremények maximális értékével.

*   Definiáljunk egy osztályszintű `make` nevű metódust is. A `make` metódus szintén a várost, a dátumot és a nyeremény értékét kapja meg paraméterként. A metódus először ellenőrzi, hogy a paraméterek megfelelőek. Amennyiben igen, akkor létrehozza és visszaadja a paramétereknek megfelelő `Destination` típusú objektumot. Ha a paraméterek nem megfelelőek, akkor a metódus `null`-t adjon vissza. A várost tartalmazó paraméter akkor megfelelő, ha csak betűkből vagy szóközből áll és legalább 2 karakter hosszú (azt, hogy ezek a karakterek milyen eloszlásban szerepelnek, nem kell vizsgálni). A dátum akkor megfelelő, ha éééé/hh/nn alakú, ahol é az év számjegyeit, h a hónap számjegyeit, n pedig a nap számjegyeit reprezentálja. Az évnek 2017-nek kell lennie. Ne felejtsük el ellenőrizni, hogy az adott hónapok hány naposak a 2017-es évben (pl. február 28 napos). Annak eldöntésére, hogy a dátum megfelelő, vezessük be a `validDate` metódust (l. később). A nyeremény értékét tartalmazó paraméter akkor helyes, ha pozitív és a nyeremények maximális értékét nem haladja meg (legfeljebb a nyeremények maximális értékével lehet egyenlő).

    _Segítség_: a metódusban használható a `Character` osztály [`isLetter()`](https://bead.inf.elte.hu/files/java/api/java/lang/Character.html#isLetter-char-) metódusa.

*   Legyen a `validDate` nevű metódus rejtett, osztályszintű, amely eldönti, hogy a szöveges típusú paraméterként kapott dátum megfelelő-e vagy sem.

*   Definiáljunk az osztályban egy paraméter nélküli `getPrice` nevű metódust, amely visszaadja a nyeremény értékét.

*   Az osztály tartalmazzon egy `betterHit` nevű metódust, amely eldönti, hogy az aktuális úticél mint nyeremény értéke magasabb-e a paraméterben kapott úticél értékénél.

*   Definiáljunk egy paraméter nélküli `toString` nevű metódust is, amely visszaadja az objektum szöveges reprezentációját. A formátum legyen a következő: `városnév dátum (a nyeremény értéke EUR)`, ahol a dátumot éééé/hh/nn alakban adjuk meg. Pl. `New York 2017/12/31 (7500 EUR)`.

Tesztelő: `tests.Part1`

## 2\. rész (7 + 2 pont)

`raffle.Raffle` osztály:

Az osztály a tombolát reprezentálja.

*   Az osztály egy rejtett tömbös lista ([`java.util.ArrayList`](https://bead.inf.elte.hu/files/java/api/java/util/ArrayList.html)) típusú adattagban tartsa nyilván, hogy milyen úticélokat lehet nyerni (`Destination` típusú objektumok).

*   Az osztálynak legyen egy publikus konstruktora, amely egy fájlnevet kap paraméterként. A fájl úticélokat tartalmaz. A metódus dolgozza fel a fájlt, szűrje ki belőle a hibás adatokat, majd tárolja el az úticélokat a listában. Ha a fájl nem létezik, vagy nem olvasható, akkor az úticélok listája legyen üres, a konstruktor pedig ne engedje ki a keletkező kivételt. Az inputfájl minden sora egy uticélt tartalmaz `városnév@dátum,nyeremény értéke` formában, ahol a dátumot éééé/hh/nn alakban adjuk meg. Ha a sor nem ilyen szerkezetű, vagy a `nyeremény értéke` nem konvertálható számmá, vagy a megadott adatokból a `Destination` típusú objektum nem hozható létre, akkor a sort figyelmen kívül kell hagyni és a feldolgozást a következő sorral kell folytatni.

    _Segítség_: Az, hogy egy szöveg egy egész számot tartalmaz, ellenőrizhető úgy, hogy elkapjuk az [`Integer.parseInt()`](https://bead.inf.elte.hu/files/java/api/java/lang/Integer.html#parseInt-java.lang.String-) által számmá történő konvertáláskor dobott [`java.lang.NumberFormatException`](https://bead.inf.elte.hu/files/java/api/java/lang/NumberFormatException.html) kivételt.

*   Definiáljunk egy `numberOfDestinations` nevű metódust, amely visszaadja a tombolajáték során megnyerhető úticélok számát.

*   Definiáljunk egy paraméter nélküli `toString` nevű metódust is, amely visszaadja a tombolajáték szöveges reprezentációját (a még megnyerhető úticélokat). A szöveg összeállításakor az úticélok olyan sorrendben szerepeljenek, amilyen sorrendben a konstruktor beolvasta, és olyan formában, ahogyan a `Destination` `toString` nevű metódusa előállítja őket. Figyeljünk arra, hogy az utolsó úticél után már ne legyen sortörés!

Tesztelő: `tests.Part2`

# 3\. rész (6 + 1 pont)

A `raffle.Raffle` osztályban definiáljuk az alábbi publikus metódusokat:

*   `insertionSort`: a metódus a megnyerhető úticélok listáját beszúró rendezéssel a nyeremények értéke szerint csökkenő sorrendbe rendezi. Tehát a lista elején az az úticél áll, amelynek mint nyereménynek az értéke a legnagyobb, a végén pedig az, amelynek a legkisebb.

    _Segítség_: A beszúró rendezés a következőképpen működik: feltesszük, hogy az egy elemből álló lista eleve rendezett. Minden menetben, minden egyes elemére a listának az 1-es indexűtől kezdve, egészen a lista legutolsó eleméig, ellenőrizzük, hogy az aktuális elem hogyan viszonyul a már rendezett részlistában lévő elemekhez. Az aktuális elemnél kisebb elemeket jobbra toljuk. Ha egy nagyobb elem következik, vagy pedig a lista végére érünk, az adott elemet beszúrhatjuk.

*   `weightedAverage`: a metódus az úticélok árainak súlyozott átlagát számolja ki, egy valós számot ad vissza eredményként. A súlyozott ár kiszámítása a következőképpen történjen (ha vannak megnyerhető úticélok): egy úticél értékét megszorozzuk a konstans 0.25 súllyal, majd ezen szorzatokat összeadjuk. Az így kapott összeget elosztjuk az úticélok számának és a konstans 0.25 súly szorzatával. Ha nincsenek úticélok, akkor a metódus <span class="math inline"><span class="katex"><span class="katex-mathml"><math><semantics><mrow><mo>−</mo><mn>1</mn></mrow><annotation encoding="application/x-tex">-1</annotation></semantics></math></span><span class="katex-html" aria-hidden="true"><span class="strut" style="height: 0.64444em;"></span><span class="strut bottom" style="height: 0.72777em; vertical-align: -0.08333em;"></span><span class="base textstyle uncramped"><span class="mord">−</span><span class="mord mathrm">1</span></span></span></span></span>-et adjon vissza.

Tesztelő: `tests.Part3`

# 4\. rész (6 + 1 pont)

A `raffle.Raffle` osztályban definiáljuk az alábbi publikus metódusokat:

*   `raffle`: a metódusnak nincsen paramétere és egy tombolahúzást szimulál. A játékos véletlenszerűen húz egyet a még megnyerhető úticélok közül. A húzás előtt először a korábban megírt beszúró rendezéssel rendezzük az úticélokat, a húzást csak ezután hajtsuk végre. A kihúzott úticélt el kell távolítani a listából, ez lesz a metódus visszatérési értéke. Ha a tombolahúzás megkezdésekor egyetlen megnyerhető úticélunk sincs, akkor a metódus `null`-t adjon vissza.

    _Segítség_: használható a [`java.util.Random`](https://bead.inf.elte.hu/files/java/api/java/util/Random.html) osztály véletlen adat generálására.

*   `simulate`: a metódusnak nincs paramétere és a tombolajátékot szimulálja. A tombolajáték addig tart, amíg van megnyerhető úticél. A metódus az úticélokat egy tömbös listába gyűjtse össze, olyan sorrendben, ahogyan az úticélokat kihúzták. Ez a lista lesz a metódus visszatérési értéke.

Tesztelő: `tests.Part4`

## Pontozás (elmélet + gyakorlat)

*   0 -- 20: elégtelen (1)
*   21 -- 25: elégséges (2)
*   26 -- 30: közepes (3)
*   31 -- 35: jó (4)
*   36 -- 40: jeles (5)