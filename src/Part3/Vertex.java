package Part3;

public class Vertex {
    private int n;
    private String name;
    private boolean visited;

    public Vertex(int n, String name) {
        this.n = n;
        this.name = name;
        this.visited = false;
    }

    public String toString() {
        return name;
    }

    public String name() {
        return this.name;
    }

    public void visit() {
        this.visited = true;
    }

    public void unvisit() {
        this.visited = false;
    }
}
