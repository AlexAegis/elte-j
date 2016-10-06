- Írjunk egy `IntTree` osztályt, amely egy egész számokat rendezetten tároló bináris fát ábrázol! A bináris fa értékek olyan láncolata, ahol minden értéknek nulla, egy vagy két rákövetkezője lehet, és csak nulla vagy egy megelőzője. A láncolást `IntTree` objektumokra vonatkozó referenciákkal oldjuk meg, ezek fognak mutatni az adott fabeli csomópont bal- és jobb részfáira. Az csomópontokban ezenkívül még egy `int` értéket is eltárolunk. Ha nincs megelőző, akkor a fa gyökeréről beszélünk.

  Legyenek a következő műveleteink:

  - `insert()`, amely megkap egy `int` értéket és beilleszti a fába, annak értékétől függően. Ha a beszúrandó elem kisebb, a fa gyökerében található elemnél, akkor illesszük be a bal részfába (rekurzió). Ha nincs még bal részfánk, akkor hozzuk létre azzal az elemmel a gyökerében! Ugyanezt végezzük el a jobb részfára, ha a beszúrandó elem nagyobb, vagy egyenlő, mint a gyökérben levő!

  - `contains()`, amely eldönti, hogy a paramétereként megadott elem megtalálható-e a fában! Ezt egy logikai értékkel adja vissza: igaz, ha igen, hamis, ha nem! (Ez is rekurzív metódus lesz.)

  - egy olyan konstruktor, amely megkapja `int` értékek egy tömbjét és azokat beszúrja a fába.

  - egy olyan konstruktor, amely egy elemből létrehoz egy olyan fát, amelyben csak egyetlen gyökérelem van (és nincsenek rákövetkezői).

  - `toArray()`, amely egy `int` értékeket tartalmazó tömbben visszaadja azokat az értékeket, amelyeket a fában tárolunk! Ha szeretnénk kihasználni, hogy a beszúrást rendezetten végeztük, akkor érdemes ezt a tömböt úgy felépíteni, hogy először a bal részfa elemeit vesszük, aztán a gyökérben levő elemet, majd a jobb részfa elemeit. Az így összeállított tömb is rendezett lesz, ezt nevezik inorder bejárásnak. (Természetesen ez a metódus is rekurzív.)

  - `show`, amely megadja egy fa szöveges alakját. Itt most elegendő, ha csak a tárolt elemeket jelenítjük meg egy felsorolásban.

  - `equalsTo()`, amely eldönti az objektumról és a paraméteréről, hogy a kettő megegyezik-e. Két bináris fát akkor tekintsünk egyenlőnek, ha ugyanazokat az elemeket tartalmazzák!
