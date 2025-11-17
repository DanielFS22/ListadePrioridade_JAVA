/*Objetivo: Usar uma Fila de Prioridade (Min-Heap) para mesclar $K$ listas
ordenadas em uma única lista ordenada.

• Descrição: Crie um método estático
mergeKSortedLists(List<List<Integer>> lists) que recebe uma lista de listas
ordenadas de inteiros e retorna uma única lista, contendo todos os
elementos das listas de entrada em ordem crescente.

• Dica: O Heap deve armazenar um objeto/tupla que contenha o valor, o
índice da lista de onde veio, e o índice do elemento na lista original. */


import java.util.*;

public class Exer2 {

    // Classe auxiliar para armazenar: valor, índice da lista e índice do elemento
    static class Node implements Comparable<Node> {
        int value;      // valor do elemento
        int listIndex;  // de qual lista veio
        int elemIndex;  // posição dentro da lista original

        public Node(int value, int listIndex, int elemIndex) {
            this.value = value;
            this.listIndex = listIndex;
            this.elemIndex = elemIndex;
        }

        // Comparação com base no menor valor → Min-Heap
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.value, other.value);
        }
    }

    // Método que mescla K listas ordenadas em uma única lista ordenada
    public static List<Integer> mergeKSortedLists(List<List<Integer>> lists) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>();

        // Inicializa o heap com o primeiro elemento de cada lista
        for (int i = 0; i < lists.size(); i++) {
            if (!lists.get(i).isEmpty()) {
                minHeap.add(new Node(lists.get(i).get(0), i, 0));
            }
        }

        // Enquanto houver elementos no heap
        while (!minHeap.isEmpty()) {
            Node current = minHeap.poll(); // menor elemento atual
            result.add(current.value);

            // Próximo elemento da mesma lista
            int nextIndex = current.elemIndex + 1;

            if (nextIndex < lists.get(current.listIndex).size()) {
                int nextValue = lists.get(current.listIndex).get(nextIndex);
                minHeap.add(new Node(nextValue, current.listIndex, nextIndex));
            }
        }

        return result;
    }

    // Exemplo de uso
    public static void main(String[] args) {
        List<List<Integer>> listas = new ArrayList<>();

        listas.add(Arrays.asList(1, 4, 5));
        listas.add(Arrays.asList(1, 3, 4));
        listas.add(Arrays.asList(2, 6));

        List<Integer> resultado = mergeKSortedLists(listas);

        System.out.println("Lista mesclada: " + resultado);
    }
}
