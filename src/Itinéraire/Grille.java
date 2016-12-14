package Itinéraire;

import java.util.ArrayList;
import java.util.Random;

public class Grille {

	//dimension de la grille
	private Integer n;
	// contenu de la grille
	private Noeud[][] grille;
	public Random rand;
	
	public Grille(Integer n) {
		super();
		this.n = n;
		this.grille = new Noeud[n][n];
		for (int i=0; i<n; i++){
			for (int j=0; j<n; j++){
				this.grille[i][j] = new Noeud();
			}
		}
		this.rand = new Random();
	}
	
	public Integer getdim(){
		return this.n;
	}
	
	public Noeud get(int i, int j){
		return this.grille[i][j];
	}
	
	public void mountain(int i, int j, double height){
		this.get(i, j).setAltitude(height);
		if (i-1>=0){
			this.get(i-1, j).setAltitude(  0.5*this.get(i-1, j).getAltitude() + 0.5*height  );
		}
		if (i+1<n){
			this.get(i+1, j).setAltitude(  0.5*this.get(i+1, j).getAltitude() + 0.5*height  );
		}
		if (j-1>=0){
			this.get(i, j-1).setAltitude(  0.5*this.get(i, j-1).getAltitude() + 0.5*height  );
		}
		if (j+1<n){
			this.get(i, j+1).setAltitude(  0.5*this.get(i, j+1).getAltitude() + 0.5*height  );
		}
		return;
	}
	
	public void largemount(int i, int j, double height){
		this.get(i, j).setAltitude(height);
		if (i-1>=0){
			this.mountain(i-1, j, 0.4*height);
		}
		if (i+1<n){
			this.mountain(i+1, j, 0.4*height);
		}
		if (j-1>=0){
			this.mountain(i, j-1, 0.4*height);
		}
		if (j+1<n){
			this.mountain(i, j+1, 0.4*height);
		}
		return;
	}
	
	public void touristize(int i, int j, double tourist){
		this.get(i, j).setTourist(tourist);
	}
	
	public String nextdir(boolean trendtop, boolean trendright){
		double choice = rand.nextDouble();
		if (trendtop){
			if (trendright){
				if (choice<0.3){
					return "TOP";
				}
				if (choice<0.7){
					return "RIGHT";
				}
				if (choice<0.85){
					return "BOTTOM";
				}
				return "LEFT";
			} else {
				if (choice<0.4){
					return "TOP";
				}
				if (choice<0.7){
					return "LEFT";
				}
				if (choice<0.85){
					return "BOTTOM";
				}
				return "RIGHT";
			}
		} else {
			if (trendright){
				if (choice<0.4){
					return "BOTTOM";
				}
				if (choice<0.7){
					return "RIGHT";
				}
				if (choice<0.85){
					return "TOP";
				}
				return "LEFT";
			} else {
				if (choice<0.4){
					return "BOTTOM";
				}
				if (choice<0.7){
					return "LEFT";
				}
				if (choice<0.85){
					return "TOP";
				}
				return "RIGHT";
			}
		}
	}
	
	public String returndir(int deltai, int deltaj){
		double choice = rand.nextDouble();
		try {
			if (choice < (deltai / (deltai+deltaj))){
				return "X";
			}
			return "Y";
		} catch (Exception e) {
			return "X";
		}
		
	}
	
	public void moveTop(int i, int j, ArrayList<Integer[]> chemin){
		if (j+1<n){
			Integer[] tab = {i, j+1};
			chemin.add(tab);
		}
		return;
	}
	
	public void moveRight(int i, int j, ArrayList<Integer[]> chemin){
		if (i+1<n){
			Integer[] tab = {i+1, j};
			chemin.add(tab);
		}
		return;
	}
	
	public void moveBottom(int i, int j, ArrayList<Integer[]> chemin){
		if (j>0){
			Integer[] tab = {i, j-1};
			chemin.add(tab);
		}
		return;
	}
	
	public void moveLeft( int i, int j, ArrayList<Integer[]> chemin){
		if (i>0){
			Integer[] tab = {i-1, j};
			chemin.add(tab);
		}
		return;
	}
	
	public CheminLong parcours(Sport sport, double temps, int i0, int j0){
		ArrayList<Integer[]> chemin = new ArrayList<Integer[]>();
		double fromstart = 0;
		int i=i0;
		int j=j0;
		boolean trendtop = rand.nextBoolean();
		boolean trendright = rand.nextBoolean();
		while (fromstart<temps/1.5){
			String dir = this.nextdir(trendtop, trendright);
			if (dir=="TOP"){
				fromstart = fromstart + 1/(sport.getVm());
				this.moveTop(i, j, chemin);
				j=j+1;
			}
			if (dir=="BOTTOM"){
				fromstart = fromstart + 1/(sport.getVm());
				this.moveBottom(i, j, chemin);
				j=j-1;
			}
			if (dir=="LEFT"){
				fromstart = fromstart + 1/(sport.getVm());
				this.moveLeft(i, j, chemin);
				i=i-1;
			}
			if (dir=="RIGHT"){
				fromstart = fromstart + 1/(sport.getVm());
				this.moveRight(i, j, chemin);
				i=i+1;
			}
		}
		while (fromstart<=temps && ( !(i==i0 && j==j0) )){
			String axe = returndir(i-i0, j-j0);
			if (axe=="X"){
				if (trendright){
					fromstart = fromstart + 1/(sport.getVm());
					this.moveLeft(i, j, chemin);
					i=i-1;
				} else {
					fromstart = fromstart + 1/(sport.getVm());
					this.moveRight(i, j, chemin);
					i=i+1;
				}
			} else {
				if (trendtop){
					fromstart = fromstart + 1/(sport.getVm());
					this.moveBottom(i, j, chemin);
					j=j-1;
				} else {
					fromstart = fromstart + 1/(sport.getVm());
					this.moveTop(i, j, chemin);
					j=j+1;
				}
			}
		}
		if (fromstart>temps){
			System.out.println("		Chemin invalide --> nouvelle recherche en cours...");
			return parcours(sport, temps, i0, j0);
		}
		return new CheminLong(chemin, fromstart);
	}
	
	public double eval(CheminLong cheminlong, double temps) {
		double eval = 0;
		ArrayList<Integer[]> chemin = cheminlong.getChemin();
		double fromstart = cheminlong.getTemps();
		for (Integer[] tab : chemin){
			eval = eval + (1/(chemin.size()))* (this.get(tab[0], tab[1]).getTourist());
		}
		eval = eval + 30*(fromstart/temps);
		return eval;
	}
	
	public CheminLong chooseChemin(ArrayList<CheminLong> cheminlongs, double temps){
		double evalmax = 0;
		CheminLong chemin = null;
		for (CheminLong cheminlong : cheminlongs){
			double eval = eval(cheminlong, temps);
			if (eval>evalmax){
				evalmax = eval;
				chemin = cheminlong;
			}
		}
		return chemin;
	}
	
	public void displayChemin(CheminLong chemin){
		System.out.println("	Voici l'itinéraire retenu : ");
		int l = chemin.getChemin().size();
		for (int k=0; k<l; k++){
			Integer[] point = chemin.getChemin().get(k);
			System.out.println("Etape "+((Integer) k).toString()+" : ("+point[0].toString()+", "+point[1].toString() + ")");
		}
		System.out.println("Temps de parcours estimé : "+((Double) (60*chemin.getTemps())).toString() + " min");
		System.out.println("Amusez vous bien, et à très bientôt !");
	}
	
}
