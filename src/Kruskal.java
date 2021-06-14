import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Kruskal {

    public static class Graph{
        private int vertices;
        List<Edges> allEdges = new ArrayList<>();

        Graph(int vertices){
            this.vertices = vertices;
        }

        public void addEdge(int source, int destination, String name,  int distance, int queueTime){
            Edges edges = new Edges(source, destination, name, distance, queueTime);
            allEdges.add(edges);
        }

        public void kruskalMST(){
            PriorityQueue<Edges> pq = new PriorityQueue<Edges>(allEdges.size(), Comparator.comparingInt(o -> o.getDistance()));

            for(int i = 0; i < allEdges.size(); i++){
                pq.add(allEdges.get(i));
            }

            int[] parent = new int[vertices];

            makeSet(parent);

            List<Edges> mst = new ArrayList<>();

            int index = 0;
            while(index < vertices-1){
                Edges edges = pq.remove();
                int xSet = find(parent, edges.getSource());
                int ySet = find(parent, edges.getDestination());

                if(xSet == ySet){

                }else{
                    mst.add(edges);
                    index++;
                    union(parent, xSet, ySet);
                }
            }
            System.out.println("Minimum Spanning Tree: ");
            printGraph(mst);
        }

        private void printGraph(List<Edges> mst) {
            for(int i = 0; i < mst.size(); i++){
                Edges edges = mst.get(i);
//                System.out.println("Edges-" + i + " source: " + edges.getSource() +
//                        " destination" + edges.getDestination() + " weight: " + edges.getDistance()
//                );
                int hold = mst.get(0).getDistance() + mst.get(i).getDistance();
                System.out.println(edges.getName() + "         " + hold);
            }
        }

        private void union(int[] parent, int xSet, int ySet) {
            int xSetParent = find(parent, xSet);
            int ySetParent = find(parent, ySet);
            parent[ySetParent] = xSetParent;
        }

        private int find(int[] parent, int source) {
            if(parent[source] != source){
                return find(parent, parent[source]);
            }
            return source;
        }

        private void makeSet(int[] parent) {
            for(int i = 0; i < vertices; i++){
                parent[i] = i;
            }
        }
    }
}
