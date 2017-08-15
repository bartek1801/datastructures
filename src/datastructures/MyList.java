package datastructures;

/**
 * Created by bartek on 16.07.2017.
 */
public interface MyList<E> extends Iterable<E> {

    // dodaje element na koniec listy
    void add(E e);

    // - usuwa z listy pierwsze wsytąpienie elementu e
    void remove(E e);

    // - zwraca długość listy
    int length();

     //- usuwa z listy element występujący na pozycji i (i >= 0, i<length())
    void remove(int i);

    //- zwraca pierwszy element listy
    E first();

    // - zwraca ostatni element listy
    E last();

    // - zwraca i-ty element listy
    E get(int i);

    //zwraca true jeśli element znajduje się na liście
    boolean contains (E element);

    //zwraca indeks zadanego elementu na liście lub -1 jeśli element nie istnieje
    int indexOf(E element);

    //usuwa wszystkie elemnty z listy
    void clear();

  /*  zwraca stringowe reprezentacje (element.toString()) elementów listy oddzielone przecinkami, np.
    MyList<String> l = new MyArrayList<>();
l.add("ala"); l.add("ma"); l.add("psa");
l.toString() // zwraca napis: "[ala, ma, psa]"*/
    String toString();

}
