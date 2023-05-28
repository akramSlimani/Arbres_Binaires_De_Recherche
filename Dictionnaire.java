public class Dictionnaire {

	private Noeud racine;

	public Dictionnaire() {
		racine = null;
	}

	public Dictionnaire(Noeud n) {
		Element e = new Element();
		racine = new Noeud(e);
	}

	public Noeud getRacine() {
		return racine;
	}

	public void setRacine(Noeud n) {
		racine = n;
	}

	public static boolean estVide(Dictionnaire d) {
		return (d.racine == null);
	}	
	
	/*la méthode d'ajout*/
	public boolean ajouter(Element e) {
        if (racine == null) {
            racine = new Noeud(e);
            return true;
        } else {
            return ajouterRec(e, racine);
        }
    }

    private boolean ajouterRec(Element e, Noeud n) {
        if (e.getCle() == n.contenu.getCle()) {
            return false;
        }

        if (e.getCle() < n.contenu.getCle()) {
            if (n.noeudGauche == null) {
                n.noeudGauche = new Noeud(e);
                return true;
            } else {
                return ajouterRec(e, n.noeudGauche);
            }
        } else if (e.getCle() > n.contenu.getCle()) {
            if (n.noeudDroit == null) {
                n.noeudDroit = new Noeud(e);
                return true;
            } else {
                return ajouterRec(e, n.noeudDroit);
            }
        } else {
            return false;
        }
    }
    
    /*la methode de recherche */
    public Noeud recherche(int cle) {
        return rechercheRec(cle, racine);
    }

    private Noeud rechercheRec(int cle, Noeud n) {
        if (n == null) {
            return null; 
        } else if (cle < n.contenu.getCle()) {
            return rechercheRec(cle, n.noeudGauche);  
        } else if (cle > n.contenu.getCle()) {
            return rechercheRec(cle, n.noeudDroit);  
        } else {
            return n;  
        }
    }

    
    /* la methode d'affichage , affiche l'arbre et calcul sa hauteur */
    public int affiche() {
        if (racine == null) {
            System.out.println("dictionnaire vide.");
            return 0;
        } else {
            return afficheRec(racine);
        }
    }

    private int afficheRec(Noeud n) {
        if (n == null) {
            return 0;
        } else {
            int hauteurGauche = afficheRec(n.getNoeudGauche());
            System.out.print(n.contenu + " ");
            int hauteurDroite = afficheRec(n.getNoeudDroit());
            return 1 + Math.max(hauteurGauche, hauteurDroite);
        }
    }

	
	
	/*méthode de suppression */
	 public boolean supprimer(Element e) {
	        if (racine == null) {
	            return false; 
	        } else {
	            return supprimerRec(e, racine, null);
	        }
	    }

	    private boolean supprimerRec(Element e, Noeud n, Noeud parent) {
	        if (n == null) {
	            return false; 
	        } else if (e.getCle() < n.contenu.getCle()) {
	            return supprimerRec(e, n.noeudGauche, n);
	        } else if (e.getCle() > n.contenu.getCle()) {
	            return supprimerRec(e, n.noeudDroit, n);
	        } else { 
	            if (n.noeudGauche == null && n.noeudDroit == null) { 
	                if (parent == null) {
	                    racine = null; 
	                } else if (n == parent.noeudGauche) {
	                    parent.noeudGauche = null;
	                } else {
	                    parent.noeudDroit = null;
	                }
	            } else if (n.noeudGauche == null || n.noeudDroit == null) { 
	                Noeud enfant = (n.noeudGauche != null) ? n.noeudGauche : n.noeudDroit;
	                if (parent == null) {
	                    racine = enfant; 
	                } else if (n == parent.noeudGauche) {
	                    parent.noeudGauche = enfant;
	                } else {
	                    parent.noeudDroit = enfant;
	                }
	            } else { 
	                Noeud successeur = n.noeudDroit;
	                while (successeur.noeudGauche != null) {
	                    successeur = successeur.noeudGauche;
	                }
	                n.contenu = successeur.contenu;
	                supprimerRec(successeur.contenu, n.noeudDroit, n);
	            }
	            return true;
	        }
	    }
	
}
