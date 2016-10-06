- Készítsük a `utils.IntList` osztály implementációját! Ezt az osztályt `int` értékek tömbösített, dinamikus tárolására kell tudnunk használni és nagyban hasonlítani fog a [`java.util.ArrayList`](http://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html) osztályhoz. Legyenek ilyen konstruktorai:

  - nincs semmilyen paramétere (ilyenkor a tömb még nem tartalmaz semmit),
  - meg lehet adni egy `int` értékeket tartalmazó tömbbel, hogy mit tároljon kezdetben,

  valamint legyenek a következő műveletei:

  - `add()`: egy új elem hozzáadása a tömb végére,
  - `add()`: elem beszúrása az adott indexre (túlterhelt változat),
  - `concat()`: egy másik `IntList` tartalmának hozzáfűzése az aktuálishoz,
  - `get()`: az első elem lekérdezése
  - `get()`: adott indexű elem lekérdezése (túlterhelt változat),
  - `set()`: adott indexű elem beállítása, amennyiben van olyan indexű elem,
  - `remove()`: az első elem törlése,
  - `remove()`: adott indexű elem törlése (túlterhelt változat),
  - `indexOf()`: elem indexének megkeresése, ha nem található, akkor `-1`,
  - `size()`: a jelenleg tárolt elemek száma,
  - `clear()`: az összes elem törlése,
  - `toArray()`: az osztályban tárolt értékeket egyetlen tömbként történő visszaadása,
  - `show`: szöveggé alakítás.

  és legyen egy olyan, `read()` nevű osztályszintű metódusa, amellyel szövegből tudjuk beolvasni a tárolni kívánt elemeket. Az értékeket ebben a beolvasni kívánt szöveges reprezentációban egyszerűen szóközökkel választjuk el. Ellenőrizzük azt is, hogy a szövegben valóban számok szerepelnek! Ha ez nem teljesül és nem tudjuk beolvasni az összes elemet, akkor adjuk vissza `null` referenciát!

  Ügyeljünk arra, hogy az osztály semmilyen más egyéb eleme ne legyen a külvilág számára elérhető!
