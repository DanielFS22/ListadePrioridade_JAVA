/*Objetivo: Utilizar uma Fila de Prioridade (Min-Heap) para encontrar de forma
eficiente os $K$ maiores elementos em um array desordenado.

• Descrição: Crie um método estático findKthLargest(int[] arr, int k) que
receba um array de inteiros e um inteiro $K$, e retorne uma lista contendo
os $K$ maiores elementos do array.

• Requisito de Complexidade: O algoritmo deve ser mais eficiente que a
ordenação completa, atingindo $O(N \log K)*/


import java.util.*;

public class Exer1 {

    // Método que encontra os K maiores elementos usando Min-Heap
    public static List<Integer> findKthLargest(int[] arr, int k) {
        // Min-Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) {
            // Adiciona elemento ao heap
            minHeap.add(num);

            // Se tiver mais de K elementos, remove o menor
            if (minHeap.size() > k) {
                minHeap.poll(); // remove o menor elemento
            }
        }

        // Agora o heap contém apenas os K maiores
        List<Integer> result = new ArrayList<>(minHeap);

        // Opcional: ordenar em ordem decrescente
        result.sort(Collections.reverseOrder());

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {10, 4, 7, 20, 15, 2, 30};
        int k = 3;

        List<Integer> maiores = findKthLargest(arr, k);

        System.out.println("Os " + k + " maiores elementos são: " + maiores);
    }
}
