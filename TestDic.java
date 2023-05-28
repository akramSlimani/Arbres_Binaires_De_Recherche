import java.util.Random;


public class TestDic {

	public static void main(String[] args) throws Exception {
		//creation d'un dictionnaire et ajout des éléments
		Dictionnaire dico = new Dictionnaire();
		  dico.ajouter(new Element(12,  1.3));
		  dico.ajouter(new Element(25, 2.1));
		  dico.ajouter(new Element(7, 3.6));
		  dico.ajouter(new Element(9, 4.3));
		  dico.ajouter(new Element(11, 5.2));
		  dico.ajouter(new Element(4, 6.8));
		  dico.ajouter(new Element(1, 7.4));

	        // afficher les elements dans l'ordre croissant des cles 
	        dico.affiche();
	        System.out.println();


	        // chercher des elemens 
	        System.out.println("Recherche des elements : ");
	        Noeud e1 = dico.recherche(11);
	        if (e1 != null) {
	            System.out.println("Element trouvé: " + e1.toString()); // affiche (11,5.2)
	        } else {
	            System.out.println("Element non trouvé");
	        }

	        Noeud e3 = dico.recherche(13);
	        if (e3 != null) {
	            System.out.println("Element trouvé: " + e3.toString());
	        } else {
	            System.out.println("Element introuvable"); // affiche Element non trouvé
	        }


	        System.out.println("-------Supprimer (1, 7.4)-----");
	        // Suppression de l'élément (1, 7.4)
	        dico.supprimer(new Element(1, 7.4));
	        dico.affiche();

	        System.out.println("ajouter d'autres elements (5, 112), (20, 123) et (22, 320)");
	        dico.ajouter(new Element(5, 112));
	        dico.ajouter(new Element(20, 123));
	        dico.ajouter(new Element(22, 320));

	        System.out.println("supprimer l'element (12, 1.3) ");
	        dico.supprimer(new Element(12, 1.3));

	        System.out.println("\nDico : ");
	        dico.affiche();
		

	}

}
