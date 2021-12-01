package Eitan_So;

public abstract class TrafficLights extends Thread {
	protected int IsGreenLight=1;
	private int dilay;
	//private int peima;
	private Road currentGreen;
	private Junction newjunction;
	private Junction start;
	private Junction end;
	String zen="";
	private int x = (int) ((Math.random() * (2 - 1)) + 1);
	private int z = (int) ((Math.random() * (5 - 1)) + 1);
	private DrivingGame drivingGame;
	public boolean booli =false;
	public TrafficLights(Junction junction, DrivingGame drivingGame) {
		this.drivingGame=drivingGame;
		dilay = (int) ((Math.random() * 2) + 2);
		this.newjunction=junction;
		junction.setLight(this);
		greenLight();	


	}




	public void run() {

		while( !drivingGame.isIfTheGameFinish()) {

			try {
				sleep(dilay*1000);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			if (  !drivingGame.isIfTheGameFinish()) {
				greenLight();
			}

		}

	}



	protected void switcher() {
		
		this.IsGreenLight*=-1;
		
		

	}
public int getisgreenlight() {
	return IsGreenLight;
	
}






	public int getDilay() {
		return dilay;
	}
	public void setDilay(int dilay) {
		this.dilay = dilay;
	}
	@Override
	public String toString() {
		return "TrafficLights "+ newjunction+ ", delay= "+ dilay+": green light is  on " + currentGreen;

	}
	//	public int getPeima() {
	//		return this.timer.getTimerSec();
	//}
	//public void setPeima(int peima) {
	//	this.peima = peima;
	//}
	public Road getCurrentGreen() {
		return currentGreen;
	}
	public void setCurrentGreen(Road currentGreen) {
		this.currentGreen = currentGreen;
	}
	public Junction getJunction() {
		return newjunction;
	}
	public void setJunction(Junction junction) {
		this.newjunction = junction;
	}
	public abstract  void greenLight();
}
