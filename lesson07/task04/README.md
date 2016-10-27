*   Az `arrays.generic.MArray` felhasználásával (kompozíció) valósítsunk meg egy `arrays.DoubleMatrix` osztályt, amely `Double` típussal valós számokat tárol egy mátrixban! Az osztálynak legyenek a következő műveletei:

    *   konstruktor, amely megadja, hogy az egyes dimenziókban mekkora a mátrix kiterjedése,

    *   `set()`, amellyel be tudunk állítani értéket az adott pozícióban,

    *   `get()`, amellyel le tudjuk kérdezni az adott pozíción található értéket,

    Érvénytelen indexek (vagyis amikor olyan értéket adunk meg, amelyek már nem a mátrix egy elemét címzik) esetén ne változtassuk meg a mátrixot! A `get()` esetén pedig `Double` (csomagoló) objektumokat adjunk vissza, így a `null` referenciával tudjuk jelezni, ha érvénytelen pozícióról nem kérdezhető le elem.

    Fontos, hogy a felhasználó számára ne legyen látható, hogy az `arrays.generic.MArray` segítségével valósítottuk meg ezt a típust!