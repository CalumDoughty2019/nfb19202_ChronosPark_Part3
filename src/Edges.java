public class Edges {

    private int source;
    private int destination;
    private String name;
    private int distance;
    private int queueTime;

    public Edges(int source, int destination, String name, int distance, int queueTime){
        this.source = source;
        this.destination = destination;
        this.name = name;
        this.distance = distance;
        this.queueTime = queueTime;
    }

    public Edges(){

    }

    public int getSource(){
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getQueueTime() {
        return queueTime;
    }

    public void setQueueTime(int queueTime) {
        this.queueTime = queueTime;
    }
}
