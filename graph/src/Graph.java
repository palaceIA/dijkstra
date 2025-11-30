import java.util.*;


/*
 * Esta classe representa um grafo básico, podendo ser direcionado ou não.
 * Aqui usamos um HashMap onde cada vértice mapeia para uma lista de arestas
 * que saem dele. É uma forma eficiente de representar grafos esparsos.
 */
class Graph {
    private Map<String, List<Edge>> adj;
    private boolean directed;

    public Graph(boolean directed) {
        this.directed = directed;
        this.adj = new HashMap<>();
    }

    // Adiciona um vértice no grafo se ainda não existir.
    public void addVertex(String v) {
        adj.putIfAbsent(v, new ArrayList<>());
    }

    /*
     * Adiciona uma aresta entre dois vértices. Se o grafo não for direcionado,
     * adicionamos também a aresta inversa. O peso indica o "custo" dessa ligação.
     */
    public void addEdge(String u, String v, int weight) {
        addVertex(u);
        addVertex(v);

        adj.get(u).add(new Edge(v, weight));

        if (!directed) {
            adj.get(v).add(new Edge(u, weight));
        }
    }

    // Retorna os vizinhos de um vértice (lista de arestas).
    public List<Edge> getNeighbors(String v) {
        return adj.getOrDefault(v, new ArrayList<>());
    }

    // Retorna todos os vértices do grafo.
    public Set<String> getVertices() {
        return adj.keySet();
    }

    // Apenas imprime o grafo de forma amigável.
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String v : adj.keySet()) {
            sb.append(v).append(" -> ").append(adj.get(v)).append("\n");
        }
        return sb.toString();
    }
}