//GitHub: HenriqueIni
//https://www.blogcyberini.com/

/* 
 * Ordena o vetor A utilizando o algoritmo de ordenação por inserção.
 *
 * Algoritmo adaptado o livro "Algoritmos: teoria e prática" (Cormen et al)
 *
 * Melhor caso (vetor ordenado): O(n)
 * Caso médio: O(n^2)
 * Pior caso: O(n^2)
 */
function insertionSort(A) {
    var i;
    for (i = 1; i < A.length; i++) {
        var elemento = A[i];
        var j = i - 1;
        while (j >= 0 && A[j] > elemento) {
            A[j + 1] = A[j]; //deslocamento para direita
            j = j - 1;
        }
        A[j + 1] = elemento; //insere o elemento na partição ordenada
    }
}
