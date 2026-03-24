package Exercicios;

public class Lista<T> {
    private Nodo<T> head;
    private Nodo<T> ultimo;
    private int tamanho = 0;

    public Lista() {
        this.head = null;
        this.ultimo = null;
    }

    // 1 - Escreva um metodo que crie uma lista encadeada a partir de um vetor
    public void criaListaEncadeada(T[] vetor) {
        for (T item : vetor) {
            this.inserirFim(item);
        }
    }

    // 2 - Escreva um metodo que copie uma lista encadeada para um vetor
    public Object[] listaParaVetor() {
        this.erroSeVazia();

        Object[] vetor = new Object[tamanho];

        Nodo<T> aux = head;
        int i = 0;

        while (aux != null) {
            vetor[i] = aux.item;
            aux = aux.prox;
            i++;
        }
        return vetor;
    }

    // 3 - Faça um metodo para concatenar duas listas
    public Lista<T> concatenarListas(Lista<T> lista2) {
        lista2.erroSeVazia();

        Lista<T> c = new Lista<>();
        Nodo<T> aux = this.head;
        Nodo<T> aux2 = lista2.getHead();

        while (aux != null) {
            c.inserirFim(aux.item);
            aux = aux.prox;
        }
        while (aux2 != null) {
            c.inserirFim(aux2.item);
            aux2 = aux2.prox;
        }
        return c;
    }

    // 4 - Faça um metodo para remover os n primeiros elementos de uma lista, retornar se é possível ou não
    public void removerElementos(int n) {
        this.erroSeVazia();

        if (n > this.tamanho) {
            System.out.println("Não existem N elementos");
            return;
        }

        for (int i = 0; i < n; i++) {
            this.head = this.head.prox;
        }

        System.out.println(n + " elementos removidos!");
    }

    // 5 - Faça um metodo para buscar a posição e o valor do maior elemento da lista, retornar se possível ou não
    public void maiorElemento() {
        this.erroSeVazia();

        Nodo<T> aux = head;
        int contMaior = 0;
        int pos = 1;
        int posMaior = 1;
        int maior = 0;

        while (aux.prox != null) {
            if ((int) aux.item > maior) {
                maior = (int) aux.item;
                contMaior = 1;
                posMaior = pos;
            }
            else if ((int) aux.item == maior) {
                contMaior++;
            }
            pos++;
            aux = aux.prox;
        }

        if (contMaior > 1){
            System.out.println("Maior elemento repetido!");
        }
        else {
            System.out.println("Posição: " + posMaior + ", Maior elemento: " + maior);
        }
    }

    // 6 - Faça um metodo para trocar de posição dois elementos de uma lista, retornar se possivel ou não
    public void trocarElementos(T item1, T item2) {

        Nodo<T> aux = this.head;
        Nodo<T> N1 = null;
        Nodo<T> N2 = null;

        while (aux != null) {
            if (item1.equals(aux.item)) {
                N1 = aux;
            }
            else if (item2.equals(aux.item)) {
                N2 = aux;
            }
            aux = aux.prox;
        }

        if (N1 == null || N2 == null) {
            throw new RuntimeException("Não encontrados!");
        }

        Nodo<T> ant1 = null;
        Nodo<T> prox1 = N1.prox;
        Nodo<T> ant2 = null;
        Nodo<T> prox2 = N2.prox;

        aux = this.head;

        while (aux != null) {
            if (aux.prox == N1) {
                ant1 = aux;
            }
            if (aux.prox == N2) {
                ant2 = aux;
            }
            aux = aux.prox;
        }

        // Casos
        if (N1.prox == N2) {
            if (ant1 != null) {
                ant1.prox = N2;
            } else {
                head = N2;
            }
            N1.prox = N2.prox;
            N2.prox = N1;
        }
        else if (N2.prox == N1) {
            if (ant2 != null) {
                ant2.prox = N1;
            }
            else {
                head = N1;
            }
            N2.prox = N1.prox;
            N1.prox = N2;
        }
        else {
            if (ant1 != null) {
                ant1.prox = N2;
            }
            else {
                head = N2;
            }

            if (ant2 != null) {
                ant2.prox = N1;
            }
            else {
                head = N1;
            }

            N1.prox = prox2;
            N2.prox = prox1;
        }
    }

    // 7 - Considere uma lista contendo numeros positivos, retorne uma nova lista apenas com os pares
    public Lista<T> listaComPares() {
        this.erroSeVazia();

        Lista<T> l = new Lista<>();
        Nodo<T> aux = head;

        while(aux != null) {
            if ((int) aux.item % 2 == 0) {
                l.inserirFim(aux.item);
            }
            aux = aux.prox;
        }
        return l;
    }

    // 8 - Considere uma lista contendo numeros positivos, retorne a media da lista
    public int mediaDaLista() {
        this.erroSeVazia();

        int soma = 0, qntdElementos = 0;
        Nodo aux = head.prox;

        while(aux != null) {
            soma += (int) aux.item;
            qntdElementos++;
            aux = aux.prox;
        }
        return soma / qntdElementos;
    }

    // 9 - Faça um metodo pra verificar se uma lista está ordenada(crescente ou descrescente)
    public void listaOrdenada() {
        this.erroSeVazia();

        Nodo aux = head.prox;
        boolean crescente = true, decrescente = true;

        while (aux.prox != null) {
            if ((int) aux.item > (int) aux.prox.item) {
                crescente = false;
            }
            if ((int) aux.item < (int) aux.prox.item) {
                decrescente = false;
            }
            aux = aux.prox;
        }

        if (crescente) {
            System.out.println("Está Ordenada (crescente)!");
        } else if (decrescente) {
            System.out.println("Está Ordenada (decrescente)!");
        } else {
            System.out.println("Não está ordenada!");
        }
    }

    // 10 - Faça um metodo que copia uma lista L1 em outra lista L2
    public Lista copiarLista(Lista l1) {
        l1.erroSeVazia();

        Lista l2 = new Lista();
        Nodo aux = l1.head.prox;

        while (aux != null) {
            Nodo novo = new Nodo(aux.item);

            l2.setTamanho(l2.getTamanho() + 1);
            l2.getUltimo().prox = novo;
            l2.setUltimo(novo);
            aux = aux.prox;
        }
        return l2;
    }

    // 11 - Fazer um metodo que copia elementos L1 para L2, removendo repetidos
    public Lista removeRepetidos() {
        this.erroSeVazia();

        Lista l = new Lista();
        Nodo auxL = head.prox;

        while (auxL != null) {
            Nodo novo = new Nodo(auxL.item);

            l.setTamanho(l.getTamanho() + 1);
            l.getUltimo().prox = novo;
            l.setUltimo(novo);
            auxL = auxL.prox;
        }

        Nodo atual = l.getHead().prox;

        while (atual != null) {
            Nodo anterior = atual;
            Nodo aux = atual.prox;

            while (aux != null) {
                if (atual.item.equals(aux.item)) {
                    anterior.prox = aux.prox;
                    l.setTamanho(l.getTamanho() - 1);
                } else {
                    anterior = aux;
                }
                aux = aux.prox;
            }
            atual = atual.prox;
        }
        return l;
    }

    // 12 - Fazer um metodo para inverter uma lista L1 colocando resultado em L2
    public Lista inverterLista() {
        this.erroSeVazia();

        Lista l = new Lista();
        Nodo aux = head.prox;

        while (aux != null) {
            Nodo novo = new Nodo(aux.item);
            l.setTamanho(l.getTamanho() + 1);
            novo.prox = l.getHead().prox;
            l.getHead().prox = novo;
            if (l.getUltimo() == l.getHead()) {
                l.setUltimo(novo);
            }
            aux = aux.prox;
        }
        return l;
    }

    // 16 - Escreva um metodo que inverte a ordem das células de uma lista encadeada, altere os ponteiros
    public void inverteNodos() {
        this.erroSeVazia();

        Nodo anterior = null;
        Nodo atual = head.prox;

        while (atual != null) {
            Nodo proximo = atual.prox;
            atual.prox = anterior;

            anterior = atual;
            atual = proximo;
        }
        head.prox = anterior;
    }

    // 17 - Dadas duas listas L1 e L2, implemente o metodo união, que cria uma terceira lista L3
    public Lista uniaoListas(Lista l1, Lista l2) {
        Lista l3 = new Lista();
        Nodo aux = l1.head.prox;

        while (aux != null) {
            Nodo novo = new Nodo(aux.item);
            l3.setTamanho(l3.getTamanho() + 1);
            l3.getUltimo().prox = novo;
            l3.setUltimo(novo);
            aux = aux.prox;
        }

        Nodo aux2 = l2.getHead().prox;

        while (aux2 != null) {
            Nodo novo = new Nodo(aux2.item);
            if (!l3.contem(novo.item)) {
                l3.setTamanho(l3.getTamanho() + 1);
                l3.getUltimo().prox = novo;
                l3.setUltimo(novo);
            }
            aux2 = aux2.prox;
        }
        return l3;
    }

    // 26 - Faça um metodo para intercalar listas: O metodo recebe duas listas e retorna L3 ordenada
    public Lista intercalarListas(Lista l1, Lista l2) {
        Lista l3 = new Lista();
        Nodo aux = l1.head.prox;
        Nodo aux2 = l2.head.prox;

        while (aux != null || aux2 != null) {
            if (aux == null) {
                l3.inserirFim(aux2.item);
                aux2 = aux2.prox;
            }
            else if (aux2 == null) {
                l3.inserirFim(aux.item);
                aux = aux.prox;
            }
            else if ((int) aux.item <= (int) aux2.item) {
                l3.inserirFim(aux.item);
                aux = aux.prox;
            }
            else {
                l3.inserirFim(aux2.item);
                aux2 = aux2.prox;
            }
        }
        return l3;
    }

    // 36 - Suponha que uma string de caracteres seja representada por uma lista de caracteres
    //individuais. Escreva um conjunto de métodos para manipular estas listas como segue (list1 e list2
    //são ponteiros para um nó de cabeçalho de uma lista representando uma string de caracteres e str é
    //um vetor de caracteres):

    // a - strcreate(str) para converter a string de caracteres (str) em uma lista ligada, onde cada
    //caractere ocupa um nodo da lista ligada. Esse metodo retorna um ponteiro para um nó de
    //cabeçalho;
    public Nodo strcreate(String str) {
        char[] chars = str.toCharArray();

        for (char c : chars) {
            Nodo novo = new Nodo(c);
            tamanho++;
            this.ultimo.prox = novo;
            this.ultimo = novo;
        }
        return head.prox;
    }

    // b - strcnvlc(list, str) para converter uma lista em uma string de caracteres;
    public String strcnvlc() {
        String str = "";
        Nodo aux = head.prox;

        while (aux != null) {
            str += aux.item;
            aux = aux.prox;
        }
        return str;
    }

    // c - strvrfyl(l1, 12) para determinar a primeira posição da string representada por l1 que não
    //esteja contida na string representada por l2. Esse metodo retorna um inteiro;
    public int strvrfyl(Lista l1, Lista l2) {
        int pos = 1;
        Nodo aux = l1.head.prox;
        Nodo aux2 = l2.head.prox;

        while (aux != null && aux2 != null) {
            if (!aux.item.equals(aux2.item)) {
                return pos;
            }
            aux = aux.prox;
            aux2 = aux2.prox;
            pos++;
        }
        return pos;
    }

    // d - strsbstr(l1, il, i2) para determinar uma substring da string de caracteres, representada pela
    //lista l1 e pelos inteiros i1 e i2. Esse metodo retorna um ponteiro para o nó de cabeçalho de
    //uma lista representando uma string de caracteres, que é a substring desejada. A lista 11
    //permanece inalterada
    public String strsbstr(Lista l1, int i1, int i2) {
        String substr = "";
        Nodo aux = l1.head.prox;
        int pos = 1;

        while (aux != null) {
            if (pos >= i1 && pos <= i2) {
                substr += aux.item;
            }
            aux = aux.prox;
            pos++;
        }
        return substr;
    }

    // e - trpsblill(l1, i1, i2, l2) para fazer a substituição dos elementos i1 por i2 na lista l1. Os
    //elementos da lista l2 devem substituir o i1 elemento da lista l1 pelo elemento i1 na lista l1. A
    //lista l1 deve permanecer inalterada;
    public Lista trpsblill(Lista l1, int i1, int i2, Lista l2) {
        Lista l3 = new Lista();
        Nodo aux = l1.head.prox;
        Nodo aux2 = l2.head.prox;
        int pos = 1;

        while (aux != null) {
            while (pos >= i1 && pos <= i2) {
                l3.inserirFim(aux2.item);
                if (aux2.prox == null) {
                    aux = aux.prox;
                    pos++;
                    break;
                }
                aux2 = aux2.prox;
                aux = aux.prox;
                pos++;
            }
            l3.inserirFim(aux.item);
            aux = aux.prox;
            pos++;
        }
        return l3;
    }

    // f - strcmpl(l1, l2) para comparar duas strings de caracteres, representadas por listas. Essa
    //função retorna:
    //a. -1 se a string de caracteres representada por l1 é menor que a string representada por l2;
    //b. 0 se são iguais, e
    //c. 1 se a string representada por l1 é maior.
    public int strcmpl(Lista l1, Lista l2) {
        Nodo aux = l1.head.prox;
        Nodo aux2 = l2.head.prox;
        int tamanhol1 = 0;
        int tamanhol2 = 0;

        while (true) {
            if(aux.prox != null) {
                tamanhol1++;
                aux = aux.prox;
            }

            if(aux2.prox != null) {
                tamanhol2++;
                aux2 = aux2.prox;
            }

            if(aux.prox == null && aux2.prox == null) {
                return 0;
            }

            if(tamanhol1 < tamanhol2) {
                return -1;
            } else  if (tamanhol1 > tamanhol2) {
                return 1;
            }
        }
    }

    // Metodos auxiliares
    public boolean contem(Object item) {
        Nodo<T> aux = head.prox;
        while (aux != null) {
            if (item.equals(aux.item)) {
                return true;
            }
            aux = aux.prox;
        }
        return false;
    }

    public void inserirFim(T item) {

        Nodo<T> novo = new Nodo<T>(item);

        if (this.head == null) {
            this.head = novo;
            this.ultimo = this.head;
        }
        else {
            this.ultimo.prox = novo;
            this.ultimo = novo;
        }
        this.tamanho++;
    }

    public boolean vazia() {
        return ultimo == null;
    }

    public void erroSeVazia() {
        if(this.vazia()) {throw new RuntimeException("Lista vazia");};
    }

    public void imprimeLista() {

        Nodo<T> aux = head;

        while (aux != null) {
            System.out.print(aux.item + " ");
            aux = aux.prox;
        }
    }

    public int getTamanho() {
        return tamanho;
    }
    public Nodo<T> getHead() {
        return head;
    }
    public Nodo<T> getUltimo() {
        return ultimo;
    }
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    public void setHead(Nodo<T> head) {
        this.head = head;
    }
    public void setUltimo(Nodo<T> ultimo) {
        this.ultimo = ultimo;
    }
}