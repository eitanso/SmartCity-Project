package Eitan_So;

public class DrivingGame {
	private Map map;
	private Vehicle[] cars;
	private static int VehiclesID = 0;
	private String CarsName;
	private Timer timer;
	private int carCounter = 0;
	private boolean ifTheGameFinish = false;

	public DrivingGame(int JunctionNum, int CarNum) {
		this.map = new Map(JunctionNum,this);
		this.cars = new Vehicle[CarNum];
		this.timer = new Timer(this);
		BuildNewCar();
		

	}

	public  synchronized boolean isIfTheGameFinish() {
		return ifTheGameFinish;
	}

	public synchronized void carCounter() {
		carCounter++;
		if (carCounter == this.cars.length) {
			this.ifTheGameFinish= true;
			this.timer.setIfTimeRun(false);
			
			
			System.out.println("All vehicles have arrived to their destination.");
		}
	}

	private void BuildNewCar() {
		for (int i = 0; i < this.cars.length; i++) {

			this.cars[i] = new Vehicle(map,this);

			this.CarsName = String.valueOf(VehiclesID);
			VehiclesID++;
//		System.out.println("creating  vehicle "+(i+1)+" Speed: "+cars[i].getspeed()+" path: "+cars[i].getPathString());
		}

	}

	public String toString() {
		String.valueOf(cars);
		return "the cars: " + cars;
	}

	public void play() {
		System.out.println(timer.toString());
		timer.setPriority(10);
		this.timer.start();
		for (int j = 0; j < this.cars.length; j++) {
			this.cars[j].start();
		}

		for (Junction j : map.getJunctions()) {
			if (j.getLight() != null) {
				j.getLight().start();

			}
		}
//
	}
	
	public void neighbors() {
		
		//Junction
		
	}

}
