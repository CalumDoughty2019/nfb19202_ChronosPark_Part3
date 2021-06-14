public class ShortestPath {

    public static final int NODES = 9;

    public int minDistance(int dist[], Boolean sptSet[]){
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for(int n = 0; n < NODES; n++){
            if(sptSet[n] == false && dist[n] <= min){
                min = dist[n];
                minIndex = n;
            }
        }
        return minIndex;
    }

    public void printSolution(int dist[], int n){
        System.out.println("Node distance from source");

        for(int i = 0; i < NODES; i++){
            System.out.println(i + " tt " + dist[i]); //tt = timetaken
        }
    }

    public void dijkstra(int graph[][], int src){
        int dist[] = new int[NODES];

        Boolean sptSet[] = new Boolean[NODES];

        for(int i = 0; i < NODES; i++){
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;

        for(int count = 0; count < NODES -1; count++){
            int u = minDistance(dist, sptSet);

            sptSet[u] = true;

            for(int v = 0; v < NODES; v++){
                if(!sptSet[v] && graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v]){
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        printSolution(dist, NODES);

    }

}
