//GitHub: HenriqueIni
//https://www.blogcyberini.com/
import java.util.concurrent.RecursiveAction;

public class QuicksortForkJoinHoare extends RecursiveAction {
    private int[] array; //array que será ordenado
    private int inicio; //índice de início
    private int fim; //íncide do fim

    //ordena o subarray do índice 'inicio' até 'fim'
    public QuicksortForkJoinHoare(int[] array, int inicio, int fim){
        this.array = array;
        this.inicio = inicio;
        this.fim = fim;
    }
    //ordena o array por completo
    public QuicksortForkJoinHoare(int[] array){
        this(array, 0, array.length - 1);
    }
    //executa o Quicksort paralelamente com Fork-Join
    @Override
    protected void compute() {
        if(inicio < fim){
            int q = partition(array, inicio, fim); //obtém o pivô (join)
            //realiza as chamadas recursivas paralelamente (fork)
            invokeAll(new QuicksortForkJoinHoare(array, inicio, q - 1),
                      new QuicksortForkJoinHoare(array, q + 1, fim));
        }
    }
    //Método de partição
    private static int partition(int[] A, int inicio, int fim){
        //o pivo é o elemento inicial
        int pivo = A[inicio];
        //índice i irá percorrer o array da esquerda para a direita
        int i = inicio + 1;
        //índice j irá percorrer o array da direita para a esquerda
        int j = fim;

        //O loop irá parar quando os índices se ultrapassarem
        while(i <= j){
            /*
             * Este laço irá parar quando encontrar algum elemento
             * à esquerda que é maior que o pivô, pois ele deveria estar na
             * partição direita
             */
            while(i <= j && A[i] <= pivo){
                i = i + 1;
            }
            /*
             * Esse laço irá parar quando encontrar algum elemento
             * à direira que é menor ou igual ao pivô, pois ele deveria estar na
             * partição esquerda
             */
            while(i <= j && A[j] > pivo){
                j = j - 1;
            }

            //se os índices não ultrapassarem, troca-os de posição
            if(i < j){
                swap(A, i, j);
            }
        }
        //coloca o pivô na posição de ordenação
        swap(A, inicio, j);
        return j; //retorna a posição do pivô
    }

    //método auxiliar para realizar as trocas de elementos
    private static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
