package Itinéraire;

public class Noeud {

	private double altitude;
	private double tourist;
	
	public Noeud() {
		super();
		this.altitude = 0;
		this.tourist = 0;
	}

	public double getAltitude() {
		return altitude;
	}

	public double getTourist() {
		return tourist;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

	public void setTourist(double tourist) {
		this.tourist = tourist;
	}
	
}
