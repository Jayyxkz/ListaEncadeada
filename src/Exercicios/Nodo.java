package Exercicios;

public class Nodo<T> {
    T item;
    Nodo<T> prox;

    public Nodo(T item) {
        this.item = item;
    }
}