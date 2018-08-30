//GitHub: HenriqueIni
//https://www.blogcyberini.com/

//método auxiliar: troca os elementos i e j em A
function swap(A, i, j) {
    var temp = A[i];
    A[i] = A[j];
    A[j] = temp;
}
function partition(A, inicio, fim) {
    //procura a mediana entre inicio, meio e fim
    var meio = Math.floor((inicio + fim) / 2);
    var a = A[inicio];
    var b = A[meio];
    var c = A[fim];
    var medianaIndice; //índice da mediana
    //A sequência de if...else a seguir verifica qual é a mediana
    if (a < b) {
        if (b < c) {
            //a < b && b < c
            medianaIndice = meio;
        } else {
            if (a < c) {
                //a < c && c <= b
                medianaIndice = fim;
            } else {
                //c <= a && a < b
                medianaIndice = inicio;
            }
        }
    } else {
        if (c < b) {
            //c < b && b <= a
            medianaIndice = meio;
        } else {
            if (c < a) {
                //b <= c && c < a
                medianaIndice = fim;
            } else {
                //b <= a && a <= c
                medianaIndice = inicio;
            }
        }
    }
    //coloca o elemento da mediana no fim para poder usar o Quicksort de Cormen
    swap(A, medianaIndice, fim);
    
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
//Quicksort mediana de três
function quicksortMedianaDeTres(A, inicio, fim) {
    if (inicio < fim) {
        //realiza a partição
        var q = partition(A, inicio, fim);
        //ordena a partição esquerda
        quicksortMedianaDeTres(A, inicio, q - 1);
        //ordena a partição direita
        quicksortMedianaDeTres(A, q + 1, fim);
    }
}
