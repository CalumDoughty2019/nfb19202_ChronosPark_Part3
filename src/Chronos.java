import Part3.Edge;
import Part3.Vertex;

import java.util.ArrayList;
import java.util.List;

public class Chronos {
    static Vertex entrance = new Vertex(0, "Entrance");
    static Vertex TowerOfTerror = new Vertex(1, "Tower of Terror");
    static Vertex TheIronJaws = new Vertex(2, "The Iron Jaws");
    static Vertex CloisterOfCruelty = new Vertex(3, "Cloister of Cruelty");
    static Vertex PonyJousts = new Vertex(4, "Pony Jousts");
    static Vertex MysticFortunes = new Vertex(5, "Mystic Fortunes");

    static Vertex CrisisAtFarpoint = new Vertex(6, "Crisis at Farpoint");
    static Vertex BuildABot = new Vertex(7, "Build a Bot");
    static Vertex LaserLock = new Vertex(8, "Laser Lock");
    static Vertex TrenchChase = new Vertex(9, "Trench Chase");
    static Vertex RobotConflicts = new Vertex(10, "Robot Conflicts");

    static Vertex RexRampage = new Vertex(11, "Rex Rampage");
    static Vertex PetASaur = new Vertex(12, "Pet a Saur");
    static Vertex SauroPods = new Vertex(13, "Sauro Pods");
    static Vertex RaptorRaces = new Vertex(14, "Raptor Races");
    static Vertex HatchlingNest = new Vertex(15, "Hatchling Nest");

    static Vertex HighNoon = new Vertex(16, "High Noon");
    static Vertex HallOMirrors = new Vertex(17, "Hall O Mirrors");
    static Vertex SteampunkCups = new Vertex(18, "Steampunk Cups");
    static Vertex ThePainTrain = new Vertex(19, "The Pain Train");
    static Vertex TheDescent = new Vertex(20, "The Descent");


    public static void generatePath(EdgeListGraph g){

        //entrance to
        g.addEdge(entrance, TowerOfTerror, 320);
        //medieval
        g.addEdge(TowerOfTerror, TheIronJaws, 50);
        g.addEdge(TheIronJaws, CloisterOfCruelty, 35);
        g.addEdge(CloisterOfCruelty, PonyJousts, 63);
        g.addEdge(PonyJousts, MysticFortunes, 15);

        //entrance to
        g.addEdge(entrance, CrisisAtFarpoint, 400);
        //futuristic
        g.addEdge(CrisisAtFarpoint, BuildABot, 15);
        g.addEdge(BuildABot, LaserLock, 25);
        g.addEdge(LaserLock, TrenchChase, 40);
        g.addEdge(TrenchChase, RobotConflicts, 15);

        //entrance to
        g.addEdge(entrance, RexRampage, 420);
        //jurassic
        g.addEdge(RexRampage, PetASaur, 45);
        g.addEdge(PetASaur, SauroPods, 60);
        g.addEdge(SauroPods, RaptorRaces, 23);
        g.addEdge(RaptorRaces, HatchlingNest, 28);

        //entrance to
        g.addEdge(entrance, HighNoon, 500);
        //industrial
        g.addEdge(HighNoon, HallOMirrors, 25);
        g.addEdge(HallOMirrors, SteampunkCups, 32);
        g.addEdge(SteampunkCups, ThePainTrain, 70);
        g.addEdge(ThePainTrain, TheDescent, 105);


        //path between areas
        g.addEdge(TowerOfTerror, CrisisAtFarpoint, 80);
        g.addEdge(CrisisAtFarpoint, RexRampage, 20);
        g.addEdge(RexRampage, HighNoon, 80);
    }

    private int find(int[] parent, int source) {
        if(parent[source] != source){
            return find(parent, parent[source]);
        }
        return source;
    }



    public static void dijkstraPath(ArrayList<Ride> ridesArray) {
        EdgeListGraph g = new EdgeListGraph(false);
        generatePath(g);

        g.dijkstra(entrance, ridesArray);
        //System.out.println();
        Menu menu = new Menu();
        menu.pressEnterToContinue();
    }

    public static void personalisedPath(ArrayList<Ride> ridesArray, ArrayList<Ride> collatedRides){
        if(collatedRides.isEmpty()){
            System.out.println("**** No personalised ride list currently exists. Please see step 2 in menu ****");
            System.out.println();
        }else{
            EdgeListGraph g = new EdgeListGraph(false);
            generatePath(g);

            g.personalised(entrance, ridesArray, collatedRides);
            //System.out.println();
        }
        //System.out.println();
//        Menu menu = new Menu();
//        menu.pressEnterToContinue();
    }

    public static void recommendedPath(ArrayList<Ride> ridesArray, ArrayList<Ride> collatedRides){
        if(collatedRides.isEmpty()){
            System.out.println("**** No personalised ride list currently exists. Please see step 2 in menu ****");
            System.out.println();
        }else{
            EdgeListGraph g = new EdgeListGraph(false);
            generatePath(g);

            g.recommended(entrance, ridesArray, collatedRides);
            //System.out.println();
        }
        //System.out.println();
//        Menu menu = new Menu();
//        menu.pressEnterToContinue();
    }
}
