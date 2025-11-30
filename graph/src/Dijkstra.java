import java.util.*;

class Dijkstra {

    /*
     * Algoritmo de Dijkstra:
     * - Calcula o menor caminho a partir de um vértice inicial para todos os outros.
     * - Usa uma PriorityQueue para sempre expandir o vértice com menor custo atual.
     */
    public static DijkstraResult shortestPath(Graph graph, String start) {

        // Mapa de distâncias: começamos tudo como "infinito"
        Map<String, Integer> dist = new HashMap<>();
        Map<String, String> prev = new HashMap<>();

        for (String v : graph.getVertices()) {
            dist.put(v, Integer.MAX_VALUE);
            prev.put(v, null);
        }

        // A distância da origem até ela mesma é zero
        dist.put(start, 0);

        /*
         * PriorityQueue ordenada pela menor distância.
         * Assim, sempre expandimos o vértice mais promissor.
         */
        PriorityQueue<String> pq = new PriorityQueue<>(
            Comparator.comparingInt(dist::get)
        );

        pq.add(start);

        while (!pq.isEmpty()) {
            String u = pq.poll(); // pega o vértice com menor distância atual

            // Relaxamento das arestas que saem de u
            for (Edge edge : graph.getNeighbors(u)) {
                String v = edge.to;
                int weight = edge.weight;

                int newDist = dist.get(u) + weight;

                /*
                 * Se achamos um caminho mais curto para v,
                 * atualizamos a distância e adicionamos v na fila.
                 */
                if (newDist < dist.get(v)) {
                    dist.put(v, newDist);
                    prev.put(v, u);
                    pq.add(v);
                }
            }
        }

        return new DijkstraResult(dist, prev);
    }

    /*
     * Reconstrói o caminho mínimo usando o mapa "previous",
     * voltando do destino até a origem.
     */
    public static List<String> reconstructPath(Map<String, String> prev, String start, String end) {
        List<String> path = new ArrayList<>();
        String current = end;

        // Voltamos pelos predecessores até chegar na origem
        while (current != null) {
            path.add(current);
            current = prev.get(current);
        }

        Collections.reverse(path); // caminho está invertido

        // Se o primeiro vértice não é o início, não existe rota
        if (!path.get(0).equals(start)) {
            return null;
        }

        return path;
    }
}