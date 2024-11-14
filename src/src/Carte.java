package src;

public class Carte {
    private Couleur couleur;
    private Valeur valeur;

    public Carte(Valeur valeur, Couleur couleur) {
        this.valeur = valeur;
        this.couleur = couleur;
    }

    public Couleur getCouleur() {
        return this.couleur;
    }

    public Valeur getValeur() {
        return this.valeur;
    }

    // Méthode qui consiste à voir si deux cartes sont les mêmes
    public boolean equal(Carte card) {
        if ((this.couleur == card.couleur) && (this.valeur == card.valeur)) {
            return true;
        }
        return false;
    }

    // Méthode qui consiste à comparer deux cartes via leur valeur
    public int compareTo(Carte t) {
        if (this.valeur.ordinal() < t.valeur.ordinal()) {return -1;}
        else if (this.valeur.ordinal() > t.valeur.ordinal()) {return 1;}
        return 0;
    }

    public String toString() {
        if (this.valeur.getValeur() <= 10) {
            return this.valeur.getValeur() + "" + this.couleur;
        } else {
            return this.valeur + "" + this.couleur;
        }
    }
}