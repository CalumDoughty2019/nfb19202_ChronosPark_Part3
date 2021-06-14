import java.util.HashMap;
import java.util.LinkedList;

public class Graph {

    //Give us a way of telling which nodes are connected to which other nodes
    //Node = current  //LinkedList = neighbours of current node
    private HashMap<Node, LinkedList<Node>> adjacencyMap;
    private boolean directed; //whether graph is directed or not

    //constructor
    public Graph(boolean directed){
        this.directed = directed;
        adjacencyMap = new HashMap<>();
    }

    //add an edges
    public void addEdge(Node source, Node destination, int distance){
        if(!adjacencyMap.keySet().contains(source)){
            adjacencyMap.put(source, null);
        }

        if(!adjacencyMap.keySet().contains(destination)){
            adjacencyMap.put(destination, null);
        }

        addEdgeHelper(source, destination, distance);

        if(!directed){
            addEdgeHelper(destination, source, distance);
        }
    }

    //helper
    public void addEdgeHelper(Node a, Node b, int distance){
        LinkedList<Node> temp = adjacencyMap.get(a);

        if(temp != null){
            temp.remove(b);
        }
        else{
            temp = new LinkedList<>();
        }

        temp.add(b);
        adjacencyMap.put(a, temp);
    }

    //print the map
    public void printEdges(){
        for(Node node : adjacencyMap.keySet()){
            System.out.print("The " + node.getName() + " has an edges towards: ");
            for(Node neighbour : adjacencyMap.get(node)){
                System.out.print(neighbour.getName() + " ");
            }
            System.out.println();
        }
    }

    //check nodes have an edges
    public boolean hasEdge(Node source, Node destination){
        return adjacencyMap.containsKey(source) && adjacencyMap.get(source).contains(destination);
    }

    //depth First Search
    public void depthFirstSearch(Node target){
        target.visit();
        System.out.print(target.getName() + " ");

        LinkedList<Node> allNeighbours = adjacencyMap.get(target);
        if(allNeighbours == null){
            return;
        }
        for(Node neighbour : allNeighbours){
            if(!neighbour.isVisited()){
                depthFirstSearch(neighbour);
            }
        }
    }

    //breadth First Search
    public void breadthFirstSearch(Node node){
        if(node == null){
            return;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);

        System.out.println("          Ride Name:         Queue Time:");
        System.out.println("          ----------         -----------");

        while(!queue.isEmpty()){
            Node current = queue.removeFirst();

            if(current.isVisited()){
                continue;
            }

            //Node entrance = queue.get(0);
            current.visit();
            if(current.getName() != "Entrance"){
//                System.out.print(current.getName());
//                System.out.printf("%20s%n", current.getQueueTime());
                System.out.printf("%20s %10sm %n", current.getName(), current.getQueueTime());
            }

            LinkedList<Node> allNeighbours = adjacencyMap.get(current);
            if(allNeighbours == null){
                continue;
            }

            for(Node neighbour : allNeighbours){
                if(!neighbour.isVisited()){
                    queue.add(neighbour);
                }
            }
        }
        System.out.println();
    }

}
