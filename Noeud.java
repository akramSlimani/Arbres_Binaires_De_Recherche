public class Noeud {

	protected Element contenu;
	protected Noeud noeudGauche;
	protected Noeud noeudDroit;

	public Noeud() {
		contenu = new Element();
		noeudGauche = null;
		noeudDroit = null;
	}

	public Noeud(Element e) {
		contenu = e;
		noeudGauche = null;
		noeudDroit = null;
	}

	public Noeud getNoeudGauche() {
		return noeudGauche;
	}

	public Noeud getNoeudDroit() {
		return noeudDroit;
	}

	public void setNoeudGauche(Noeud _n) {
		noeudGauche = _n;
	}

	public void setNoeudDroit(Noeud _n) {
		noeudDroit = _n;
	}

	public void setNoeudGauche(Element e) {
		noeudGauche = new Noeud(e);
	}

	public void setNoeudDroit(Element e) {
		noeudDroit = new Noeud(e);
	}

	public Element getContenu() {
		return contenu;
	}

	public void setContenu(Element e) {
		contenu = e;
	}

	public String toString() {

		return contenu.toString() ;
	}

}
