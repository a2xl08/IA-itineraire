package Itinéraire;

import java.util.ArrayList;
import java.util.Scanner;

public class Exe {

	public static void main(String[] args) {

		// définition des sports
		Sport marche = new Sport("marche", 8);
		Sport course = new Sport("course", 13);
		Sport cyclisme = new Sport("cyclisme", 25);
		Sport roller = new Sport("roller", 18);
		
		// définition de l'utilisateur
		User user = new User("Toto", new ArrayList<Sport>());
		user.getSports().add(marche);
		user.getSports().add(course);
		user.getSports().add(cyclisme);
		
		// définition de la grille;
		Grille magrille = new Grille(60);
			// Vous pouvez changer les reliefs et les points touristiques ici
		
		
		
		// Execution du programme
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
		Integer minutes = Integer.parseInt(entry2);
		Double temps = (double) (minutes/60);
		System.out.println("C'est parti ! Recherche de chemins en cours...");
		ArrayList<CheminLong> chemins = new ArrayList<CheminLong>();
		for (int i=0; i<10; i++){
			System.out.println("	Recherche du chemin n°" + (((Integer) (i+1)).toString()) + "...");
			chemins.add(magrille.parcours(user.getSports().get(choix), temps, magrille.getdim()/2, magrille.getdim()/2));
		}
		System.out.println("	Choix du chemin...");
		CheminLong cheminfinal = magrille.chooseChemin(chemins, temps);
		magrille.displayChemin(cheminfinal);
	}

}
