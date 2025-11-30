/*
 * A classe Edge representa simplesmente uma ligação para outro vértice,
 * armazenando também o peso (custo) dessa conexão.
 */
class Edge {
    String to;
    int weight;

    Edge(String to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(" + to + ", " + weight + ")";
    }
}