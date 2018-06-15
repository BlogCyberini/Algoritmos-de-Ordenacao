//GitHub: HenriqueIni
//https://www.blogcyberini.com/

//Algoritmo de ordenação por seleção
public class SelectionSort {    
    /**
     * Ordena um vetor utilizando o Selection Sort O(n^2)
     * @param a array que será ordenado
     */
    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = min(a, i, a.length - 1);
            trocar(a, i, minIndex);
        }
    }
    
    /**
     * Retorna o índice do menor valor do vetor a entre os índices i e j
     * @param a vetor
     * @param i índice inicial
     * @param j índice final
     * @return índice do menor elemento do vetor a entre os índices i e j
     */
    private static int min(int[] a, int i, int j) {
        if (i > j) {
            throw new IllegalArgumentException("i > j");
        }
        int minIndex = i;
        for (int k = i + 1; k <= j; k++) {
            if (a[minIndex] > a[k]) {
                minIndex = k;
            }
        }
        return minIndex;
    }

    /**
     * Troca os elementos das posições i e j de posição entre eles.
     * @param a vetor
     * @param i índice
     * @param j índice
     */
    private static void trocar(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    /**
     * Versão 'linguiça' do Selection Sort (todo código num único módulo)
     * @param a vetor que será ordenado
     */
    public static void selectionSortSausage(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int k = i + 1; k < a.length; k++) {
                if (a[minIndex] > a[k]) {
                    minIndex = k;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }
    
    /**
     * Versão 'linguiça' do Selection Sort (todo código num único módulo).
     * Ordena um array de objetos <code>Comparable</code>.
     * @param a vetor que será ordenado
     */
    public static void selectionSortSausageObj(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int k = i + 1; k < a.length; k++) {
                if (a[minIndex].compareTo(a[k]) > 0) {
                    minIndex = k;
                }
            }
            Comparable temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }
    
    //código de testes
    public static void main(String[] args) {
        int[] A = {40,9,4,-1,6};
        int[] B = {4,9,3,1,6};
        String[] C = {"b", "c", "d", "k", "a"};
        
        System.out.println("Vetores desordenados");
        System.out.printf("A = [%d, %d, %d, %d, %d]\n", A[0], A[1], A[2], A[3], A[4]);
        System.out.printf("B = [%d, %d, %d, %d, %d]\n", B[0], B[1], B[2], B[3], B[4]);
        System.out.printf("C = [%s, %s, %s, %s, %s]\n", C[0], C[1], C[2], C[3], C[4]);
        
        selectionSort(A);
        selectionSortSausage(B);
        selectionSortSausageObj(C);
        
        System.out.println("Vetores ordenados");
        System.out.printf("A = [%d, %d, %d, %d, %d]\n", A[0], A[1], A[2], A[3], A[4]);
        System.out.printf("B = [%d, %d, %d, %d, %d]\n", B[0], B[1], B[2], B[3], B[4]);
        System.out.printf("C = [%s, %s, %s, %s, %s]\n", C[0], C[1], C[2], C[3], C[4]);
    }
}
