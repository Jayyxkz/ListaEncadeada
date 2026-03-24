package Testes;

import Exercicios.Lista;

public class Main {
    public static void main(String[] args) {
        String[] vetorStr = {"Abacaxi", "Banana", "Maçã", "Apple"};
        String[] vetorStr2 = {"Caxi", "Nana", "Çã", "Pou"};
        Integer[] vetorInt = {56, 67, 67, 89, 21};
        Integer[] vetorInt2 = {28, 56, 67, 23, 14};

        Lista<String> listaStr = new Lista<>();
        Lista<String> listaStr2 = new Lista<>();
        Lista<Integer> listaInt = new Lista<>();
        Lista<Integer> listaInt2 = new Lista<>();

        listaStr.criaListaEncadeada(vetorStr);
        listaStr2.criaListaEncadeada(vetorStr2);
        listaInt.criaListaEncadeada(vetorInt);
        listaInt2.criaListaEncadeada(vetorInt2);

        // 7 -
        listaInt.maiorElemento();
    }
}
