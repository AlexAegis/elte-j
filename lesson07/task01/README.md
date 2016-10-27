*   Valósítsunk meg egy `utils.List` típust, amely láncolt lista adatszerkezetben képes dinamikus növekvő méretű, [`java.lang.Object`](http://docs.oracle.com/javase/8/docs/api/java/lang/Object.html) típusú értékeket tároló (agregáció) tömböket ábrázolni! A láncolás azt jelenti, hogy az új elemeket nem konkrétan egy tömb típusú értékben tároljuk el, hanem egymásra hivatkozó (rekurzív) listák sorozataként, amely a rákövetkező lista mellett mindig tárolja az aktuális elején található elemet is. Ha egy listának már rákövetkező listája, akkor ott a `null` referencia szerepeljen!

    Ennek az ábrázolási módnak a felhasználásával implementáljuk erre a típusra az alábbi műveleteket:

    *   egy konstruktor, amely egy elemet kapva paraméterül, létrehozza az azt az elemet tartalmazó, egyelemű listát,

    *   `add()`: egy elem beillesztése a láncolt lista elejére,

    *   `concat()`: a paraméterül kapott másik láncolt lista az aktuális lista után fűzése,

    *   `getFirst()`: a listában található első elem lekérdezése,

    *   `getRest()`: a lista fennmaradó részének (mint `List`) visszaadása, vagyis a lista az első elem nélkül,

    *   `length()`: a lista hosszának (rekurzív) lekérdezése,

    *   `remove()`: az első elem törlése,

    *   `toArray()`: a listában tárolt értékek egyetlen tömbként történő visszaadása (rekurzívan),

    *   `toString()`: (rekurzívan) szöveggé alakítás.