//GitHub: HenriqueIni
//https://www.blogcyberini.com/
public class MergeSort {    
    //**************** MERGE SORT (VETORES DE INTEIROS) ***************
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
    public static void mergeSort(int A[], int inicio, int fim){
        if(inicio < fim){
            int meio = (inicio + fim) / 2; //calcula o meio
            mergeSort(A, inicio, meio); //ordena do subvetor esquerdo
            mergeSort(A, meio + 1, fim); //ordena do subvetor direito
            merge(A, inicio, meio, fim); //funde os subvetores esquerdo e direito
        }
    }    
    private static void merge(int A[], int inicio, int meio, int fim){
        int tamEsq = meio - inicio + 1; //tamanho do subvetor esquerdo
        int tamDir = fim - meio; //tamanho do subvetor direito
        int esq[] = new int[tamEsq]; //subvetor auxiliar esquerdo
        int dir[] = new int[tamDir]; //subvetor auxiliar direito
        int idxEsq = 0; //índice do subvetor auxiliar esquerdo
        int idxDir = 0; //índice do subvetor auxiliar direito
        
        //Copia os elementos do subvetor esquerdo para o vetor auxiliar
        for(int i = 0; i < tamEsq; i++){
            esq[i] = A[inicio + i];
        }
        //Copia os elementos do subvetor direito para o vetor auxiliar
        for(int j = 0; j < tamDir; j++){
            dir[j] = A[meio + 1 + j];
        }
        
        //intercala os subvetores
        for(int k = inicio; k <= fim; k++){
            if(idxEsq < tamEsq){
                if(idxDir < tamDir){
                    if(esq[idxEsq] < dir[idxDir]){
                        A[k] = esq[idxEsq++];
                    }else{
                        A[k] = dir[idxDir++];
                    }
                }else{
                    A[k] = esq[idxEsq++];
                }
            }else{
                A[k] = dir[idxDir++];
            }
        }
    }
    //**************** MERGE SORT (VETORES DE COMPARABLE) ***************
    /*
        * Algoritmo de ordenação por intercação/fusão
        * 
        * Adaptado o livro "Algoritmos: teoria e prática" (Cormen et al)
        * 
        * 'A' é o vetor de Comparable que será ordenado, 'inicio' é o indice inicial
        * e 'fim' é o índice final
        * Melhor caso: O(n log n)
        * Caso médio: O(n log n)
        * Pior caso: O(n log n)
     */
    public static void mergeSort(Comparable A[], int inicio, int fim){
        if(inicio < fim){
            int meio = (inicio + fim) / 2; //calcula o meio
            mergeSort(A, inicio, meio); //ordena do subvetor esquerdo
            mergeSort(A, meio + 1, fim); //ordena do subvetor direito
            merge(A, inicio, meio, fim); //funde os subvetores esquerdo e direito
        }
    }
    private static void merge(Comparable A[], int inicio, int meio, int fim){
        int tamEsq = meio - inicio + 1; //tamanho do subvetor esquerdo
        int tamDir = fim - meio; //tamanho do subvetor direito
        Comparable esq[] = new Comparable[tamEsq]; //subvetor auxiliar esquerdo
        Comparable dir[] = new Comparable[tamDir]; //subvetor auxiliar direito
        int idxEsq = 0; //índice do subvetor auxiliar esquerdo
        int idxDir = 0; //índice do subvetor auxiliar direito
        
        //Copia os elementos do subvetor esquerdo para o vetor auxiliar
        for(int i = 0; i < tamEsq; i++){
            esq[i] = A[inicio + i];
        }
        
        //Copia os elementos do subvetor direito para o vetor auxiliar
        for(int j = 0; j < tamDir; j++){
            dir[j] = A[meio + 1 + j];
        }
        
        //intercala os vetores
        for(int k = inicio; k <= fim; k++){
            if(idxEsq < tamEsq){
                if(idxDir < tamDir){
                    if(esq[idxEsq].compareTo(dir[idxDir]) < 0){
                        A[k] = esq[idxEsq++];
                    }else{
                        A[k] = dir[idxDir++];
                    }
                }else{
                    A[k] = esq[idxEsq++];
                }
            }else{
                A[k] = dir[idxDir++];
            }
        }
    }
    
    //código de testes
    public static void main(String[] args) {
        //testa o merge sort para vetores inteiros
        int[] A = {5, 2, 7, 6, 2, 1, 0, 3, 9, 4};
        System.out.printf("A (desordenado) = [%d, %d, %d, %d, %d, %d, %d, %d, %d, %d]\n",
                A[0], A[1], A[2], A[3], A[4], A[5], A[6], A[7], A[8], A[9]);
        mergeSort(A, 0, A.length - 1);
        System.out.printf("A (ordenado) = [%d, %d, %d, %d, %d, %d, %d, %d, %d, %d]\n",
                A[0], A[1], A[2], A[3], A[4], A[5], A[6], A[7], A[8], A[9]);
        
        //testa o merge sort para objetos Comparable
        String[] B = {"w", "z", "r", "f", "h", "i", "d"};
        System.out.printf("B (desordenado) = [%s, %s, %s, %s, %s, %s, %s]\n",
                B[0], B[1], B[2], B[3], B[4], B[5], B[6]);
        mergeSort(B, 0, B.length - 1);
        System.out.printf("B (ordenado) = [%s, %s, %s, %s, %s, %s, %s]\n",
                B[0], B[1], B[2], B[3], B[4], B[5], B[6]);
    }
}
