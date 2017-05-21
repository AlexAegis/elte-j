package championships.results;

/**
 * A világbajnokság egy résztvevőjét ennek az interfésznek a megvalósításai ábrázolják.
 * Egy résztvevőt alapvetően a neve és a nemzetisége határoz meg, ezek
 * mindegyike egy String, és egyik sem lehet null vagy 0 hosszúságú (üres) String.
 *
 * Tipp: nem megfelelő nevű és/vagy nem megfelelő nemzetiségű résztvevőt eleve nem szabad létrehoznunk.
 */
public interface Participant {

    /**
     * Visszaadja ennek a résztvevőnek a nevét.
     * A név biztosan nem lehet null vagy egy 0 hosszúságú (üres) String.
     *
     * @return a résztvevő neve
     */
    String getName();

    /**
     * Visszaadja ennek a résztvevőnek a nemzetiségét.
     * A nemzetiség biztosan nem lehet null vagy egy 0 hosszúságú (üres) String.
     *
     * @return a résztvevő nemzetisége
     */
    String getNation();
}