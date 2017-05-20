package championships.results;


import championships.results.ranking.Medals;
import championships.results.ranking.Ranking;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Ennek az interfésznek a megvalósításai a világbajnokság eredményeit tárolják.
 * Az eredmények versenyszámonként külön ismertek, minden versenyszámról tudjuk, hogy
 * az egyes résztvevők hányadik helyezést érték el rajta. Elképzelhető, hogy egyes
 * helyezések megszerzői ismeretlenek (például tudjuk, ki lett az első, és hogy
 * ki lett a harmadik, de azt nem, hogy ki lett a második). Ellenben az biztos, hogy
 * ugyanazt a helyezést ugyanabban a versenyszámban csak egy résztvevő szerezte
 * meg (tehát feltesszük, hogy sehol sincs döntetlen, és mindenhol egyértelműen rangsort
 * állítanak az összes résztvevő között).
 */
public interface Results {

    List<String> results = new ArrayList<>();

    /**
     * Az eddig ismert versenyeredményekhez hozzáad egy új eredményt.
     * A megadott helyezést a megadott versenyszámban a megadott nevű résztvevő és megadott
     * nemzetiségű résztvevő érte el.
     * Hibás paraméterek esetén IllegalArgumentException kivételt dob (lásd throws dokumentációs megjegyzés).
     *
     * @param event az érintett versenyszám
     * @param name az érintett résztvevő neve
     * @param nation az érintett résztvevő nemzete
     * @param place a résztvevő az adott számban hányadik helyezést ért el
     * @throws IllegalArgumentException ha az event értéke null vagy üres String;
     *          vagy ha a name értéke null vagy üres String;
     *          vagy ha a nation értéke null vagy üres String;
     *          vagy ha a place nem pozitív;
     *          vagy ha az adott versenyszám adott helyezéséről már tudjuk, hogy ki szerezte meg
     */
    void addResult(String event, String name, String nation, int place) throws IllegalArgumentException;

    /**
     * Az eddig ismert versenyeredményekhez hozzáad egy új eredményt.
     * A megadott helyezést a megadott versenyszámban a megadott résztvevő érte el.
     * Hibás paraméterek esetén IllegalArgumentException kivételt dob (lásd throws dokumentációs megjegyzés).
     *
     * @param event az érintett versenyszám
     * @param participant az érintett résztvevő
     * @param place a résztvevő az adott számban hányadik helyezést ért el
     * @throws IllegalArgumentException ha az event értéke null vagy üres String;
     *          vagy ha a participant értéke null;
     *          vagy ha a place nem pozitív;
     *          vagy ha az adott versenyszám adott helyezéséről már tudjuk, hogy ki szerezte meg
     */
    void addResult(String event, Participant participant, int place) throws IllegalArgumentException;

    /**
     * Visszaadja a helyezettek listáját egy adott versenyszámhoz.
     * A lista i. indexű eleme a versenyszámban (i+1). helyezést elért résztvevő.
     * Ha a versenyszámban egy adott helyezésről nem tudjuk, hogy melyik résztvevő szerezte meg,
     * akkor annál a helyezésnél a listában null szerepel. Az utolsó elem a listában biztosan
     * nem null, tehát pontosan annyi eleme van a listának, ahányadik az utolsó helyezés,
     * melyről tudjuk, hogy ki szerezte meg az adott versenyszámban.
     * A visszaadott lista sosem null. Ha eddig még egyetlen eredmény sem ismert az adott
     * versenyszámhoz, akkor üres listával tér vissza.
     *
     * A visszaadott lista módosításai semmilyen hatással sincsenek
     * ennek a Results objektumnak a belső állapotára.
     *
     * Megjegyzés: tehát a lista nulladik eleme az első helyezett,
     * az első eleme a második helyezett, stb., mivel nullától indexelünk.
     *
     * @param event az érintett versenyszám
     * @return a helyezettek listája, helyezésük sorrendjében
     */
    List<Participant> getResultsOf(String event);

    /**
     * Visszaadja az összes eredményt versenyszámonként. A visszatérési értékként átadott Map
     * kulcsai az ismert versenyszámok nevei, a kulcsokhoz rendelt értékek pedig a helyezettek
     * listái, ugyanabban a formátumban, ahogy a getResultsOf metódus visszaadja.
     * A visszaadott map és a benne tárolt listák módosításai semmilyen hatással sincsenek
     * ennek a Results objektumnak a belső állapotára.
     *
     * Megjegyzés:
     *
     *         String event = ...
     *         Results result = ...
     *         List <Swimmer> list1 = results.getResultsOf(event);
     *         List <Swimmer> list2 = results.getResultsOfAll().get(event);
     *
     * Ebben az esetben a két lista egyenlő kell, hogy legyen, tehát ugyanazokat az
     * elemeket kell tárolniuk, ugyanolyan sorrendben.
     *
     * @return az összes eredmény versenyszámonként
     */
    Map<String,List<Participant>> getResultsOfAll();

    /**
     * Visszatér egy rangsor nézetével erre az eredménylistára, mely a nemzeteket az összes
     * szerzett érem (első, második és harmadik helyezés) alapján hasonlítja össze, tehát az
     * összességében több érmet szerzett nemzet kell, hogy a rangsorban előrébb szerepeljen.
     * Azonos éremszám esetén tetszőleges a sorrend.
     * Tehát minden nemzethez a rangsort adó "pontjait" egy egész érték fogja meghatározni:
     * az összes szerzett érmek száma. Az a nemzet, akihez tartozó pontszám nagyobb, az fog
     * előrébb szerepelni a listában.
     *
     * A visszaadott rangsor csak egy nézet: ha új eredményeket veszünk fel ebbe az
     * eredménylistába, akkor azok is látszani fognak a visszaadott rangsor számításaiban.
     * Tehát mikor a rangsort kiértékeljük pl. a getPointsOf metódussal, az mindig ebből az
     * eredménylistából veszi az éppen aktuális adatokat, és nem a rangsor létrehozásakor
     * lemásolt értékeket mutatja.
     *
     * Példa:
     *
     *         Results results = Factory.createResults();
     *         Ranking <Integer> ranking = results.rankNationsByTotalMedals();
     *         results.addResult("gyors 50m", "x", "Magyarország", 1);
     *         results.addResult("gyors 50m", "y", "USA", 2);
     *         results.addResult("gyors 50m", "z", "USA", 3);
     *         System.out.println(ranking.getPointsOf("Magyarország")); // 1
     *         System.out.println(ranking.getPointsOf("USA")); // 2
     *         System.out.println(ranking.getRanking()); // [USA, Magyarország]
     *
     * Tipp: a metódus visszatérhet egy olyan osztály példányával, mely osztály kimondottan
     * az összes éremszám alapú összehasonlításra alkalmas.
     *
     * @return egy nemzetek közti rangsor, mely az összes szerzett érem alapján teszi sorba az országokat
     */
    Ranking<Integer> rankNationsByTotalMedals();

    /**
     * Visszatér egy rangsor nézetével erre az eredménylistára, mely a nemzeteket először
     * a szerzett arany-, majd az ezüst-, végül a bronzérmeik alapján hasonlítja össze.
     * Tehát az a nemzet szerepel előrébb a rangsorban, amelyik több aranyat szerzett, vagy
     * ugyanannyi aranyat, de több ezüstöt, vagy ugyanannyi aranyat és ezüstöt, de több bronzt szerzett.
     * Azonos éremszám esetén tetszőleges a sorrend.
     * Tehát minden nemzethez a rangsort adó "pontjait" egy Medals objektum fogja meghatározni.
     * Az a nemzet, akihez tartozó Medals objektum nagyobb a Medals-on deklarált természetes
     * rendezés (lásd Comparable interfész) szerint, az fog előrébb szerepelni a listában.
     *
     * A visszaadott rangsor csak egy nézet: ha új eredményeket veszünk fel ebbe az
     * eredménylistába, akkor azok is látszani fognak a visszaadott rangsor számításaiban.
     * Tehát mikor a rangsort kiértékeljük pl. a getPointsOf metódussal, az mindig ebből az
     * eredménylistából veszi az éppen aktuális adatokat, és nem a rangsor létrehozásakor
     * lemásolt értékeket mutatja.
     *
     * Példa:
     *
     *        Results results = Factory.createResults();
     *        Ranking <Medals> ranking = results.rankNationsByGoldFirst();
     *        results.addResult("gyors 50m", "x", "Magyarország", 1);
     *        results.addResult("gyors 50m", "y", "USA", 2);
     *        results.addResult("gyors 50m", "z", "USA", 3);
     *        System.out.println(ranking.getPointsOf("Magyarország")); //  <1, 0, 0>
     *        System.out.println(ranking.getPointsOf("USA")); //  <0, 1, 1>
     *        System.out.println(ranking.getRanking()); // [Magyarország, USA]
     *
     * Tipp: a metódus visszatérhet egy olyan osztály példányával, mely osztály kimondottan a
     * különböző éremszámok alapján vett összehasonlításra alkalmas.
     *
     * @return egy nemzetek közti rangsor, mely az összes szerzett érem alapján teszi sorba az országokat
     */
    Ranking<Medals> rankNationsByGoldFirst();

    /**
     * A megadott nevű fájlból beolvassa az abban tárolt eredményeket.
     * Az eredményeket a fájl soronként tárolja, minden sor formátuma:
     *
     *         versenyszám;résztvevő;nemzetiség;helyezés
     *
     * Az első három elem egy-egy nemére String, a negyedik egy pozitív egész.
     * Ha ezeknek a feltételeknek egy vagy több sor nem felel meg, azokat a sorokat a beolvasás kihagyja.
     *
     * @param filename a beolvasandó fájl neve
     * @throws FileNotFoundException ha a megadott nevű fájl nem található
     */
    void readFromFile(String filename) throws FileNotFoundException;

}