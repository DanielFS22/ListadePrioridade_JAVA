# 📌 Estruturas de Prioridade em Java (Heaps)

Este repositório contém implementações de estruturas baseadas em **Filas de Prioridade (Min-Heap e Max-Heap)** para resolver problemas clássicos de eficiência e processamento de dados em **O(log N)**.

## 🚀 Conteúdo

### **Exer1 — K Maiores Elementos**

Algoritmo que utiliza um **Min-Heap** para encontrar os *K maiores valores* de um array de forma otimizada (**O(N log K)**).

### **Exer2 — Merge de K Listas Ordenadas**

Mesclagem eficiente de listas ordenadas usando um Min-Heap que armazena a tupla *(valor, lista, índice)*.

### **Exer3 — DualPriorityQueue**

Estrutura que retorna e remove o **mínimo** e o **máximo** em tempo logarítmico usando
**Min-Heap + Max-Heap + Lazy Deletion (HashMap)**.

### **Exer5 — MedianFinder**

Classe que calcula a **mediana em tempo real**, armazenando:

* Metade inferior → Max-Heap
* Metade superior → Min-Heap
  Mediana retornada em **O(1)**.

## 📚 Conceitos Trabalhados

* Min-Heap e Max-Heap
* Lazy deletion com HashMap
* Processamento eficiente de fluxo de dados
* Divisão equilibrada de estruturas
* Problemas clássicos de estrutura de dados

## 🛠 Tecnologias

* **Java 17+**
* PriorityQueue
* HashMap
* Collections Framework
