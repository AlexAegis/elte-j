
*   Készítsünk egy olyan programot, amely a szabványos bemenetről be tudja olvasni különböző fajta alakzatok adatait, majd azokat eltárolni! Mivel nem tudjuk előre pontosan, hogy mennyi alakzattal kapcsolatban akarunk majd adatokat rögzíteni, ezért célszerű azokat egy [`java.util.ArrayList`](http://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html) típusú objektumba tenni.

    A beolvasást addig folytatjuk, amíg a bemenet tart ("EOF, az "End of File" jelzést nem kapunk), vagy amíg nem kapunk egy `"quit"` üzenetet.

    A másik ilyen parancsunk legyen az `"add"`, amely után zárójelek között megadjuk, hogy milyen alakzatot, milyen paraméterekkel akarunk felvenni. Az alakzataink rendre:

    *   `"rectangle"`: `Rectangle` típusú objektum, vagyis egy téglalap létrehozása a bal felső pont x és y koordinátájával, valamint az x és y irányú oldalhosszok megadásával,

    *   `"square"`: `Square` típusú objektum, vagyis négyzet lébrehozása a bal felső pont x és y koordinátáival, valamint az oldalhossz megadásával,

    *   `"ellipse"`: `Ellipse` típusú objektum, vagyis ellipszis létrehozása a középpont x és y koordinátáival, valamint a nagytengely és a kistengely megadásával,

    *   `"circle"`: `Circle` típusú objektum, vagyis kör létrehozása a középpont x és y koordinátánaik, valamint a sugár megadásával.

    Miután befejeztük a beolvasást, a szabványos kimeneten jelenítsük meg az összes beolvasott értéket (a saját `toString()` metódusán keresztül)!
