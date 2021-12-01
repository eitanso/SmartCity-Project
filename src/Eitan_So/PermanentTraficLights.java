package Eitan_So;

public class PermanentTraficLights extends TrafficLights implements Runnable{
	public PermanentTraficLights(Junction junction,DrivingGame drivingGame) {
		super(junction, drivingGame );
	}

	@Override
	public void greenLight() {
		switcher();
	
		if(this.IsGreenLight==1) {
		int idnum = this.getJunction().getEnteringRoads().indexOf(this.getCurrentGreen());
		if (idnum + 1 >= this.getJunction().getEnteringRoads().size()) {
			setCurrentGreen(this.getJunction().getEnteringRoads().get(0));
		} else {
			setCurrentGreen(this.getJunction().getEnteringRoads().get(idnum + 1));
		}
		System.out.println(toString());
		
		}
	}
	

	@Override
	public String toString() {
		return "permanent " + super.toString();
	}
	public int getisgreenlight() {
		return IsGreenLight;
		
	}

}
