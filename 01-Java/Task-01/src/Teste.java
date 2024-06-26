public class Teste {
    // Método para realizar a ordenação por bolha em ordem decrescente
    public static void bubbleSortDesc(int[] arr, String[] nomes) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Loop interno para comparar elementos adjacentes
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    // Trocar os elementos se estiverem na ordem errada
                    int temp1 = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp1;

                    String temp2 = nomes[j];
                    nomes[j] = nomes[j + 1];
                    nomes[j + 1] = temp2;
                    swapped = true;
                }
            }

            // Se nenhum elemento foi trocado, a lista está ordenada
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[] arr = {14, 34, 95};
        String[] nomes = {"Santos", "Flamengo", "Palmeiras"};

        System.out.println("Array original:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        bubbleSortDesc(arr, nomes);

        System.out.println("\n\nArray ordenado (do maior para o menor):");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
            System.out.println(nomes[i]);
        }
    }
}
