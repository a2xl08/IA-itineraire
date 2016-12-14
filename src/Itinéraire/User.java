package Itinéraire;

import java.util.ArrayList;

public class User {

	// nom de l'utilisateur
	private String name;
	// date de naissance
	private String birthday;
	// poids
	private double poids;
	// objectif de piods
	private double objectif_poids;
	// longitude et latitude du lieu de vie de l'utilisateur
	private double homelong;
	private double homelat;
	// sports préférés
	private ArrayList<Sport> sports;
	// Historique d'activités
	private ArrayList<ArrayList<String>> historique;
	
	public User(String name, ArrayList<Sport> sports) {
		super();
		this.name = name;
		this.sports = sports;
		this.historique = new ArrayList<ArrayList<String>>();
	}

	public User(String name, String birthday, double poids,
			ArrayList<Sport> sports) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.poids = poids;
		this.sports = sports;
		this.historique = new ArrayList<ArrayList<String>>();
	}

	public User(String name, String birthday, double poids,
			double objectif_poids, ArrayList<Sport> sports) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.poids = poids;
		this.objectif_poids = objectif_poids;
		this.sports = sports;
		this.historique = new ArrayList<ArrayList<String>>();
	}

	public User(String name, String birthday, double poids,
			double objectif_poids, double homelong, double homelat,
			ArrayList<Sport> sports) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.poids = poids;
		this.objectif_poids = objectif_poids;
		this.homelong = homelong;
		this.homelat = homelat;
		this.sports = sports;
		this.historique = new ArrayList<ArrayList<String>>();
	}

	public String getName() {
		return name;
	}

	public String getBirthday() {
		return birthday;
	}

	public double getPoids() {
		return poids;
	}

	public double getObjectif() {
		return objectif_poids;
	}

	public double getHomelong() {
		return homelong;
	}

	public double getHomelat() {
		return homelat;
	}

	public ArrayList<Sport> getSports() {
		return sports;
	}

	public ArrayList<ArrayList<String>> getHistorique() {
		return historique;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public void setObjectif(double objectif_poids) {
		this.objectif_poids = objectif_poids;
	}

	public void setHomelong(double homelong) {
		this.homelong = homelong;
	}

	public void setHomelat(double homelat) {
		this.homelat = homelat;
	}

	public void setSports(ArrayList<Sport> sports) {
		this.sports = sports;
	}
	
	
	
	
}
