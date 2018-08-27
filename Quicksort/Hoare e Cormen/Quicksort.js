//GitHub: HenriqueIni
//https://www.blogcyberini.com/

//método auxiliar: troca os elementos i e j em A
function swap(A, i, j) {
    var temp = A[i];
    A[i] = A[j];
    A[j] = temp;
}
//***********************QUICKSORT DE HOARE******************************
//Quicksort de Hoare
function quicksortHoare(A, inicio, fim) {
    if (inicio < fim) {
        //realiza a partição
        var q = hoarePartition(A, inicio, fim);
        //ordena a partição esquerda
        quicksortHoare(A, inicio, q - 1);
        //ordena a partição direita
        quicksortHoare(A, q + 1, fim);
    }
}

function hoarePartition(A, inicio, fim) {
    //o pivo é o elemento inicial
    var pivo = A[inicio];
    //índice i irá percorrer o array da esquerda para a direita
    var i = inicio + 1;
    //índice j irá percorrer o array da direita para a esquerda
    var j = fim;

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
//***********************QUICKSORT DE CORMEN******************************
//Partição de Cormen
function cormenPartition(A, inicio, fim) {
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
//Quicksort de Cormen
function quicksortCormen(A, inicio, fim) {
    if (inicio < fim) {
        //realiza a partição
        var q = cormenPartition(A, inicio, fim);
        //ordena a partição esquerda
        quicksortCormen(A, inicio, q - 1);
        //ordena a partição direita
        quicksortCormen(A, q + 1, fim);
    }
}
