package championships.results.ranking;

public interface Medals extends Comparable<Medals> {

    /**
     * Visszaadja a megszerzett aranyérmek számát.
     * @return a szerzett aranyérmek száma
     */
    int getGolds();

    /**
     * Visszaadja a megszerzett ezüstérmek számát.
     * @return a szerzett ezüstérmek száma
     */
    int getSilvers();

    /**
     * Visszaadja a megszerzett bronzérmek számát.
     * @return a szerzett bronzérmek száma
     */
    int getBronzes();

    /**
     * Két Medals interfészt megvalósító objektum egyenlő, ha:
     * egyik sem null;
     * azonos típusúak (tehát nem kell azzal foglalkozni, hogy esetleg két különböző megvalósító
     * osztály példányait akarjuk összehasonlítani);
     * azonos rájuk nézve a szerzett aranyérmek, ezüstérmek és bronzérmek száma.
     * @param obj - az objektum, mellyel össze kell hasonlítanunk ezt a Medals példányt
     * @return igazat ad vissza, ha ez az objektum és a paraméter egyenlőek; egyébként hamisat
     */
    boolean equals(Object obj);

    /**
     * Két Medals példány között először az aranyérmek alapján kell különbséget tennünk.
     * @param obj - a másik objektum, amellyel ezt az objektumot össze kell hasonlítani
     * @return negatív szám, ha ez az objektum kisebb, mint a paraméter,
     * 0, ha egyenlőek, és
     * pozitív, ha ez az objektum nagyobb
     */
    int compareTo(Medals obj);

    /**
     * A Medals interfész megvalósításainak hashCode metódusa egy olyan hash értéket ad vissza,
     * mely csak a szerzett aranyérmek, ezüstérmek és bronzérmek számától függ.
     * @return egy hash érték ehhez az objektumhoz, mely csak a szerzett aranyérmek,
     * ezüstérmek és bronzérmek számától függ
     */
    int hashCode();

    /**
     * Egy Medals objektum szöveges reprezentációja a következő formátumú:
     * <aranyak, ezüstök, bronzok> Tehát ha 1 aranyat, 5 ezüstöt és 2 bronzot szereztünk, akkor: <1, 5, 2>
     * @return ennek az objektumnak egy szöveges reprezentációja
     */
    String toString();

}