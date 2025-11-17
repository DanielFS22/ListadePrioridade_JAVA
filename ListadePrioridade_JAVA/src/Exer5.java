/*Objetivo: Usar Listas de Prioridade para manter e calcular a mediana de um fluxo
de dados em tempo logarítmico.

• Descrição: Crie uma classe MedianFinder com os seguintes métodos:
o addNum(int num): Adiciona um novo inteiro ao fluxo.
o findMedian(): Retorna a mediana atual dos números adicionados. Se
houver um número par de elementos, a mediana é a média dos dois
do meio.

• Dica: Use um Max-Heap para armazenar a metade inferior dos números e
um Min-Heap para armazenar a metade superior. */


import java.util.*;

public class Exer5 {

    static class MedianFinder {

        // Max-Heap (metade inferior dos números)
        private PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());

        // Min-Heap (metade superior dos números)
        private PriorityQueue<Integer> upper = new PriorityQueue<>();

        // Adiciona um número ao fluxo
        public void addNum(int num) {
            // Se o número pertence à metade inferior
            if (lower.isEmpty() || num <= lower.peek()) {
                lower.add(num);
            } else {
                upper.add(num);
            }

            // Rebalanceamento: tamanhos devem ser iguais ou com diferença de apenas 1
            if (lower.size() > upper.size() + 1) {
                upper.add(lower.poll());
            } else if (upper.size() > lower.size()) {
                lower.add(upper.poll());
            }
        }

        // Retorna a mediana atual
        public double findMedian() {
            if (lower.size() > upper.size()) {
                return lower.peek();  // quantidade ímpar → o topo do maior heap
            } else {
                return (lower.peek() + upper.peek()) / 2.0; // par → média dos dois do meio
            }
        }
    }

    // Teste rápido
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();

        mf.addNum(10);
        mf.addNum(5);
        mf.addNum(20);
        mf.addNum(15);

        System.out.println("Mediana: " + mf.findMedian()); // Deve ser (10 + 15) / 2 = 12.5

        mf.addNum(30);

        System.out.println("Mediana agora: " + mf.findMedian()); // Deve ser 15
    }
}
