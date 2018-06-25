//GitHub: HenriqueIni
//https://www.blogcyberini.com/

//Algoritmo de ordenação por inserção
//Algoritmo adaptado o livro "Algoritmos: teoria e prática" (Cormen et al)
public class InsertionSort {    
    /**
     * Ordena o vetor de inteiros A utilizando o algoritmo de ordenação por inserção.
     * Melhor caso (vetor ordenado): O(n)
     * Caso médio: O(n^2)
     * Pior caso: O(n^2)
     * 
     * @param A vetor que será ordenado
     */
    public static void insertionSort(int[] A){        
        for(int i = 1; i < A.length; i++){
            int elemento = A[i];
            int j = i - 1;
            while(j >= 0 && A[j] > elemento){
                A[j + 1] = A[j]; //deslocamento para direita
                j = j - 1;
            }
            A[j + 1] = elemento; //insere o elemento na partição ordenada
        }
    }
    
    /**
     * Ordena o vetor de objetos "Comparable" A utilizando o algoritmo de ordenação por inserção.
     * Melhor caso (vetor ordenado): O(n)
     * Caso médio: O(n^2)
     * Pior caso: O(n^2)
     * 
     * @param A vetor que será ordenado
     */
    public static void insertionSort(Comparable[] A){        
        for(int i = 1; i < A.length; i++){
            Comparable elemento = A[i];
            int j = i - 1;
            while(j >= 0 && A[j].compareTo(elemento) > 0){
                A[j + 1] = A[j]; //deslocamento para direita
                j = j - 1;
            }
            A[j + 1] = elemento; //insere o elemento na partição ordenada
        }
    }

    //Código de testes
    public static void main(String[] args) {
        int A[] = {3, 1, 9, 5, 2, 8};
        insertionSort(A);
        String aux = "["+A[0];
        for(int i = 1; i < A.length; i++){
            aux += ", " + A[i];
        }
        System.out.println(aux + "]");
        String B[] = {"z", "r", "q", "p", "l", "h"};
        insertionSort(B);
        aux = "["+B[0];
        for(int i = 1; i < B.length; i++){
            aux += ", " + B[i];
        }
        System.out.println(aux + "]");
    }
}
