package Itinéraire;

public class Sport {

	// nom du sport
	private String name;
	// vitesse moyenne
	private double vm;
	
	public Sport(String name, double vm) {
		super();
		this.name = name;
		this.vm = vm;
	}

	public String getName() {
		return name;
	}

	public double getVm() {
		return vm;
	}
	
}
