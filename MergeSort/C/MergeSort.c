//GitHub: HenriqueIni
//https://www.blogcyberini.com/

#include <stdio.h>
#include <stdlib.h>

static void merge(int A[], int inicio, int meio, int fim) {
    int tamEsq = meio - inicio + 1; //tamanho do subvetor esquerdo
    int tamDir = fim - meio; //tamanho do subvetor direito
    int esq[tamEsq]; //subvetor auxiliar esquerdo
    int dir[tamDir]; //subvetor auxiliar direito
    int idxEsq = 0; //índice do subvetor auxiliar esquerdo
    int idxDir = 0; //índice do subvetor auxiliar direito
    int i, j, k;
    
    //Copia os elementos do subvetor esquerdo para o vetor auxiliar
    for (i = 0; i < tamEsq; i++) {
        esq[i] = A[inicio + i];
    }
    //Copia os elementos do subvetor direito para o vetor auxiliar
    for (j = 0; j < tamDir; j++) {
        dir[j] = A[meio + 1 + j];
    }

    //intercala os vetores
    for (k = inicio; k <= fim; k++) {
        if (idxEsq < tamEsq) {
            if (idxDir < tamDir) {
                if (esq[idxEsq] < dir[idxDir]) {
                    A[k] = esq[idxEsq++];
                } else {
                    A[k] = dir[idxDir++];
                }
            } else {
                A[k] = esq[idxEsq++];
            }
        } else {
            A[k] = dir[idxDir++];
        }
    }
}

/*
 * Algoritmo de ordenação por intercação/fusão
 * 
 * Adaptado o livro "Algoritmos: teoria e prática" (Cormen et al)
 * 
 * 'A' é o vetor de inteiros que será ordenado, 'inicio' é o indice inicial
 * e 'fim' é o índice final
 * Melhor caso: O(n log n)
 * Caso médio: O(n log n)
 * Pior caso: O(n log n)
 */
void mergeSort(int A[], int inicio, int fim) {
    if (inicio < fim) {
        int meio = (inicio + fim) / 2; //calcula o meio
        mergeSort(A, inicio, meio); //ordena do subvetor esquerdo
        mergeSort(A, meio + 1, fim); //ordena do subvetor direito
        merge(A, inicio, meio, fim); //funde os subvetores esquerdo e direito
    }
}

int main() {
    //testa o merge sort para vetores inteiros
    int n = 10;
    int A[10] = {5, 2, 7, 6, 2, 1, 0, 3, 9, 4};
    printf("A (desordenado) = [%d, %d, %d, %d, %d, %d, %d, %d, %d, %d]\n",
            A[0], A[1], A[2], A[3], A[4], A[5], A[6], A[7], A[8], A[9]);
    mergeSort(A, 0, n - 1);
    printf("A (ordenado) = [%d, %d, %d, %d, %d, %d, %d, %d, %d, %d]\n",
            A[0], A[1], A[2], A[3], A[4], A[5], A[6], A[7], A[8], A[9]);
    return 0;
}
