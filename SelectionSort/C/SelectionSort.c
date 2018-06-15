//GitHub: HenriqueIni
//https://www.blogcyberini.com/

//Algoritmo de ordenação por seleção
#include <stdio.h>
#include <stdlib.h>

//Retorna o índice do menor valor do vetor a entre os índices i e j
int min(int a[], int i, int j) {
    int minIndex = i;
    int k;
    for (k = i + 1; k <= j; k++) {
        if (a[minIndex] > a[k]) {
            minIndex = k;
        }
    }
    return minIndex;
}

//Troca os elementos das posições i e j de posição entre eles.
void trocar(int a[], int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
}


//Ordena um vetor utilizando o Selection Sort O(n^2)
void selectionSort(int n, int a[]) {
    int i;
    for (i = 0; i < n - 1; i++) {
        int minIndex = min(a, i, n - 1);
        trocar(a, i, minIndex);
    }
}

//Versão 'linguiça' do Selection Sort (todo código num único módulo)
void selectionSortSausage(int n, int a[]) {
    int i;
    for (i = 0; i < n - 1; i++) {
        int minIndex = i;
        int k;
        for (k = i + 1; k < n; k++) {
            if (a[minIndex] > a[k]) {
                minIndex = k;
            }
        }
        int temp = a[i];
        a[i] = a[minIndex];
        a[minIndex] = temp;
    }
}

//código de testes
int main() {
    int A[5] = {40, 9, 4, -1, 6};
    int B[5] = {4, 9, 3, 1, 6};

    printf("Vetores desordenados\n");
    printf("A = [%d, %d, %d, %d, %d]\n", A[0], A[1], A[2], A[3], A[4]);
    printf("B = [%d, %d, %d, %d, %d]\n", B[0], B[1], B[2], B[3], B[4]);

    selectionSort(5, A);
    selectionSortSausage(5, B);

    printf("Vetores ordenados\n");
    printf("A = [%d, %d, %d, %d, %d]\n", A[0], A[1], A[2], A[3], A[4]);
    printf("B = [%d, %d, %d, %d, %d]\n", B[0], B[1], B[2], B[3], B[4]);
    return 0;
}
