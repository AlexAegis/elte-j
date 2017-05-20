package championships.results;

import championships.competitions.Swimming;

/**
 * Ez az osztály a rendszer belépési pontja. Nem példányosítható, egyetlen célja, hogy
 * a createResults() osztályszintű metódusa segítségével példányosítható legyen a Results interfész.
 */
public final class Factory {

    /**
     * Konstruktor privátra állítva, hogy megelőzzük az osztály példányosítását
     */
    private Factory() {

    }

    /**
     * Visszaad egy új objektumot, mely megvalósítja a Results interfészt.
     * Tipp: érdemes a Results interfésznek egy megvalósító osztályt készíteni, és
     * ebben a metódusban azt egyszerűen példányosítani, és az új példányt visszaadni.
     *
     * @return egy új objektum, mely megvalósítja a Results interfészt
     */
    public static Results createResults() {
        return new Swimming();
    }

}