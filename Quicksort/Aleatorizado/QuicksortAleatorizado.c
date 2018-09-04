//GitHub: HenriqueIni
//https://www.blogcyberini.com/

#include <stdio.h>
#include <stdlib.h>

//função auxiliar para realizar as trocas de elementos
void swap(int A[], int i, int j){
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
}
//algoritmo de partição
int partition(int A[], int inicio, int fim) {
    //esse gerador de números aleatório foi retirado de:
    //https://www.ime.usp.br/~pf/algoritmos/aulas/random.html
    
    //sorteia um índice aleatório entre inicio e fim
    int k;
    double d;
    //Observação: rand() é uma função fraca para gerar números aleatórios
    d = (double) rand () / ((double) RAND_MAX + 1);
    k = d * (fim - inicio + 1);
    int randomIndex = inicio + k;
    
    //coloca o pivô aleatório no fim para aplicar a partição de Cormen
    swap(A, randomIndex, fim);
        
    //*******************ALGORITMO DE PARTIÇÃO DE CORMEN*********************
    //o pivo é o elemento final
    int pivo = A[fim];
    int i = inicio - 1;
    int j;
    /*
     * Este laço irá varrer os vetores da esquerda para direira
     * procurando os elementos que são menores ou iguais ao pivô.
     * Esses elementos são colocados na partição esquerda.         
     */
    for (j = inicio; j <= fim - 1; j++) {
        if (A[j] <= pivo) {
            i = i + 1;
            swap(A, i, j);
        }
    }
    //coloca o pivô na posição de ordenação
    swap(A, i + 1, fim);
    return i + 1; //retorna a posição do pivô
}
//Quicksort de Cormen
void quicksortAleatorizado(int A[], int inicio, int fim) {
    if (inicio < fim) {
        //realiza a partição
        int q = partition(A, inicio, fim);
        //ordena a partição esquerda
        quicksortAleatorizado(A, inicio, q - 1);
        //ordena a partição direita
        quicksortAleatorizado(A, q + 1, fim);
    }
}
