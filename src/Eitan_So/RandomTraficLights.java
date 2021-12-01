package Eitan_So;

import java.util.Random;

public class RandomTraficLights extends TrafficLights {
	public RandomTraficLights(Junction junction, DrivingGame drivingGame) {
		super(junction, drivingGame);

	}
	

	public void greenLight() {
		int size = getJunction().getEnteringRoads().size();
		Random random = new Random();
		int index = random.nextInt(size);
		Road road = getJunction().getEnteringRoads().get(index);
		setCurrentGreen(road);
		System.out.println(toString());
		switcher();
if(this.IsGreenLight==1) {
	setCurrentGreen(road);
		
			
			
			
		}

		
	}

	public String toString() {
		return "Random " + super.toString();
	}
	
	public int getisgreenlight() {
		return IsGreenLight;
		
	}
}
