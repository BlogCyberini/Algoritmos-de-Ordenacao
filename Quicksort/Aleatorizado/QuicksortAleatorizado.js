//GitHub: HenriqueIni
//https://www.blogcyberini.com/

//método auxiliar: troca os elementos i e j em A
function swap(A, i, j) {
    var temp = A[i];
    A[i] = A[j];
    A[j] = temp;
}
function partition(A, inicio, fim) {
    //sorteia um índice aleatório entre inicio e fim
    var randomIndex = Math.floor(Math.random() * (fim - inicio + 1)) + inicio;
    
    //coloca o pivô aleatório no fim para aplicar a partição de Cormen
    swap(A, randomIndex, fim);
    
    //*******************ALGORITMO DE PARTIÇÃO DE CORMEN*********************
    //o pivo é o elemento final
    var pivo = A[fim];
    var i = inicio - 1;
    var j;
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
//Quicksort com pivô aleatório
function quicksortAleatorizado(A, inicio, fim) {
    if (inicio < fim) {
        //realiza a partição
        var q = partition(A, inicio, fim);
        //ordena a partição esquerda
        quicksortAleatorizado(A, inicio, q - 1);
        //ordena a partição direita
        quicksortAleatorizado(A, q + 1, fim);
    }
}
