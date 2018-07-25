//GitHub: HenriqueIni
//https://www.blogcyberini.com/
import java.util.concurrent.ForkJoinPool;

//códigos de testes do merge sort com Fork Join
public class TestesMergeForkJoin {
    public static void main(String[] args) {        
        ForkJoinPool pool = new ForkJoinPool(); //cria um pool de threads Fork/Join
        int[] A = {5, 2, 7, 6, 2, 1, 0, 3, 9, 4}; //array que será ordenado
        //imprime o vetor desordenado
        System.out.printf("A (desordenado) = [%d, %d, %d, %d, %d, %d, %d, %d, %d, %d]\n",
                A[0], A[1], A[2], A[3], A[4], A[5], A[6], A[7], A[8], A[9]);        
        MergeSortTask mergeTask = new MergeSortTask(A); //tarefa ForkJoin para ordenar o vetor A
        pool.invoke(mergeTask); //executa a tarefa utilizando o pool
        //imprime o vetor ordenado
        System.out.printf("A (ordenado) = [%d, %d, %d, %d, %d, %d, %d, %d, %d, %d]\n",
                A[0], A[1], A[2], A[3], A[4], A[5], A[6], A[7], A[8], A[9]);
        
        /*
         * Você também pode utilizar o método 'Arrays.parallelSort(vetor)'
         * para ordenar vetores utilizando múltiplas threads
         */
    }    
}
