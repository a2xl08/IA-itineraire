package Itinéraire;

import java.util.ArrayList;

public class CheminLong {
	
	ArrayList<Integer[]> chemin;
	double temps;
	
	public CheminLong(ArrayList<Integer[]> chemin, double temps) {
		super();
		this.chemin = chemin;
		this.temps = temps;
	}

	public ArrayList<Integer[]> getChemin() {
		return chemin;
	}

	public double getTemps() {
		return temps;
	}
	
	public String toString(){
		return "coucou";
	}
	
}
