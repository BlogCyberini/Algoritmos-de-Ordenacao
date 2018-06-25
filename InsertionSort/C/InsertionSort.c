//GitHub: HenriqueIni
//https://www.blogcyberini.com/
#include <stdio.h>
#include <stdlib.h>

/*
 * Algoritmo de ordenação por inserção
 * 
 * Adaptado o livro "Algoritmos: teoria e prática" (Cormen et al)
 * 
 * A é o vetor que será ordenado e n é o tamanho do vetor
 * Melhor caso (vetor ordenado): O(n)
 * Caso médio: O(n^2)
 * Pior caso: O(n^2)
 */
void insertionSort(int n, int A[n]){
    int i;
    for(i = 1; i < n; i++){
        int elemento = A[i];
        int j = i - 1;
        while(j >= 0 && A[j] > elemento){
            A[j + 1] = A[j]; //deslocamento para direita
            j = j - 1;
        }
        A[j + 1] = elemento; //insere o elemento na partição ordenada
    }
}
//código de testes
int main() {
    int A[6] = {3, 1, 9, 5, 2, 8};
    int i;
    insertionSort(6, A);
    printf("[%d", A[0]);
    for(i = 1; i < 6; i++){
       printf(", %d", A[i]);
    }
    printf("]\n");
    return 0;
}
