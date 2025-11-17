/*Objetivo: Simular um Heap que pode rapidamente retornar e remover o elemento
máximo E o elemento mínimo.

• Descrição: Crie uma classe DualPriorityQueue com os seguintes métodos:
o insert(int value): Adiciona um valor.
        o getMax(): Retorna o maior valor (sem remover).
o getMin(): Retorna o menor valor (sem remover).
o removeMax(): Remove e retorna o maior valor.
o removeMin(): Remove e retorna o menor valor.

        • Dica: Use duas Listas de Prioridade: um Max-Heap e um Min-Heap, e use
um mapa de frequência (HashMap) para rastrear elementos removidos,
mantendo as operações $O(\log N)$.*/

import java.util.*;

public class Exer3 {

    static class DualPriorityQueue {

        // Min-Heap (menor no topo)
        private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Max-Heap (maior no topo)
        private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Mapa para controlar remoção atrasada (lazy deletion)
        private Map<Integer, Integer> freq = new HashMap<>();

        // Limpa elementos "mortos" do topo dos heaps
        private void clean(PriorityQueue<Integer> heap) {
            while (!heap.isEmpty() && freq.getOrDefault(heap.peek(), 0) == 0) {
                heap.poll();
            }
        }

        // Inserir um valor
        public void insert(int value) {
            minHeap.add(value);
            maxHeap.add(value);

            freq.put(value, freq.getOrDefault(value, 0) + 1);
        }

        // Retornar o menor valor sem remover
        public Integer getMin() {
            clean(minHeap);
            return minHeap.isEmpty() ? null : minHeap.peek();
        }

        // Retornar o maior valor sem remover
        public Integer getMax() {
            clean(maxHeap);
            return maxHeap.isEmpty() ? null : maxHeap.peek();
        }

        // Remover e retornar o menor valor
        public Integer removeMin() {
            clean(minHeap);
            if (minHeap.isEmpty()) return null;

            int val = minHeap.poll();
            freq.put(val, freq.get(val) - 1);
            return val;
        }

        // Remover e retornar o maior valor
        public Integer removeMax() {
            clean(maxHeap);
            if (maxHeap.isEmpty()) return null;

            int val = maxHeap.poll();
            freq.put(val, freq.get(val) - 1);
            return val;
        }
    }

    // Teste
    public static void main(String[] args) {
        DualPriorityQueue dpq = new DualPriorityQueue();

        dpq.insert(10);
        dpq.insert(5);
        dpq.insert(20);
        dpq.insert(5);

        System.out.println("Min: " + dpq.getMin()); // 5
        System.out.println("Max: " + dpq.getMax()); // 20

        System.out.println("Remove Min: " + dpq.removeMin()); // 5
        System.out.println("Remove Max: " + dpq.removeMax()); // 20

        System.out.println("Min agora: " + dpq.getMin()); // 5
        System.out.println("Max agora: " + dpq.getMax()); // 10
    }
}

