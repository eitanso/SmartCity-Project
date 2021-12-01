package Eitan_So;
import java.util.ArrayList;

public class Junction extends Point {
	private ArrayList<Road> enteringRoads;
	private ArrayList<Road> exitingRoads;
	private TrafficLights light;
	
	
	 

	public Junction() {
		super();
		this.enteringRoads = new ArrayList<Road>();
		this.exitingRoads = new ArrayList<Road>();
		light = null;

	}

	public Junction(double x, double y) {
		super(x, y);
		this.enteringRoads = new ArrayList<Road>();
		this.exitingRoads = new ArrayList<Road>();
		this.id = counter;
		//System.out.println("creating junction "+id+" at point "+"("+  x+","+y+")");
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Road> getEnteringRoads() {
		return enteringRoads;
	}

	public void setEnteringRoads(ArrayList<Road> enteringRoads) {
		this.enteringRoads = enteringRoads;
	}

	public ArrayList<Road> getExitingRoads() {
		return exitingRoads;
	}

	public void setExitingRoads(ArrayList<Road> exitingRoads) {
		this.exitingRoads = exitingRoads;
	}

	public void addEnteringRoad(Road road) {
		this.enteringRoads.add(road);
	}

	public void addExitingRoad(Road road) {
		this.exitingRoads.add(road);
	}

	public TrafficLights getLight() {

		return light;
	}

	public void setLight(TrafficLights light) {
		this.light = light;
	}

	public int getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Junction " + id;
	}


}
