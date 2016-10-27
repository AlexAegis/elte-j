*   Készítsünk egy `arrays.generic.MArray` nevű osztály, amely tetszőleges dimenziójú tömböt képes ábrázolni egyetlen egydimenziós tömb segítségével! A tömbben [`java.lang.Object`](http://docs.oracle.com/javase/8/docs/api/java/lang/Object.html) értékeket tároljunk el (agregáció), így ennek köszönhetően lényegében bármilyen típusúak lehetnek. A műveletei legyenek a következőek:

    *   konstruktor, amellyel meg lehet adni, hogy mennyi dimenziónban és azokban a tömbünk milyen kiterjedésű legyen,

    *   `set()`, amellyel be tudjuk állítani egy elem értéket az adott dimenziók szerinti pozícióban, nyilván csak akkor, ha a dimenziók száma, és azon belül a indexek megfelelőek,

    *   `get()`, amellyel le tudjuk kérdezni egy elem értékét, amennyiben a megadott pozíció dimenziója és azon belül az indexek megfelelőek, ellenkező esetben `null` referenciát adjunk vissza,

    *   `getDimensions()`, amely visszaadja, hogy mekkorák a tömb egyes dimenziói.