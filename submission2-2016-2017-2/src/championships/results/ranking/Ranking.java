package championships.results.ranking;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Ennek az interfésznek a megvalósításai egy rangsor nézetként használhatók egy adott Results objektumhoz.
 * Ez azt jelenti, hogy mikor létrejön egy adott Results objektumhoz, nem másolja le az abban tárolt
 * eredményeket, hanem mindig, mikor valamelyik metódusa meghívásra kerül, a Results objektumban
 * aktuálisan tárolt friss adatok alapján végzi a számítást.
 * Úgy rangsorol, hogy minden nemzethet hozzárendel egy pontszámot.
 * Ez a pontszám nem feltétlenül egy tényleges szám: bármilyen rendezhető (Comparable) típus lehet.
 * Az a nemzet fog előrébb kerülni a rangsorban, amelyiknek ez a pontszáma nagyobb.
 *
 * Példa:
 *
 *         Results results = Factory.createResults();
 *         Ranking <Medals> ranking = results.rankNationsByGoldFirst();
 *
 *         System.out.println(ranking.getRanking()); // []
 *
 *         results.addResult("gyors 50m", "x", "Magyarország", 1);
 *
 *         System.out.println(ranking.getRanking()); // [Magyarország]
 *
 *         results.addResult("gyors 50m", "y", "USA", 2);
 *         results.addResult("gyors 50m", "z", "USA", 3);
 *         results.addResult("gyors 100m", "y", "Kína", 1);
 *         results.addResult("gyors 100m", "z", "Kína", 3);
 *
 *         System.out.println(ranking.getPointsOf("Kína")); //  <1, 0, 1>
 *         System.out.println(ranking.getPointsOf("Magyarország")); //  <1, 0, 0>
 *         System.out.println(ranking.getPointsOf("USA")); //  <0, 1, 1>
 *         System.out.println(ranking.getRanking()); // [Kína, Magyarország, USA]
 *
 *
 * Tipp: tehát lényegében egy Ranking objektumnak nem is kell tárolnia semmit, csak egy hivatkozást
 * arra, hogy melyik Results objektumhoz tartozik. Emellett az aktuális típusából következően
 * tudnia kell azt, hogy hogyan számítsa ki az egyes nemzetekhez az ő pontszámukat.
 * Tipp: az osztály legtöbb metódusa visszavezethető egymásra, egyszerűen kiszámíthatók más
 * metódusok eredményei segítségével.
 *
 * @param <T> ez a típus fogja ábrázolni a nemzetekhez rendelt pontszámot,
 *           mely tetszőleges rendezhető (Comparable) típus lehet
 */
public interface Ranking<T extends Comparable<T>> {

    /**
     * Visszatér a versenyző nemzetek neveinek halmazával. A visszaadott érték mindig friss,
     * a háttérben elért Results objektum aktuális állapota alapján számítódik.
     * A visszaadott halmaz módosításai semmilyen hatással sincsenek ennek a Ranking objektumnak
     * vagy a mögötte lévő Results objektumnak a belső állapotára.
     *
     * @return a versenyző nemzetek halmaza
     */
    Set<String> getNations();

    /**
     * Megadja egy adott nemzet pontszámát. A visszaadott érték mindig friss, a háttérben
     * elért Results objektum aktuális állapota alapján számítódik.
     *
     * @param nation a kérdéses nemzet
     * @return a nemzet pontszáma
     */
    T getPointsOf(String nation);

    /**
     * Megadja az összes nemzet pontszámát. A visszaadott érték mindig friss,
     * a háttérben elért Results objektum aktuális állapota alapján számítódik.
     * A visszaadott Map kulcsai a nemzetek nevei, a hozzájuk tartozó érték a hozzájuk társítható pontszám.
     *
     * A visszaadott map módosításai semmilyen hatással sincsenek ennek a Ranking objektumnak
     * vagy a mögötte lévő Results objektumnak a belső állapotára.
     *
     * @return az összes nemzet pontszáma
     */
    Map<String,T> getPointsOfAll();

    /**
     * Visszatér a nemzetek rangsorával. A visszaadott érték mindig friss, a háttérben elért
     * Results objektum aktuális állapota alapján számítódik.
     * A visszaadott lista sosem null. Ha egyetlen nemzet eredményei sem ismertek,
     * akkor üres listával tér vissza.
     *
     * A visszaadott lista módosításai semmilyen hatással sincsenek ennek a
     * Ranking objektumnak vagy a mögötte lévő Results objektumnak a belső állapotára.
     *
     * @return a nemzetek rangsora
     */
    List<String> getRanking();

    /**
     * Visszatér a rangsor szerinti első három helyezett nemzet nevével.
     * A visszaadott érték mindig friss, a háttérben elért Results objektum aktuális
     * állapota alapján számítódik.
     * Ha nincs három versenyző nemzet, akkor értelemszerűen
     * a legjobb 0, 1 vagy 2 nemzet rangsorával tér vissza.
     *
     * A visszaadott lista sosem null. Ha egyetlen nemzet eredményei sem ismertek,
     * akkor üres listával tér vissza.
     *
     * A visszaadott lista módosításai semmilyen hatással sincsenek ennek
     * a Ranking objektumnak vagy a mögötte lévő Results objektumnak a belső állapotára.
     *
     * @return a rangsor szerinti első három helyezett
     */
    List<String> getTop3();

    /**
     * A megadott nevű fájlba kiírja a rangsort. A kiírt érték mindig friss, a háttérben elért
     * Results objektum aktuális állapota alapján számítódik. A rangsor nemzeteit soronként,
     * csökkenő pontszám szerinti sorrendben írja ki, az alábbi formátumban:
     *
     *         nemzet: pontszám
     *
     *
     * Tehát ha Magyarország pontszáma 12, Kínáé 7, az USA-é pedig 9, akkor a következő a kimenet:
     *
     *         Magyarország: 12
     *         USA: 9
     *         Kína: 7
     *
     * @param filename a kimeneti fájl neve
     * @throws FileNotFoundException ha a megadott nevű fájl nem írható/létrehozható
     */
    void printRankingToFile(String filename) throws FileNotFoundException;
}