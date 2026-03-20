package Testes;

import Exercicios.Lista;
import Exercicios.Nodo;

public class Main {
    public static void main(String[] args) {
        int vetor[] = {14, 56, 12, 24};
        int vetor2[] = {25, 45, 32, 12};
        Lista lista = new Lista();
        Lista lista2 = new Lista();

        // ex6 -
        lista.criaListaEncadeada(vetor);
        lista.imprimeLista();

        System.out.println();

        Nodo primeiro = lista.getHead().prox;
        Nodo segundo = lista.getHead().prox.prox.prox;

        lista.trocarElementos(primeiro, segundo);
        lista.imprimeLista();
    }
}
