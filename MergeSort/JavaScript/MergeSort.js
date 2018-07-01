//GitHub: HenriqueIni
//https://www.blogcyberini.com/
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
function mergeSort(A, inicio, fim) {
    if (inicio < fim) {
        //a função Math.floor é necessário para que o resultado seja inteiro
        var meio = Math.floor((inicio + fim) / 2); //calcula o meio
        mergeSort(A, inicio, meio); //ordena do subvetor esquerdo            
        mergeSort(A, meio + 1, fim); //ordena do subvetor direito            
        merge(A, inicio, meio, fim); //funde os subvetores esquerdo e direito            
    }
}

function merge(A, inicio, meio, fim) {
    var tamEsq = meio - inicio + 1; //tamanho do subvetor esquerdo
    var tamDir = fim - meio; //tamanho do subvetor direito
    var esq = []; //subvetor auxiliar esquerdo
    var dir = []; //subvetor auxiliar direito
    var idxEsq = 0; //índice do subvetor auxiliar esquerdo
    var idxDir = 0; //índice do subvetor auxiliar direito
    var i, j, k;
    
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
