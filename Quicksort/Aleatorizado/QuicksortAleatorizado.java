//GitHub: HenriqueIni
//https://www.blogcyberini.com/
import java.util.Random;

//Quicksort com pivô aleatório (utiliza a partição de Cormen como base)
public class QuicksortAleatorizado {
    //Facilita a vida: só pede o array como argumento
    public static void quicksortAleatorizado(int[] A){        
        quicksortAleatorizado(A, 0, A.length - 1);
    }

    private static void quicksortAleatorizado(int[] A, int inicio, int fim){        
        if(inicio < fim){
            //realiza a partição
            int q = partition(A, inicio, fim);
            //ordena a partição esquerda
            quicksortAleatorizado(A, inicio, q - 1);
            //ordena a partição direita
            quicksortAleatorizado(A, q + 1, fim);            
        }
    }
    
    //Método de partição
    private static int partition(int[] A, int inicio, int fim){
        //sorteia um índice aleatório entre inicio e fim
        Random rnd = new Random();
        int randomIndex = rnd.nextInt(fim - inicio + 1) + inicio;
        //coloca o pivô aleatório no fim para aplicar a partição de Cormen
        swap(A, randomIndex, fim);
        
        //*******************ALGORITMO DE PARTIÇÃO DE CORMEN*********************
        //o pivô é o elemento final
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
