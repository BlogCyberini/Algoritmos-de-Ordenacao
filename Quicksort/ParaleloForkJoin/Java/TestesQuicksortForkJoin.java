//GitHub: HenriqueIni
//https://www.blogcyberini.com/
import java.util.concurrent.ForkJoinPool;

public class TestesQuicksortForkJoin {
    public static void main(String[] args) {
        //cria um pool de threads Fork/Join
        ForkJoinPool pool = new ForkJoinPool();
        
        //array que será ordenado
        int[] A = {5, 2, 7, 6, 2, 1, 0, 3, 9, 4};
        
        //imprime o vetor desordenado
        System.out.println("A (desordenado) = " + arrayToString(A));
        
        //***TESTA O QUICKSORT DE CORMEN***
        //tarefa ForkJoin para ordenar o vetor A
        QuicksortForkJoinCormen quicksortTaskCormen = new QuicksortForkJoinCormen(A);
        //executa a tarefa utilizando o pool
        pool.invoke(quicksortTaskCormen);
        System.out.println("A (ordenado com Quicksort de Cormen) = " + arrayToString(A));
        
        //***TESTA O QUICKSORT DE HOARE***
        //gera um novo array
        A = new int[]{5, 2, 7, 6, 2, 1, 0, 3, 9, 4};
        //tarefa ForkJoin para ordenar o vetor A
        QuicksortForkJoinHoare quicksortTaskHoare = new QuicksortForkJoinHoare(A);
        //executa a tarefa utilizando o pool
        pool.invoke(quicksortTaskHoare);
        System.out.println("A (ordenado com Quicksort de Hoare) = " + arrayToString(A));
        
        //***TESTA O QUICKSORT MEDIANA DE 3***
        //gera um novo array
        A = new int[]{5, 2, 7, 6, 2, 1, 0, 3, 9, 4};
        //tarefa ForkJoin para ordenar o vetor A
        QuicksortForkJoinMedianThree quicksortTaskMedianThree = new QuicksortForkJoinMedianThree(A);
        //executa a tarefa utilizando o pool
        pool.invoke(quicksortTaskMedianThree);
        System.out.println("A (ordenado com Quicksort Mediana de 3) = " + arrayToString(A));
        
        //***TESTA O QUICKSORT COM PIVÔ ALEATÓRIO***
        //gera um novo array
        A = new int[]{5, 2, 7, 6, 2, 1, 0, 3, 9, 4};
        //tarefa ForkJoin para ordenar o vetor A
        QuicksortForkJoinRandomized quicksortTaskRandom = new QuicksortForkJoinRandomized(A);
        //executa a tarefa utilizando o pool
        pool.invoke(quicksortTaskRandom);
        System.out.println("A (ordenado com Quicksort com pivô aleatório) = " + arrayToString(A));
    }
    
    //Método auxiliar para imprimir os arrays
    private static String arrayToString(int[] array){
        String aux = "[" + array[0];
        for(int i = 1; i < array.length; i++){
            aux += ", " + array[i];
        }
        return aux + "]";
    }
    
}
