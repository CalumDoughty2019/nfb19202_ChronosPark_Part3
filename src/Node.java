public class Node {

    private int n;
    private String name;
    private int queueTime;
    private boolean visited;

    public Node(int n, String name, int queueTime){
        this.n = n;
        this.name = name;
        this.queueTime = queueTime;
        visited = false;
    }

    public void visit(){
        visited = true;
    }

    public void unvisit(){
        visited = false;
    }

    public String getName(){
        return name;
    }

    public int getQueueTime(){
        return queueTime;
    }

    public boolean isVisited(){
        return visited;
    }

}
