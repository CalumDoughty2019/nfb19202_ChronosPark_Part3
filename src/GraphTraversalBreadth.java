/*
Week2 task
Part B
 */
public class GraphTraversalBreadth {

    public static void main(String[] args) {
        Graph graph = new Graph(true);

        Node Entrance = new Node(0, "Entrance", 0);

        //Medieval
        Node TowerOfTerror = new Node(1, "Tower of Terror", 15);
        Node TheIronJaws = new Node(2, "The Iron Jaws", 5);
        Node CloisterOfCruelty = new Node(3, "Cloister of Cruelty", 12);
        Node PonyJousts = new Node(4, "Pony Jousts", 6);
        Node MysticFortunes = new Node(5, "Mystic Fortunes", 22);

        //Futuristic
        Node CrisisAtFarpoint = new Node(6, "CrisisAtFarpoint", 35);
        Node BuildABot = new Node(7, "Build a Bot", 3);
        Node LaserLock = new Node(8, "Laser Lock", 15);
        Node TrenchChase = new Node(9, "Trench Chase", 21);
        Node RobotConflicts = new Node(10, "Robot Conflicts", 23);

        //Jurassic
        Node RexRampage = new Node(11, "Rex Rampage", 49);
        Node PetASaur = new Node(12, "Pet a Saur", 38);
        Node SauroPods = new Node(13, "Sauro Pods", 6);
        Node RaptorRaces = new Node(14, "Raptor Races", 17);
        Node HatchlingNest = new Node(15, "Hatchling Nest", 9);

        //Industrial
        Node HighNoon = new Node(16, "High Noon", 15);
        Node HallOMirrors = new Node(17, "Hall O Mirrors", 40);
        Node SteampunkCups = new Node(18, "Steampunk Cups", 16);
        Node ThePainTrain = new Node(19, "The Pain Train", 31);
        Node TheDescent = new Node(20, "The Descent", 37);


        //entrance to area
        graph.addEdge(Entrance, TowerOfTerror, 320);
        graph.addEdge(Entrance, CrisisAtFarpoint, 400);
        graph.addEdge(Entrance, RexRampage, 420);
        graph.addEdge(Entrance, HighNoon, 500);

        //area to area
        graph.addEdge(TowerOfTerror, CrisisAtFarpoint, 80);
        graph.addEdge(CrisisAtFarpoint, RexRampage, 20);
        graph.addEdge(RexRampage, HighNoon, 80);

        //medieval
        graph.addEdge(TowerOfTerror, TheIronJaws, 50);
        graph.addEdge(TheIronJaws, CloisterOfCruelty, 35);
        graph.addEdge(CloisterOfCruelty, PonyJousts, 63);
        graph.addEdge(PonyJousts, MysticFortunes, 15);

        //futuristic
        graph.addEdge(CrisisAtFarpoint, BuildABot, 15);
        graph.addEdge(BuildABot, LaserLock, 25);
        graph.addEdge(LaserLock, TrenchChase, 40);
        graph.addEdge(TrenchChase, RobotConflicts, 320);

        //jurassic
        graph.addEdge(RexRampage, PetASaur, 45);
        graph.addEdge(PetASaur, SauroPods, 60);
        graph.addEdge(SauroPods, RaptorRaces, 23);
        graph.addEdge(RaptorRaces, HatchlingNest, 28);

        //industrial
        graph.addEdge(HighNoon, HallOMirrors, 25);
        graph.addEdge(HallOMirrors, SteampunkCups, 32);
        graph.addEdge(SteampunkCups, ThePainTrain, 70);
        graph.addEdge(ThePainTrain, TheDescent, 105);


        //graph.printEdges();
        graph.breadthFirstSearch(Entrance);
    }

}
