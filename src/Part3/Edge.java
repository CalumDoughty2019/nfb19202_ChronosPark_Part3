package Part3;

public class Edge {
    private Vertex source;
    private Vertex target;
    private int weight;

    public Edge(Vertex source, Vertex target) {
        this.source = source;
        this.target = target;
    }

    public Edge(Vertex source, Vertex target, int weight) {
        this(source, target);
        this.weight = weight;
    }

    public String toString() {
        return source + " " + target + " " + weight;
    }

    public Vertex source() {
        return this.source;
    }

    public Vertex target() {
        return this.target;
    }

    public int weight() {
        return this.weight;
    }
}
