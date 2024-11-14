package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import src.Carte;
import src.Couleur;
import src.Main;
import src.Valeur;
class CarteTest {

    @Test
    void testGetCouleur() {
        Carte Ca2 = new Carte(Valeur.deux, Couleur.Ca);
        String Ca2Couleur = "" + Ca2.getCouleur();
        assertEquals("Ca", Ca2Couleur);

    }

    @Test
    void getValeur() {
        Carte Ca2 = new Carte(Valeur.deux, Couleur.Ca);
        String Ca2Valeur = "" + Ca2.getValeur();
        assertEquals("deux", Ca2Valeur);
    }

    @Test
    void equal() {
        Carte Ca2 = new Carte(Valeur.deux, Couleur.Ca);
        Carte Ca2bis = new Carte(Valeur.deux, Couleur.Ca);
        assertTrue(Ca2.equal(Ca2bis));
        Carte Ca3 = new Carte(Valeur.trois, Couleur.Ca);
        assertFalse(Ca2.equal(Ca3));
    }

    @Test
    void compareTo() {
        Carte Ca2 = new Carte(Valeur.deux, Couleur.Ca);
        Carte Ca3 = new Carte(Valeur.trois, Couleur.Ca);
        String CompareTo1 = "" + Ca2.compareTo(Ca3);
        assertEquals( "-1",CompareTo1);
        String CompareTo2 = "" + Ca3.compareTo(Ca2);
        assertEquals( "1",CompareTo2);
        String CompareTo3 = "" + Ca2.compareTo(Ca2);
        assertEquals( "0",CompareTo3);
    }
}