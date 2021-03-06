package Itinéraire;

import java.util.ArrayList;
import java.util.Scanner;

public class Exe {

	public static void main(String[] args) {

		// définition des sports
		Sport marche = new Sport("marche", 7);
		Sport course = new Sport("course", 11);
		Sport cyclisme = new Sport("cyclisme", 20);
		@SuppressWarnings("unused")
		Sport roller = new Sport("roller", 15);
		
		// définition de l'utilisateur
		User user = new User("Toto", new ArrayList<Sport>());
		user.getSports().add(marche);
		user.getSports().add(course);
		user.getSports().add(cyclisme);
		
		// définition de la grille;
		Grille magrille = new Grille(60, 0.1);
			// Vous pouvez changer les reliefs et les points touristiques ici
		for (int k=0; k<0.4*magrille.getdim(); k++){
			magrille.mountain(
					magrille.rand.nextInt(magrille.getdim()), 
					magrille.rand.nextInt(magrille.getdim()), 
					0.5*magrille.rand.nextDouble());
		}
		
		for (int k=0; k<0.1*magrille.getdim(); k++){
			magrille.largemount(
					magrille.rand.nextInt(magrille.getdim()), 
					magrille.rand.nextInt(magrille.getdim()), 
					0.5*magrille.rand.nextDouble());
		}
		for (int k=0; k<3*magrille.getdim(); k++){
			magrille.touristize(
					magrille.rand.nextInt(magrille.getdim()), 
					magrille.rand.nextInt(magrille.getdim()), 
					10+15*magrille.rand.nextDouble());
		}
		
		
		// Execution du programme
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Bonjour "+user.getName()+" !\n");
		System.out.println("Quel sport fait-on aujourd'hui ?");
		for (int i=0; i<user.getSports().size(); i++){
			System.out.println("	"+((Integer) i).toString() + " : " + user.getSports().get(i).getName());
		}
		String entry = sc.nextLine();
		Integer choix = Integer.parseInt(entry);
		System.out.println("Combien de temps avez-vous ? (min)");
		String entry2 = sc.nextLine();
		Double minutes = Double.parseDouble(entry2);
		Double temps = (double) (minutes/60);
		System.out.println("C'est parti ! Recherche de chemins en cours...");
		ArrayList<CheminLong> chemins = new ArrayList<CheminLong>();
		for (int i=0; i<10; i++){
			System.out.println("	Recherche du chemin n°" + (((Integer) (i+1)).toString()) + "...");
			chemins.add(magrille.parcours(user.getSports().get(choix), temps, magrille.getdim()/2, magrille.getdim()/2));
		}
		System.out.println("	Choix du chemin...");
		Integer select = magrille.chooseChemin(chemins, temps);
		System.out.println("	Le chemin retenu est le n°"+(select+1));
		CheminLong cheminfinal = new CheminLong 
				(chemins.get(select).getChemin(), 
				chemins.get(select).getTemps());
		magrille.displayChemin(cheminfinal);
	}

}
