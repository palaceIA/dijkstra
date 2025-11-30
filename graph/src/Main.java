import java.util.*;

public class Main {
    public static void main(String[] args) {

        Graph g = new Graph(false); // false = não direcionado

        g.addEdge("A", "B", 4);
        g.addEdge("A", "C", 2);
        g.addEdge("C", "B", 1);
        g.addEdge("B", "D", 5);
        g.addEdge("C", "D", 8);
        g.addEdge("D", "E", 6);

        System.out.println("Grafo:");
        System.out.println(g);

        DijkstraResult result = Dijkstra.shortestPath(g, "A");

        System.out.println("Distâncias a partir de A:");
        System.out.println(result.distances);

        List<String> path = Dijkstra.reconstructPath(result.previous, "A", "E");
        System.out.println("Caminho mínimo A → E:");
        System.out.println(path);
    }
}