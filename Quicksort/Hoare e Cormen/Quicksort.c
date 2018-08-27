//GitHub: HenriqueIni
//https://www.blogcyberini.com/

#include <stdio.h>
#include <stdlib.h>

//***********************FUNÇÕES AUXILIARES***********************
//função auxiliar para imprimir arrays
void printArray(int A[], int n) {
    printf("[%d", A[0]);
    int i;
    for (i = 1; i < n; i++) {
        printf(", %d",A[i]);
    }
    printf("]\n");
}

//função auxiliar para realizar as trocas de elementos
void swap(int A[], int i, int j){
    int temp = A[i];
    A[i] = A[j];
    A[j] = temp;
}
//***********************QUICKSORT DE HOARE******************************
//Partição de Hoare
int hoarePartition(int A[], int inicio, int fim) {
    //o pivo é o elemento inicial
    int pivo = A[inicio];
    //índice i irá percorrer o array da esquerda para a direita
    int i = inicio + 1;
    //índice j irá percorrer o array da direita para a esquerda
    int j = fim;

    //O loop irá parar quando os índices se ultrapassarem
    while (i <= j) {
        /*
         * Este laço irá parar quando encontrar algum elemento
         * à esquerda que é maior que o pivô, pois ele deveria estar na 
         * partição direita
         */
        while (i <= j && A[i] <= pivo) {
            i = i + 1;
        }
        /*
         * Esse laço irá parar quando encontrar algum elemento
         * à direira que é menor ou igual ao pivô, pois ele deveria estar na 
         * partição esquerda
         */
        while (i <= j && A[j] > pivo) {
            j = j - 1;
        }

        //se os índices não ultrapassarem, troca-os de posição
        if (i < j) {
            swap(A, i, j);
        }
    }
    //coloca o pivô na posição de ordenação
    swap(A, inicio, j);
    return j; //retorna a posição do pivô
}
//Quicksort de Hoare
void quicksortHoare(int A[], int inicio, int fim) {
    if (inicio < fim) {
        //realiza a partição
        int q = hoarePartition(A, inicio, fim);
        //ordena a partição esquerda
        quicksortHoare(A, inicio, q - 1);
        //ordena a partição direita
        quicksortHoare(A, q + 1, fim);
    }
}

//***********************QUICKSORT DE CORMEN******************************
//Partição de Cormen
int cormenPartition(int A[], int inicio, int fim) {
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
void quicksortCormen(int A[], int inicio, int fim) {
    if (inicio < fim) {
        //realiza a partição
        int q = cormenPartition(A, inicio, fim);
        //ordena a partição esquerda
        quicksortCormen(A, inicio, q - 1);
        //ordena a partição direita
        quicksortCormen(A, q + 1, fim);
    }
}
