# elte-proglang-java

## ELTE Programozási Nyelvek 2 - 2016/2017-1

### Task 1

Hozzunk létre egy nemek ábrázolásához használt Gender nevű osztályt! Ebben szerepelje két osztályszintű konstans, amelyek rendre Gender.MALE (férfi) és Gender.FEMALE (nő).

### Task 2

Készítsünk Person névvel egy olyan osztályt, amelyben személyi adatokat tudunk eltárolni! A rögzíteni kívánt adatok: a személy vezeték- és keresztneve (mind a kettő String), neme (Gender), születési éve (int).

### Task 3

Legyen a Person osztálynak egy olyan statikus metódusa makePerson() névvel, amely ezeket az adatokat paraméterként bekéri és ezekből összeállít egy Person típusú objektumot!

A létrehozás előtt azonban ellenőrizzük, hogy minden megadott paraméter eleget tesz a személyi adatokra érvényes megszorításokra:

A vezeték- és keresztnév nem lehet üres, valamint legalább kétkarakteresnek kell lennie és nagybetűvel kell kezdődnie. Ezek kifejezéséhez nyugodtan használjuk a java.lang.String osztályt!

A születési évnek 1880 és 2016 között kell lennie.

Amennyiben a megadott paraméterek nem tesznek eleget a fenti megszorításoknak, úgy a metódus adjon vissza üres, vagyis null referenciát! (Vagyis ilyenkor objektum nem jön létre.)

### Task 4

Egészítsük ki a Person osztályt egy show() metódussal, amely String típusú értékké alakítja az adott objektum belső állapotát!

### Task 5

Adjunk a Person osztályhoz egy isAdult() metódust, amely egy boolean típusú értékkel tér vissza, és attól függően igaz (true) vagy hamis (false), hogy az illető személy 18 évesnél idősebb vagy sem!
