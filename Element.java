package TP2;

public class Element {

    private int cle;
    private double valeur;

    public Element() {
        this.cle = 0;
        this.valeur = 0;

    }

    public Element(Element e) {
        this.cle = e.cle;
        this.valeur = e.valeur;

    }

    public Element(int n, double val) {
        this.cle = n;
        this.valeur = val;
    }

    public int getCle() {
        return cle;
    }

    public double getVal() {
        return valeur;
    }

    public void setCle(int n) {
        cle = n;
    }

    public void setVal(float val) {
        valeur = val;
    }

    public String toString() {
        return "Element (clé = " + cle + ", valeur = " + valeur + ")";
    }

}
