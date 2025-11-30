import java.util.*;

/*
 * Guardamos dois mapas:
 * - distances: menor distância da origem até cada vértice
 * - previous: quem vem antes no caminho mínimo (para reconstrução da rota)
 */
class DijkstraResult {
    Map<String, Integer> distances;
    Map<String, String> previous;

    DijkstraResult(Map<String, Integer> distances, Map<String, String> previous) {
        this.distances = distances;
        this.previous = previous;
    }
}