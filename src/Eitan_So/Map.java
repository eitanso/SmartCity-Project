package Eitan_So;

import java.util.*;

public class Map {
	
	double pathDistance = 0;
	ArrayList<Junction> junctions = new ArrayList<Junction>();
	ArrayList<Road> roads = new ArrayList<Road>();
	ArrayList<TrafficLights> trafficLight = new ArrayList<TrafficLights>();
	private DrivingGame drivingGame;
	private int countbooli;
	

	public Map(int NumOfJunctions,DrivingGame drivingGame) {
		this.drivingGame=drivingGame;
		for (int i = 0; i < NumOfJunctions; i++) {
			Junction junctionNew = new Junction();
			junctions.add(junctionNew);
		}
		addRoads();
		this.addLights();

	}

	public Map(ArrayList<Junction> junctions, ArrayList<Road> roads) {
		this.junctions = junctions;
		this.roads = roads;
		this.addLights();
	}

	public void addLights() {
		for (int ramzor = 0; ramzor < junctions.size(); ramzor++) {
		boolean first=new Random().nextBoolean();
		boolean second=new Random().nextBoolean();
		
			if (first && second) {
				boolean myRand = new Random().nextBoolean();
				if (myRand == true) {
					PermanentTraficLights lights = new PermanentTraficLights(junctions.get(ramzor),drivingGame);
					trafficLight.add(lights);
					this.junctions.get(ramzor).setLight(lights);
					
//					System.out.println("zdsasasasasa*****"+lights);
					//System.out.println(lights);
				} else {
					RandomTraficLights lights = new RandomTraficLights(junctions.get(ramzor), drivingGame);
					//System.out.println("zdsasasasasa*****"+lights);
					this.junctions.get(ramzor).setLight(lights);
					//System.out.println("*****"+lights);
				}
			}
		}
		}
	//}

	public void addRoads() {
		for (Junction j : this.junctions) {
			for (Junction k : this.junctions) {
				if (j != k && new Random().nextBoolean()) {
					roads.add(new Road(j, k));
				}
			}
		}
	}

	public Road[] Path() {
		double pathDistance = 0;
		Road[] Path = new Road[4];
		Junction ranJun = (junctions.get((int) (Math.random() * junctions.size())));
		for (int i = 0; i < 4; i++) {
			if (!ranJun.getExitingRoads().isEmpty()) {
				Road newRoad = ranJun.getExitingRoads().get((int) (Math.random() * ranJun.getExitingRoads().size()));
				pathDistance = pathDistance + newRoad.getLength();
				Path[i] = newRoad;
				ranJun = newRoad.getEnd();
			}

		}
		return Path;

	}

	public double getPathDistance() {
		return pathDistance;
	}

	public ArrayList<Junction> getJunctions() {
		return junctions;
	}

	public ArrayList<TrafficLights> getTrafficLight() {
		return trafficLight;
	}
	public int [] dijstra(int s){
		//array G = this.junctions
		final int [] dist = new int [this.junctions.size()];  // shortest known distance from "s"
		final int [] pred = new int [this.junctions.size()];  // preceeding node in path
		final boolean [] visited = new boolean [junctions.size()]; // all false initially

		for (int i=0; i<dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[s] = 0;

		for (int i=0; i<dist.length; i++) {
			 int next = minVertex (dist, visited);
			visited[next] = true;

			// The shortest path to next is dist[next] and via pred[next].

			 ArrayList<Junction> n = getJunctions();
					// G.neighbors (next); 
			for (int q=0; q<n.size(); q++) {
				int v = q;
				 int d = (int) (dist[next] + this.junctions.get(next).calcDistance(this.junctions.get(v)));

						//G.getWeight(next,v);
				if (dist[v] > d) {
					dist[v] = d;
					pred[v] = next;
				}
			}
		}
		return pred;  // (ignore pred[s]==0!)
	}

	private static int minVertex (int [] dist, boolean [] v) {
		int x = Integer.MAX_VALUE;
		int y = -1;   // graph not connected, or no unvisited vertices
		for (int i=0; i<dist.length; i++) {
			if (!v[i] && dist[i]<x) {y=i; x=dist[i];}
		}
		return y;
	}

	public static void printPath (Junction junction, int [] pred, int s, int e) {
		 //java.util.ArrayList path = new java.util.ArrayList();
		int x = e;
		while (x!=s) {
			//path.add (0, Junction.counter);
			x = pred[x];
		}
//		path.add (0, G.getLabel(s));
//		System.out.println (path);
	}

public String calcShortestPath(Junction junction, Junction junction2) {

		this.dijstra(junction.getId());
		
		int correntroad =countbooli;
		return this.Path()[correntroad].toString();

}
}

