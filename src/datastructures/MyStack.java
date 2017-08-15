package datastructures;

/**
 * Created by bartek on 26.07.2017.
 */
public interface MyStack<T> {
    // odkłada na szczyt stosu element t
    void push(T t);

    // zdjemuje ze szczytu stosu element i zwraca go, zwraca null jeśli stos pusty
    T pop();

    // zwraca informację czy są jakieś el. na stosie
    boolean empty();
}
