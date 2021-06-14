public class ParkMapGraph {
    public static void main(String[] args) {

        System.out.println("");

        System.out.println("Kruskal:");
        Kruskal.Graph k = new Kruskal.Graph(21);

        //entrance to themed area (first ride of every area is the start of that area)
        k.addEdge(0, 1, "Tower of Terror", 320, 15);
        k.addEdge(0, 6, "Crisis at Farpoint", 400, 35);
        k.addEdge(0, 11, "Rex Rampage", 420, 49);
        k.addEdge(0, 16, "High Noon", 500, 15);

        //joins between area starts
        k.addEdge(1, 6, "Crisis at Farpoint", 80, 35);
        k.addEdge(6, 11, "Rex Rampage", 20, 49);
        k.addEdge(11, 16, "High Noon", 80, 15);

        //joins between internal areas
        //medieval
        k.addEdge(1, 2, "The Iron Jaws", 50, 5);
        k.addEdge(2, 3, "Cloister of Cruelty", 35, 12);
        k.addEdge(3, 4, "Pony Jousts", 63, 6);
        k.addEdge(4, 5, "Mystic Fortunes", 15, 22);

        //futuristic
        k.addEdge(6, 7, "Build a Bot", 15, 3);
        k.addEdge(7, 8, "Laser Lock", 25, 15);
        k.addEdge(8, 9, "Trench Chase", 40, 21);
        k.addEdge(9, 10, "Robot Conflicts", 15, 23);

        //jurassic
        k.addEdge(11, 12, "Pet a Saur", 45, 38);
        k.addEdge(12, 13, "Sauro Pods", 60, 6);
        k.addEdge(13, 14, "Raptor Races", 23, 17);
        k.addEdge(14, 15, "Hathcling Nest", 28, 9);

        //industrial
        k.addEdge(16, 17, "Hall O Mirrors", 25, 40);
        k.addEdge(17, 18, "Steampunk Cups", 32, 16);
        k.addEdge(18, 19, "The Pain Train", 70, 31);
        k.addEdge(19, 20, "The Descent", 105, 37);

        k.kruskalMST();
    }
}
