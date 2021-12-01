package Eitan_So;

public class Road {
	private double length;
	private Junction start;
	private Junction end;

//	public String setRoad1(Junction Start , Junction End) {
//		if (Start==End) {
//			System.out.println("wrong road! swiching junction to creat  a correct one");
//			this.end=new Junction();
//		}
//		else {
//			this.end=End;
//		}
//		
//		this.start=Start;
//			
//		start.getExitingRoads().add(this);
//		
//		end.getEnteringRoads().add(this);
//			
//		length=start.calcDistance(End);
//		
//		System.out.println(this);
//		
//		String anewroad=(String)( "Road from Junction " + String.valueOf(start.getId()) + " to Junction " + String.valueOf(end.getId())) ;
//		
//		return anewroad;
//		
//	}
//	
//	
//	
//	public String getroad1() {
//		return this.setRoad1(start, end);
//	}

	public Road() {
		if (start == end) {
			System.out.println("wrong road! swiching junction to creat  a correct one");
			this.end = new Junction();
		} else {
			this.end = getEnd();
		}

		this.start = getStart();

		start.getExitingRoads().add(this);

		end.getEnteringRoads().add(this);

		length = start.calcDistance(end);

		System.out.println(this);

	}
	
	public int isstartingjunctiongreen() {
		return this.start.getLight().getisgreenlight();
	}

	
	public int isexitingjunctiongreen() {
	
		if (this.end.getLight()==null){
			return 1;
		}
		return this.end.getLight().getisgreenlight();
	}

	public double getLength1() {
		return length;
	}

	public Junction getStart1() {
		return start;
	}

	public Junction getEnd1() {
		return end;
	}

	public String ToString() {

		return "Road from Junction " + String.valueOf(start.getId()) + " to Junction " + String.valueOf(end.getId());

	}

	public Road(Junction Start, Junction End) {
		if (Start == End) {
			System.out.println("Road cannot connect to itself,the end junction has been replaced with");
			this.end = new Junction();
		} else {
			this.end = End;
		}

		this.start = Start;

		start.getExitingRoads().add(this);

		end.getEnteringRoads().add(this);

		length = start.calcDistance(End);

		System.out.println("Creating " + this + ", length: " + String.format("%.2f", length));

	}

	public double getLength() {
		return length;
	}

	public Junction getStart() {
		return start;
	}

	public Junction getEnd() {
		return end;
	}

	@Override
	public String toString() {

		return "Road from Junction " + String.valueOf(start.getId()) + " to Junction " + String.valueOf(end.getId());

	}

	public void setLength(double length) {
		length = Math.sqrt((start.axisy - end.axisy) * (start.axisy - end.axisy)
				+ (start.axisx - end.axisx) * (start.axisx - end.axisx));

		this.length = length;
	}

}
