# 🧭 **Grafos Genéricos & Algoritmo de Dijkstra**

<p align="center">
  <img src="https://upload.wikimedia.org/wikipedia/commons/5/57/Dijkstra_Animation.gif" width="500"/>
</p>

--- 
Video explicativo : https://youtu.be/LUmHe4MADCU
---

## 📌 **Sobre o Projeto**

Este projeto apresenta:

✔️ Um modelo de **arestas com pesos**  
✔️ O clássico **Algoritmo de Dijkstra**, usado para calcular caminhos mínimos  
✔️ Uma função para **reconstrução do caminho**  

---

# 🧱 **1. Grafos Genéricos**

### 🎯 O que é um Grafo?

Um **grafo** é uma estrutura formada por:

* **Vértices (ou nós)**
* **Arestas**, que conectam pares de vértices
* Cada aresta pode possuir um **peso**, representando custo/distância/tempo/etc.

### 🗺️ Representação usada no projeto

O grafo aqui é implementado usando:

```java
Map< String, List<Edge> >
````

Ou seja, cada vértice possui uma lista de arestas saindo dele.
Essa é a chamada **Lista de Adjacência**, muito eficiente para grafos grandes e esparsos.

-----

# ⚙️ **2. Estrutura das Arestas**

Cada aresta guarda:

  * O vértice de destino
  * O peso (um valor inteiro)

<!-- end list -->

```java
class Edge {
    String to;
    int weight;
}
```

-----

# 🚀 **3. Algoritmo de Dijkstra**

### 🎯 Objetivo

Encontrar o **menor caminho** de um vértice inicial até todos os outros.

### 🧩 Como funciona?

1.  Atribui distância infinita para todos os vértices
2.  Define a distância do vértice inicial como 0
3.  Usa uma **PriorityQueue** (min-heap) para explorar primeiro os caminhos mais promissores
4.  Relaxa as arestas, atualizando distâncias quando encontra caminhos melhores
5.  Guarda quem veio antes no caminho (para reconstruir depois)

-----

# 🛣️ **4. Reconstrução do Caminho**

Após rodar Dijkstra, reconstruímos o caminho usando o mapa `previous`, indo do destino até a origem — de trás para frente — e depois invertendo a lista.

-----

