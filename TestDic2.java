import java.util.Random;

public class TestDic2 {
	
	public static void main(String[] args) {

		double Proba = 0.15;
		Element[] tableau = new Element[10000];
		Element[] aSupprimer = new Element[1000];
		Random random = new Random();

		// 10 000 éléments aleatoires
		for (int i = 0; i < 10000; i++) {
			int cle = random.nextInt(1000000);
			float val = random.nextInt(1000000);
			Element element = new Element(cle, val);
			tableau[i] = element;
		}
		// 1000 elements aleatoires a supprimer
		int c = 0;
		for (int i = 0; i < 10000 && c < 1000; i++) {
			if (random.nextDouble() < Proba) {
				aSupprimer[c] = tableau[i];
				c++;
			}
		}
		// creer un dictionnaire
		Dictionnaire dico = new Dictionnaire();
		for (int i = 0; i < 10000; i++) {
			dico.ajouter(tableau[i]);
		}
		System.out.println("\nHauteur = " + dico.affiche());

		// 1000 ajout
		long temps = 0;
		for (int i = 0; i < 1000; i++) {
			int key = random.nextInt(1000000);
			float val = random.nextInt(1000000);
			Element element = new Element(key, val);
			long debut = System.currentTimeMillis();
			dico.ajouter(element);
			long fin = System.currentTimeMillis();
			temps += fin - debut;
		}

		System.out.println("temps qu'il faut pour l'ajout : " + temps + " ms" + "\ntemps moyen : " + temps / 1000.0 + " ms");

		// 1000 supression
		long temps2 = 0;
		for (int i = 0; i < 1000; i++) {
			int index = (int) (Math.random() * 1000);
			Element element = aSupprimer[index];
			long debut = System.currentTimeMillis();
			dico.supprimer(element);
			long fin = System.currentTimeMillis();
			temps2 += fin - debut;
		}
		System.out.println("temps qu'il faut pour supprimer : " + temps2 + " ms" + "\ntemps moyen : " + temps2 / 1000.0 + " ms");
	}

}
