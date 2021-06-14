import Part3.Edge;
import Part3.Vertex;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EdgeListGraph {
    private boolean directed;
    private List<Edge> edges;
    private List<Vertex> vertices;

    public EdgeListGraph(boolean directed) {
        this.directed = directed;
        this.edges = new ArrayList<>();
        this.vertices = new ArrayList<>();
    }

    public String toString() {
        String temp = "";
        for (Edge e : edges) {
            temp += e.source().name() + " -> " + e.target().name() + "\n";
        }
        return temp;
    }

    public void addEdge(Vertex source, Vertex target) {
        addVertex(source);
        addVertex(target);

        edges.add(new Edge(source, target));
        if (!directed) {
            edges.add(new Edge(target, source));
        }
    }

    public Edge hasEdge(Vertex source, Vertex target) {
        for (Edge e : edges) {
            if (e.source() == source && e.target() == target) {
                return e;
            }
        }
        return null;
    }

    public List<Edge> incomingEdges(Vertex v) {
        List<Edge> es = new LinkedList<>();
        for (Edge e : edges) {
            if (e.target() == v) {
                es.add(e);
            }
        }
        return es;
    }

    public void removeEdge(Vertex source, Vertex target) {
        Edge temp = null;
        for (Edge e : edges) {
            if (e.source() == source && e.target() == target) {
                temp = e;
                break;
            }
        }
        if (temp != null) {
            edges.remove(temp);
        }
    }

    public static List<Vertex> topologicalSort(EdgeListGraph g) {
        EdgeListGraph h = g.makeCopy();       // we remove edges so want a copy
        List<Vertex> vs = new LinkedList<>(); // sorted vertices we return
        Queue<Vertex> q = new LinkedList<>(); // vertices with no incoming edges

        // initialise queue with the vertices with no incoming edges
        for (Vertex v : h.vertices) {
            if (h.incomingEdges(v).size() == 0) { // no incoming edges
                q.add(v);
            }
        }

        while (!q.isEmpty()) {                        // while we have vertices in the queue
            Vertex v = q.remove();
            vs.add(v);                                // add the first vertex to the sorted list
            for (Vertex w : h.neighbours(v)) {        // look at each neighbour of v
                h.removeEdge(v, w);                   // and remove the edge that goes from v to w
                if (h.incomingEdges(w).size() == 0) { // if w has no more incoming edges
                    q.add(w);                         // add it to the queue
                }
            }
        }

        if (h.edges.size() > 0) {
            return null; // the copied graph still has edges, so contains a cycle. Error
        }
        return vs;       // otherwise return the ordered vertices
    }

    public void addEdge(Vertex source, Vertex target, int weight) {
        addVertex(source);
        addVertex(target);

        edges.add(new Edge(source, target, weight));
        if (!directed) {
            edges.add(new Edge(target, source, weight));
        }
    }

    private int minDistance(int[] dis, boolean[] done) {
        // no minimum distance or index yet
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        // for each vertex
        for (int n = 0; n < dis.length; n++) {
            // if the vertex hasn't been added (not done) and the distance to it is less than the minimum so far
            if (!done[n] && dis[n] <= min) {
                min = dis[n];    // set its distance to be the minimum
                minIndex = n;    // and its index to the the smallest
            }
        }
        return minIndex;         // return the smallest index found
    }

    private void printSolution(int[] dis, Vertex source, ArrayList<Ride> ridesArray) {
        System.out.println("Vertex distance from source " + source);
        System.out.println("          Ride Name:        Distance from Park Entrance:");
        System.out.println("          ----------        ----------------------------");



        int lastTheme = 0;
        for (int i = 0; i < dis.length; i++) {

            if(vertices.get(i).name() != "Entrance"){

                //if(ridesArray.get(i-1) == vertices)


                if(ridesArray.get(i-1).getTheme() != lastTheme){
                    switch(ridesArray.get(i).getTheme()){
                        case 1:
                            System.out.println("--------");
                            System.out.println("Medieval");
                            System.out.println("--------");
                            break;
                        case 2:
                            System.out.println("----------");
                            System.out.println("Futuristic");
                            System.out.println("----------");
                            break;
                        case 3:
                            System.out.println("--------");
                            System.out.println("Jurassic");
                            System.out.println("--------");
                            break;
                        case 4:
                            System.out.println("----------");
                            System.out.println("Industrial");
                            System.out.println("----------");
                            break;
                    }
                }
                lastTheme = ridesArray.get(i-1).getTheme();


//                if(ridesArray.get(i-1).getName() == vertices.get(i).name()){
//                    System.out.println(ridesArray.get(i-1).getTheme());
//                }

                System.out.printf("%20s %10sm %n", vertices.get(i).name(), dis[i]);
            }

            //System.out.println(i + " tt " + dis[i]);
            //System.out.println(vertices.get(i).name() + "              " + dis[i]);
        }
        System.out.println();
    }

    public void dijkstra(Vertex source, ArrayList<Ride> ridesArray) {
        int[] dist = new int[vertices.size()];

        boolean[] done = new boolean[vertices.size()]; // nodes that have their final distance value calculated

        // initialise all distances to MAX_VALUE
        // and all final values to false
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i) == source) {
                dist[i] = 0;
            } else {
                dist[i] = Integer.MAX_VALUE;
            }
            done[i] = false;
        }

        for (int i = 0; i < vertices.size(); i++) {
            int u = minDistance(dist, done); // find the next smallest node distance
            done[u] = true;                  // and set that node's index to be done

            // this loop might repeatedly update the distance to a node
            // as long as its index isn't done
            for (int v = 0; v < vertices.size(); v++) { // for all vertices, v, in the graph
                Vertex a = vertices.get(u);
                Vertex b = vertices.get(v);
                Edge e = hasEdge(a, b);                // if there is an edge from u to v
                if (!done[v] &&                        // and v isn't done
                    e != null && e.weight() != 0 &&
                    dist[u] + e.weight() < dist[v]) {  // and the distance from u to v is less than what's currently known about v
                      dist[v] = dist[u] + e.weight();  // update the distance to v.
                }
            }
        }

        printSolution(dist, source, ridesArray);
    }

    public void bellmanFordPath(Vertex source) {
        int[] dist = new int[vertices.size()];
        int[] pred = new int[vertices.size()];

        for (int i = 0; i < vertices.size(); i++) {
            dist[i] = Integer.MAX_VALUE/2; // max distance
            pred[i] = -1;                  // no predecessor
        }

        dist[vertices.indexOf(source)] = 0; // the distance from the source to itself is zero

        for (int i = 0; i < vertices.size(); i++) {   // loop vertices number of times...
            for (Edge e : edges) {                    // for every edge in the graph
                int s = vertices.indexOf(e.source()); // get the source
                int t = vertices.indexOf(e.target()); // and the target
                int w = e.weight();                   // and the distance from source to target
                if (dist[s] + w < dist[t]) {          // if the distance from s to t is smaller than the current known distance to t
                    dist[t] = dist[s] + w;            // update the distance to t
                    pred[t] = s;                      // make s the predecessor of t.
                }
            }
        }

        System.out.println("Travelling from vertex: " + source);
        System.out.print("node: ");
        for (int i = 0; i < vertices.size(); i++) {
            System.out.print(i + " ");
        }
        System.out.print("\ndist: ");
        for (int i : dist) {
            System.out.print(i + " ");
        }
        System.out.print("\npred: ");
        for (int i : pred) {
            System.out.print(i + " ");
        }
        System.out.println();


        System.out.print("The actual path from vertex " + source + " is: " + source + " ");
        // need a double loop here as we need to *find* the location of where
        // the predecessor is, and it could be in any order
        int prev = vertices.indexOf(source); // starting from source
        for (int z = 0; z < vertices.size(); z++) { // not actually using z
            for (int i = 0; i < vertices.size(); i++) {
                if (pred[i] == prev) { // if i has prev as the predecessor
                    prev = i;          // then i is next in the path
                    System.out.print(i + " "); // print it out
                }
            }
        }
        System.out.println();
    }

    private void addVertex(Vertex v) {
        if (!vertices.contains(v)) {
            vertices.add(v);
        }
    }

    public List<Vertex> neighbours(Vertex v) {
        List<Vertex> vs = new LinkedList<>();
        for (Edge e : edges) {
            if (e.source() == v) {
                vs.add(e.target());
            }
        }
        return vs;
    }

    public static List<Vertex> DFTrav(EdgeListGraph g, Vertex u) {
        List<Vertex> vs = new LinkedList<>();
        DFTrav(g, u, vs);
        return vs;
    }

    private static void DFTrav(EdgeListGraph g, Vertex u, List<Vertex> vs) {
        vs.add(u);
        for (Vertex v : g.neighbours(u)) {
            if (!vs.contains(v)) {
                DFTrav(g, v, vs);
            }
        }
    }

    public static List<Vertex> BFTrav(EdgeListGraph g, Vertex u) {
        List<Vertex> vs = new LinkedList<>();
        BFTrav(g, u, vs);
        return vs;
    }

    private static void BFTrav(EdgeListGraph g, Vertex u, List<Vertex> vs) {
        List<Vertex> q = new LinkedList<>();
        q.add(u);

        while (!q.isEmpty()) {
            Vertex current = q.remove(0);
            if (!vs.contains(current)) {
                vs.add(current);
                for (Vertex v : g.neighbours(current)) {
                    q.add(v);
                }
            }
        }
    }

    public static EdgeListGraph transitiveClosure(EdgeListGraph g) {
        // don't alter original graph
        EdgeListGraph h = g.makeCopy();

        // collected logic into inner if statement
        // slower than book version, but clearer IMO.
        for (Vertex i : h.vertices) {
            for (Vertex j : h.vertices) {
                for (Vertex k : h.vertices) {
                    if (i != j &&
                        j != k &&
                        i != k && // need this too, because != isn't transitive. eg 1 != 2, 2 != 1, 1 == 1.
                        h.hasEdge(i, j) != null &&
                        h.hasEdge(j, k) != null &&
                        h.hasEdge(i, k) == null) {
                            h.addEdge(i, k);
                    }
                }
            }
        }
        return h;
    }

    private EdgeListGraph makeCopy() {
        EdgeListGraph h = new EdgeListGraph(this.directed);
        for (Edge e : this.edges) {
            // cant use addEdge method as it creates duplicates
            // since we get *each edge*, undirected graphs
            // create reverse of each edge.
            if (!h.vertices.contains(e.source())) {
                h.vertices.add(e.source());
            }
            if (!h.vertices.contains(e.target())) {
                h.vertices.add(e.target());
            }
            h.edges.add(new Edge(e.source(), e.target()));
        }
        return h;
    }
}
