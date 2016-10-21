# A feladat összefoglaló leírása

Ebben a feladatban egy irodalomjegyzéket feldolgozó programot és annak részeit fogjuk elkészíteni. A feldolgozás során a szabványos bemenetről olvasunk be CSV formátumban bejegyzéseket, majd ezeket a parancssorban megadott kapcsolók szerint formázni és szűrni tudjuk, és az eredményt a szabványos kimenetre írjuk ki.

_A részfeladatok megoldása során ügyeljünk arra, hogy a megadottakon kívül egyetlen osztály se tartalmazzon más publikus metódust vagy adattagot, illetve egyik csomag se tartalmazzon más osztályokat! A megoldást egyetlen `.zip` állományként kell feltölteni, amely tartalmazza a csomagnak megfelelő könyvtárszerkezetben az összes forráskódot. A fordítás során keletkező `.class` állományokat viszont már nem szabad mellékelni! A fordításhoz legalább a Java Standard Edition 8 használata kötelező._

A feladathoz tartozik egy [letölthető segédlet](https://bead.inf.elte.hu/files/java/Bibliography.zip), ahol megtaláljuk a feladat leírásában hivatkozott összes állományt.

# Tesztelés

Az egyes részfeladatokhoz tartoznak külön tesztesetek, amelyeket a feladatok végén jelöltük meg. Ezek önállóan is fordítható és futtatható `.java` állományok a mellékelt `.jar` segítségével. Például Windows alatt az első feladathoz tartozó tesztesetek így fordíthatóak és futtathatóak:

    > javac -cp .;tests-Bibliography.jar tests/AuthorTest.java
    > java -cp .;tests-Bibliography.jar tests/AuthorTest

Ugyanezeket a teszteseteket használja a komplett feladathoz tartozó tesztelést végző `Test` osztály is. Ezt Windows alatt így lehet futtatni:

    > java -cp .;tests-Bibliography.jar Test

Linux alatt mindent ugyanúgy lehet fordítani és futtatni, csak a `-cp` paraméterében a pontosvesszőt kell kettőspontra cserélni.

# A feladat részletes ismertetése

## `person.Author`

Az irodalomjegyzékben cikkek és könyvek adatai szerepelnek, ahol az egyes bejegyzésekhez tartozik mindig egy szerző. (Az egyszerűség kedvéért itt most minden bejegyzéshez csak egyetlen szerzőt tartunk nyilván.) A szerzőket a nevük szerint ábrázoljuk, és a program többi részéhez erre vonatkozóan kell ellenőrzéseket és formázási lehetőségeket megvalósítanunk.

Hozzuk létre a `person` csomagban az `Author` osztályt, amelynek legyenek a következő elemei:

*   Egy rejtett (nem publikus) konstruktor, amelynek két `String` paramétere van, a szerző vezeték- és keresztneve. Az itt átadott értékeket tároljuk el az objektumban.

*   Egy osztályszintű `make()` metódus, amely egy `String` értéket kap paraméterül, amely egy teljes nevet tartalmaz. A metódus feladata, hogy ellenőrizze, hogy a kapott szöveg valóban szabályos név-e: vezeték- és keresztnévből kell állnia, amelyeket szóközök választanak el egymástól, a tagoknak egyenként nagybetűvel kell kezdődnie és mindegyiküknek legalább egy karakterből kell állnia. Amennyiben ezek a kitételek nem teljesülnek a paraméterre, ne hozzunk létre új objektumot, hanem adjunk vissza egy üres, `null` referenciát! Ha a szöveg megfelelő, akkor hozzunk létre belőle a rejtett konstruktor segítségével egy objektumot és a referenciáját adjuk eredményül.

*   Egy `getLastName()` metódus, amely visszaadja az objektumban tárolt szerző vezetéknevét.

*   Egy `getFirstName()` metódus, amely visszaadja az objektumban tárolt szerző keresztnevét.

*   Egy publikus konstruktor, amely megkap egy másik `Author` típusú objektumot, és annak belső állapota alapján inicializálja az aktuálisat, tehát lemásolja.

*   Egy `equals()` metódus, amely kap egy másik `Author` típusú objektumot, és eredményként, egy logikai értékként megadja, hogy az aktuális objektum belső állapota megegyezik-e vele, összehasonlítja vele.

*   Egy `show()` metódus, amely visszaadja az objektum belső állapotának megfelelően annak szöveges ábrázolását. Ekkor a szerző vezetékneve, majd egy vessző, szóköz és a keresztnevének első betűje lesz a szövegben. Tehát, például, ha a szerző `John Smith`, a neki megfelelő szöveges ábrázolás `Smith, J` lesz.

_Tesztesetek:_ `tests/AuthorTest.java`

## `biblio.Entry`

A következő lépés maguknak a bejegyzéseknek az ábrázolása valamilyen módon. A bejegyzésekben mindig egy szerzőt (`person.Author`), az alkotásának a címét (mint `String`), a kiadás évét (mint `int`) és a kiadóját (mint `String`) tároljuk el. A szöveggé alakítás több különböző formátum szerint történhet, amelyek abban térnek el, hogy a bejegyzésekhez milyen módon rendelünk címkéket, amikkel hivatkozni tudunk rájuk. Az egyes bejegyzéseket egy globális számlálóval címkézzük fel, vagyis számoljuk a menet közben létrehozott objektumokat. Ezeket a címkéket az egyik formázásnál fel is használjuk.

Hozzuk létre a `biblio` csomagban az `Entry` osztályt, amelynek legyenek a következő elemei:

*   Egy rejtett (nem publikus) konstruktor, amely megkapja az objektum létrehozásához szükséges adatokat, mint a szerző, cím, kiadás éve, kiadó, és ezek alapján inicializálja azt.

*   Egy osztályszintű `make()` metódus, amely csak bizonyos előfeltételek teljesülése esetében hoz létre egy `Entry` objektumot. Egy bejegyzés csak akkor hozható létre, ha a kiadás éve <span class="math inline"><span class="katex"><span class="katex-mathml"><math><semantics><mrow><mn>1</mn><mn>5</mn><mn>0</mn><mn>0</mn></mrow><annotation encoding="application/x-tex">1500</annotation></semantics></math></span><span class="katex-html" aria-hidden="true"><span class="strut" style="height: 0.64444em;"></span><span class="strut bottom" style="height: 0.64444em; vertical-align: 0em;"></span><span class="base textstyle uncramped"><span class="mord mathrm">1</span><span class="mord mathrm">5</span><span class="mord mathrm">0</span><span class="mord mathrm">0</span></span></span></span></span> és <span class="math inline"><span class="katex"><span class="katex-mathml"><math><semantics><mrow><mn>2</mn><mn>0</mn><mn>1</mn><mn>6</mn></mrow><annotation encoding="application/x-tex">2016</annotation></semantics></math></span><span class="katex-html" aria-hidden="true"><span class="strut" style="height: 0.64444em;"></span><span class="strut bottom" style="height: 0.64444em; vertical-align: 0em;"></span><span class="base textstyle uncramped"><span class="mord mathrm">2</span><span class="mord mathrm">0</span><span class="mord mathrm">1</span><span class="mord mathrm">6</span></span></span></span></span> között van, a cím és a szerző nem üres. Ellenkező esetben egyszerűen csak adjon vissza eg üres, vagyis `null` referenciát!

*   Egy `getId()` metódus, amely visszaadja az aktuális objektum sorszámát. Ezt a sorszámot minden objektum létrehozásakor léptetjük.

*   Egy osztályszintű `resetId()` metódus, amely nullára állítja az `Entry` objektumok globális számlálóját.

*   Egy osztályszintű `count()` metódus, amely visszaadja a globális számláló aktuális értékét.

*   Egy `getAuthor()` metódus, amely visszaadja a bejegyzéshez tartozó szerzőt.

*   Egy `getTitle()` metódus, amely visszaadja a bejegyzéshez tartozó címet.

*   Egy `getYear()` metódus, amely visszaadja a bejegyzéshez tartozó kiadási évet.

*   Egy `getPublisher()` metódus, amely visszaadja a bejegyzéshez tartozó kiadót.

*   Egy `show()` metódus, amely előállítja egy `String` értékként a bejegyzéshez tartozó szöveges változatot. Ennek legyen egy `int` paramétere, amellyel meg lehet adni a bejegyzéshez tartozó hivatkozás formátumát. Ennek lehetséges értékeit ábrázoljuk a következő osztályszintű konstansokkal:

    *   `FORMAT_RAW`: A bejegyzés sorszáma legyen a címke.

    *   `FORMAT_AUTHOR_YEAR`: A szerző vezetékneve és a kiadás éve legyen a címke.

    *   `FORMAT_AUTHOR_YEAR_COMPACT`: A szerző szöveges alakjának első két karaktere, valamint a kiadás évének utolsó két számjegye legyen a címke.

    A létrehozandó szöveg alakja legyen a következő attól függően, hogy a kiadó értéke üres vagy sem. Ha tartozik a bejegyzéshez kiadó, akkor nézzen ki így az eredmény (tehát címke, szerző, cím, kiadó, kiadás éve):

          [Smith1990] Smith, J. Title of the Book, Some Publishing House, 1990.

    Amikor nincs kiadó, akkor legyen ilyen (tehát címke, szerző, cím, kiadás éve):

          [Smith1990] Smith, J. Title of the Paper, 1990.

_Tesztesetek:_ `tests/EntryTest.java`

## `csv.CSV`

Azokat az adatokat, amelyekből bejegyzéseket akarunk készíteni az irodalomjegyzékben, CSV formátumból olvassuk be, amely elnevezés a [Comma-Separated Values](https://en.wikipedia.org/wiki/Comma-separated_values) rövidítése. Ebben az esetben az adatokat táblázatos formában ábrázoljuk, ahol egy szöveges állomány sorai a táblázat sorai, ahol a táblázat oszlopaiban szereplő elemeket vesszőkkel választjuk el egymástól. Az ilyen alakú szövegek feldolgozását kell a most következő lépésben megvalósítani.

Hozzuk létre a `csv` csomagban a `CSV` osztályt, amelynek legyenek a következő elemei:

*   Egy rejtett (nem publikus) konstruktor, amely egy kétdimenziós `String` tömböt kap paraméterként. Ez a tömb tartalmazza a beolvasott táblázat sorait és oszlopait, ezt kell letárolnunk a létrehozott objektumban.

*   Egy osztályszintű `read()` metódus, amely paraméterként egy `java.util.Scanner` objektumot, és ebből próbálja beolvasni a CSV formátum szerint a táblázat sorait és oszlopait. A beolvasás során ezekből állítsuk össze itt a nekik megfelelő kétdimenziós `String` tömböt, majd ezzel hozzunk létre így egy új objektumot. A tömb felépítése során ügyeljünk arra, hogy az oszlopok értékeinek széléről vágjuk le a szóközöket!

*   Egy `getContents()` metódus, amely visszaadja az objektumban tárolt belső állapotot, a kétdimenziós `String` tömböt. Ennek során viszont vigyázzunk arra, hogy ne a referenciáját adjuk vissza, hanem a tömb egy másolatát!

_Tesztesetek:_ `tests/CSVTest.java`

## `biblio.Query`

Az irodalomjegyzékek feldolgozásának egyik módja, hogy le tudjuk ezeket szűrni szerzők vagy kiadó szerint. Ehhez egy újabb osztályt fogunk készíteni, amelyben ilyen szűrési feltételeket tudunk lekérdezésekként tárolni, illetve ezek segítségével bejegyzésekről eldönteni, hogy megfelelnek-e azoknak.

Hozzuk létre a `biblio` csomagban a `Query` osztályt, amelynek legyenek a következő elemei:

*   Egy rejtett (nem publikus) konstruktor, amelyben egy lekérdezéshez adhatunk meg (`person.Author` típusú) szerzőt és (`String` típusú) kiadót.

*   Egy osztályszintű `byAuthor()` metódus, amely kap egy (`person.Author` típusú) szerzőt, és ennek alapján létrehoz egy új lekérdezést. Ilyenkor a kiadó értéke legyen `null`!

*   Egy osztályszintű `byPublisher()` metódus, amely kap egy (`String` típusú) kiadót, és ebből példányosít egy lekérdezést. Ilyenkor a szerző legyen `null`!

*   Egy `accept()` metódus, amely kap egy `Entry` típusú objektumot, és annak megfelelő adattagjai lekérdezésével eldönti róla, hogy illeszkedik-e a lekérdezésben megfogalmazott feltételeknek! Ehhez egy logikai értéket kell visszaadnia, ahol attól függően, hogy a szerző vagy a kiadó lett nem `null` értékre állítva, megvizsgálja, hogy egyezik-e az adott adattag a referenciaként beállított értékkel.

_Tesztesetek:_ `tests/QueryTest.java`

## `biblio.Bibliography`

A beolvasott bejegyzéseket és azok feldolgozását egy külön osztállyal fogjuk össze, amelyből aztán a belső állapot alapján elő tudunk állítani egy, az összes tartalmazott bejegyzést egy adott formázás szerint megjelenítő szöveges formát.

Hozzuk létre a `biblio` csomagban a `Bibliography` osztályt, amelynek legyenek a következő elemei:

*   Egy konstruktor, amely kap egy `csv.CSV` típusú objektumot, amelytől elkéri a benne levő szöveges formátumú táblázatot, majd annak sorait egyenként bejegyzésekké alakítja a következő megfontolások szerint. A soroknak négy oszlopból kell állniuk, ahol az első a szerző, a második a cím, a harmadik a kiadó, és végül a negyedik a kiadás éve. A szerző oszlopban levő értéknek az `person.Author` osztály példányaira vonatkozó megszorítások szerint szabályosnak kell lennie. A kiadás évének csak decimális számnak szabad lennie, képeseknek kell lennünk hiba nélkül beolvasni `int` értékként. Amennyiben ezek közül valamelyik elvárás nem teljesül, úgy azt a sort hagyjuk ki a feldolgozásból és folytassuk a következővel! Mielőtt eltárolnánk a `biblio.Entry` objektumokat, nullázzuk azok globális számlálóját.

*   Egy `filter()` metódus, amely paraméterként kap egy `biblio.Query` objektumot, és annak felhasználásával eldobja a belső állapotában tárolt bejegyzések közül azokat, amelyek nem felelnek meg az így megfogalmazott lekérdezésnek. Ezzel a metódussal tehát megváltozik a belső állapot, és az objektumban csak azok a bejegyzések maradnak, amelyek a szűrő szerint elfogadhatóak!

*   Egy `show()` metódus, amely paraméterében kap egy `int` értéket. Ez az érték az `biblio.Entry` osztály formázásra vonatkozó konstansait veheti fel, és arra tudjuk itt is használni, hogy amikor a bejegyzésekből egy összefüggő, de (a `\n` karakter segítségével) többsoros szöveget hozunk létre, akkor azok a megfelelő formázás szerint jelenjenek meg.

_Tesztesetek:_ `tests/BibliographyTest.java`

## `main.Main`

Az eddigi osztályokból most már össze tudunk állítani egy parancssorból is önállóan futtatható programot. Ez a szabványos bemenetről képes CSV formátumú adatokat beolvasni soronként és a parancssori paraméterekben megadott formázási és szűrési beállítások szerint a szabványos kimenetre kiírni az így feldolgozott irodalomjegyzéket.

Hozzuk létre a `main` csomagban a `Main` osztályt, amelyben legyen egy főprogram! A következőképpen kell viselkednie:

*   Alapértelmezés szerint az irodalomjegyzék bejegyzéseit a legegyszerűbb hivatkozási formázás (`biblio.Entry.FORMAT_RAW`) szerint jelenítse meg.

*   Ha egy parancssori paraméter `publisher=`, akkor az utána következő argumentumot tekintsük egy kiadó nevének, és azzal valósítunk meg egy szűrést a beolvasott adatokon.

*   Ha egy paranccsori paraméter `author=`, akkor az utána következő alapján valósítsunk meg egy szerző szerinti szűrést a beolvasott adatokon.

*   Ha egy parancssori paraméter `format=`, akkor a rákövetkező argumentum értéke alapján változtassuk meg a bejegyzések formázását. Itt a `raw` legyen a `biblio.Entry.FORMAT_RAW`, az `authorYear` legyen a `biblio.Entry.FORMAT_AUTHOR_YEAR`, és az `authorYearCompact` legyen a `biblio.Entry.FORMAT_AUTHOR_YEAR_COMPACT`.

*   A parancssori paramétereknél mindig egyetlen szűrési és egyetlen formázási beállítást engedhetünk meg legfeljebb. Több ilyen megadása esetén mindig a sorban az utolsóként megadott érvényesüljön.

Például, ha adott a következő bemenet:

    Simon Marlow,Parallel and Concurrent Programming in Haskell,O'Reilly,2013
    Gerald Huet,Functional Pearl: The Zipper,,1997
    Bryan O'Sullivan,Real World Haskell,O'Reilly,2008
    Duncat Coutts,Stream Fusion: From Lists to Streams to Nothing at All,,2007
    Paul Hudak,The Haskell School of Expression,Cambridge University Press,2000
    Simon Thompson,Haskell: The Craft of Functional Programming,Addison-Wesley,2011
    Ralf Hinze,Finger Trees: A Simple General-purpose Data Structure,,2006
    Ralf Hinze,Functional Pearl: A fresh look at binary search trees,,2002
    Chris Okasaki,Purely Functional Data Structures,,1998
    Simon Marlow,Multicore Garbage Collection with Local Heaps,,2011
    Simon Marlow,Runtime Support for Multicore Haskell,,2009
    Oleg Kiselyov,Iteratees,,2012
    Graham Hutton,Programming in Haskell,Cambridge University Press,2007
    Joshua Bloch,Effective Java: Programming Language Guide,Addison-Wesley,2001
    David Chisnall,The Definitive Guide to the Xen Hypervisor,Prentice Hall,2007

akkor erre a programnak az alábbi válaszokat kell adnia az egyes beállításoknak megfelelően. Például, paraméterek nélkül ezt kapjuk:

    [0] Marlow, S. Parallel and Concurrent Programming in Haskell, O'Reilly, 2013
    [1] Huet, G. Functional Pearl: The Zipper, 1997
    [2] O'Sullivan, B. Real World Haskell, O'Reilly, 2008
    [3] Coutts, D. Stream Fusion: From Lists to Streams to Nothing at All, 2007
    [4] Hudak, P. The Haskell School of Expression, Cambridge University Press, 2000
    [5] Thompson, S. Haskell: The Craft of Functional Programming, Addison-Wesley, 2011
    [6] Hinze, R. Finger Trees: A Simple General-purpose Data Structure, 2006
    [7] Hinze, R. Functional Pearl: A fresh look at binary search trees, 2002
    [8] Okasaki, C. Purely Functional Data Structures, 1998
    [9] Marlow, S. Multicore Garbage Collection with Local Heaps, 2011
    [10] Marlow, S. Runtime Support for Multicore Haskell, 2009
    [11] Kiselyov, O. Iteratees, 2012
    [12] Hutton, G. Programming in Haskell, Cambridge University Press, 2007
    [13] Bloch, J. Effective Java: Programming Language Guide, Addison-Wesley, 2001
    [14] Chisnall, D. The Definitive Guide to the Xen Hypervisor, Prentice Hall, 2007

A `format= authorYear` paraméter esetén ezt kapjuk:

    [Marlow2013] Marlow, S. Parallel and Concurrent Programming in Haskell, O'Reilly, 2013
    [Huet1997] Huet, G. Functional Pearl: The Zipper, 1997
    [O'Sullivan2008] O'Sullivan, B. Real World Haskell, O'Reilly, 2008
    [Coutts2007] Coutts, D. Stream Fusion: From Lists to Streams to Nothing at All, 2007
    [Hudak2000] Hudak, P. The Haskell School of Expression, Cambridge University Press, 2000
    [Thompson2011] Thompson, S. Haskell: The Craft of Functional Programming, Addison-Wesley, 2011
    [Hinze2006] Hinze, R. Finger Trees: A Simple General-purpose Data Structure, 2006
    [Hinze2002] Hinze, R. Functional Pearl: A fresh look at binary search trees, 2002
    [Okasaki1998] Okasaki, C. Purely Functional Data Structures, 1998
    [Marlow2011] Marlow, S. Multicore Garbage Collection with Local Heaps, 2011
    [Marlow2009] Marlow, S. Runtime Support for Multicore Haskell, 2009
    [Kiselyov2012] Kiselyov, O. Iteratees, 2012
    [Hutton2007] Hutton, G. Programming in Haskell, Cambridge University Press, 2007
    [Bloch2001] Bloch, J. Effective Java: Programming Language Guide, Addison-Wesley, 2001
    [Chisnall2007] Chisnall, D. The Definitive Guide to the Xen Hypervisor, Prentice Hall, 2007

A `format= authorYearCompact` paraméter esetén ezt kapjuk:

    [Ma13] Marlow, S. Parallel and Concurrent Programming in Haskell, O'Reilly, 2013
    [Hu97] Huet, G. Functional Pearl: The Zipper, 1997
    [O'08] O'Sullivan, B. Real World Haskell, O'Reilly, 2008
    [Co07] Coutts, D. Stream Fusion: From Lists to Streams to Nothing at All, 2007
    [Hu00] Hudak, P. The Haskell School of Expression, Cambridge University Press, 2000
    [Th11] Thompson, S. Haskell: The Craft of Functional Programming, Addison-Wesley, 2011
    [Hi06] Hinze, R. Finger Trees: A Simple General-purpose Data Structure, 2006
    [Hi02] Hinze, R. Functional Pearl: A fresh look at binary search trees, 2002
    [Ok98] Okasaki, C. Purely Functional Data Structures, 1998
    [Ma11] Marlow, S. Multicore Garbage Collection with Local Heaps, 2011
    [Ma09] Marlow, S. Runtime Support for Multicore Haskell, 2009
    [Ki12] Kiselyov, O. Iteratees, 2012
    [Hu07] Hutton, G. Programming in Haskell, Cambridge University Press, 2007
    [Bl01] Bloch, J. Effective Java: Programming Language Guide, Addison-Wesley, 2001
    [Ch07] Chisnall, D. The Definitive Guide to the Xen Hypervisor, Prentice Hall, 2007

A `publisher= Addison-Wesley` és `format= authorYear` esetén ezt kapjuk:

    [Thompson2011] Thompson, S. Haskell: The Craft of Functional Programming, Addison-Wesley, 2011
    [Bloch2001] Bloch, J. Effective Java: Programming Language Guide, Addison-Wesley, 2001

A `format= authorYear` és `author= "Simon Marlow"` esetén ezt kapjuk:

    [Marlow2013] Marlow, S. Parallel and Concurrent Programming in Haskell, O'Reilly, 2013
    [Marlow2011] Marlow, S. Multicore Garbage Collection with Local Heaps, 2011
    [Marlow2009] Marlow, S. Runtime Support for Multicore Haskell, 2009

_Tesztesetek:_ `tests/MainTest.java`

Jó munkát!