//GitHub: HenriqueIni
//https://www.blogcyberini.com/

//Versão do Quicksort do Cormen (Algoritmos: teoria e prática)
public class QuicksortCormen {
    //Facilita a vida: só pede o array como argumento
    public static void quicksort(int[] A){        
        quicksort(A, 0, A.length - 1);
    }
    
    //Quicksort de Cormen
    private static void quicksort(int[] A, int inicio, int fim){        
        if(inicio < fim){
            //realiza a partição
            int q = partition(A, inicio, fim);
            //ordena a partição esquerda
            quicksort(A, inicio, q - 1);
            //ordena a partição direita
            quicksort(A, q + 1, fim);            
        }
    }
    
    //Método de partição
    private static int partition(int[] A, int inicio, int fim){
        //o pivo é o elemento final
        int pivo = A[fim];        
        int i = inicio - 1;
        /*
         * Este laço irá varrer os vetores da esquerda para direira
         * procurando os elementos que são menores ou iguais ao pivô.
         * Esses elementos são colocados na partição esquerda.         
         */
        for(int j = inicio; j <= fim - 1; j++){
            if(A[j] <= pivo){
                i = i + 1;
                swap(A, i, j);
            }
        }
        //coloca o pivô na posição de ordenação
        swap(A, i + 1, fim);
        return i + 1; //retorna a posição do pivô
    }
    
    //método auxiliar para realizar as trocas de elementos
    private static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
