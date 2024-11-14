package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.Carte;
import src.Couleur;
import src.Main;
import src.Valeur;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    // -----------------------------------------------------------
    // Initialisation et création d'un deck entier
    // -----------------------------------------------------------

    // Carreaux

    Carte Ca2;
    Carte Ca3;
    Carte Ca4;
    Carte Ca5;
    Carte Ca6;
    Carte Ca7;
    Carte Ca8;
    Carte Ca9;
    Carte Ca10;
    Carte CaV;
    Carte CaD;
    Carte CaR;
    Carte CaA;

    //Trèfles

    Carte Tr2;
    Carte Tr3;
    Carte Tr4;
    Carte Tr5;
    Carte Tr6;
    Carte Tr7;
    Carte Tr8;
    Carte Tr9;
    Carte Tr10;
    Carte TrV;
    Carte TrD;
    Carte TrR;
    Carte TrA;

    //Coeurs

    Carte Co2;
    Carte Co3;
    Carte Co4;
    Carte Co5;
    Carte Co6;
    Carte Co7;
    Carte Co8;
    Carte Co9;
    Carte Co10;
    Carte CoV;
    Carte CoD;
    Carte CoR;
    Carte CoA;

    //piques

    Carte Pi2;
    Carte Pi3;
    Carte Pi4;
    Carte Pi5;
    Carte Pi6;
    Carte Pi7;
    Carte Pi8;
    Carte Pi9;
    Carte Pi10;
    Carte PiV;
    Carte PiD;
    Carte PiR;
    Carte PiA;

    @BeforeEach
    void setUp() {
        Ca2 = new Carte(Valeur.deux, Couleur.Ca);
        Ca3 = new Carte(Valeur.trois, Couleur.Ca);
        Ca4 = new Carte(Valeur.quatre, Couleur.Ca);
        Ca5 = new Carte(Valeur.cinq, Couleur.Ca);
        Ca6 = new Carte(Valeur.six, Couleur.Ca);
        Ca7 = new Carte(Valeur.sept, Couleur.Ca);
        Ca8 = new Carte(Valeur.huit, Couleur.Ca);
        Ca9 = new Carte(Valeur.neuf, Couleur.Ca);
        Ca10 = new Carte(Valeur.dix, Couleur.Ca);
        CaV = new Carte(Valeur.V, Couleur.Ca);
        CaD = new Carte(Valeur.D, Couleur.Ca);
        CaR = new Carte(Valeur.R, Couleur.Ca);
        CaA = new Carte(Valeur.A, Couleur.Ca);

        Tr2 = new Carte(Valeur.deux, Couleur.Tr);
        Tr3 = new Carte(Valeur.trois, Couleur.Tr);
        Tr4 = new Carte(Valeur.quatre, Couleur.Tr);
        Tr5 = new Carte(Valeur.cinq, Couleur.Tr);
        Tr6 = new Carte(Valeur.six, Couleur.Tr);
        Tr7 = new Carte(Valeur.sept, Couleur.Tr);
        Tr8 = new Carte(Valeur.huit, Couleur.Tr);
        Tr9 = new Carte(Valeur.neuf, Couleur.Tr);
        Tr10 = new Carte(Valeur.dix, Couleur.Tr);
        TrV = new Carte(Valeur.V, Couleur.Tr);
        TrD = new Carte(Valeur.D, Couleur.Tr);
        TrR = new Carte(Valeur.R, Couleur.Tr);
        TrA = new Carte(Valeur.A, Couleur.Tr);

        Co2 = new Carte(Valeur.deux, Couleur.Co);
        Co3 = new Carte(Valeur.trois, Couleur.Co);
        Co4 = new Carte(Valeur.quatre, Couleur.Co);
        Co5 = new Carte(Valeur.cinq, Couleur.Co);
        Co6 = new Carte(Valeur.six, Couleur.Co);
        Co7 = new Carte(Valeur.sept, Couleur.Co);
        Co8 = new Carte(Valeur.huit, Couleur.Co);
        Co9 = new Carte(Valeur.neuf, Couleur.Co);
        Co10 = new Carte(Valeur.dix, Couleur.Co);
        CoV = new Carte(Valeur.V, Couleur.Co);
        CoD = new Carte(Valeur.D, Couleur.Co);
        CoR = new Carte(Valeur.R, Couleur.Co);
        CoA = new Carte(Valeur.A, Couleur.Co);

        Pi2 = new Carte(Valeur.deux, Couleur.Pi);
        Pi3 = new Carte(Valeur.trois, Couleur.Pi);
        Pi4 = new Carte(Valeur.quatre, Couleur.Pi);
        Pi5 = new Carte(Valeur.cinq, Couleur.Pi);
        Pi6 = new Carte(Valeur.six, Couleur.Pi);
        Pi7 = new Carte(Valeur.sept, Couleur.Pi);
        Pi8 = new Carte(Valeur.huit, Couleur.Pi);
        Pi9 = new Carte(Valeur.neuf, Couleur.Pi);
        Pi10 = new Carte(Valeur.dix, Couleur.Pi);
        PiV = new Carte(Valeur.V, Couleur.Pi);
        PiD = new Carte(Valeur.D, Couleur.Pi);
        PiR = new Carte(Valeur.R, Couleur.Pi);
        PiA = new Carte(Valeur.A, Couleur.Pi);
    }


    // ------------------------------------------------------------------------
    // Test Simple avec assertEquals
    // ------------------------------------------------------------------------

    @Test
    void testCompareTo() {
        assertEquals(-1, Ca3.compareTo(Ca4));     // Comparaison simple
        assertEquals(-1, Pi2.compareTo(PiA));     // Comparaison simple de meme couleur
        assertEquals(1, TrV.compareTo(Pi10));     // Comparaison avec une tete
        assertEquals(-1, CaD.compareTo(CoR));     // Comparaison entre deux tetes
        assertEquals(0, Pi6.compareTo(Tr6));      // Comparaison en cas d'egalite
        assertEquals(0, PiR.compareTo(TrR));      // Comparaison en cas d'egalite de tetes
    }

    // ------------------------------------------------------------------------
    // ------------------------------------------------------------------------
    // Test Game
    // ------------------------------------------------------------------------
    // ------------------------------------------------------------------------


    // ------------------------------------------------------------------------
    // Détection erreur
    // ------------------------------------------------------------------------

    @Test
    void testDetectionErreur() {
        Main mainD1 = new Main(Ca3, Ca3);
        Main mainD2 = new Main(Ca4, Pi2);
        assertEquals("Il y a 2 cartes identiques !!", mainD1.DetectorError(mainD2)); // deux même cartes main 1

        Main mainD3 = new Main(Ca3, Ca4);
        Main mainD4 = new Main(Ca4, Pi2);
        assertEquals("Il y a 2 cartes identiques !!", mainD3.DetectorError(mainD4)); // Ca4 se trouve dans la main 1 et 2

        Main mainD5 = new Main(Ca3, Ca4);
        Main mainD6 = new Main(PiA, Pi2);
        assertEquals("", mainD5.DetectorError(mainD6)); // pas de problème

        Main mainD7 = new Main(Ca3);
        Main mainD8 = new Main(PiA, Pi2);
        assertEquals("Taille de main différentes !!", mainD7.DetectorError(mainD8)); // taille de main 1 et 2 différente
    }

    // ------------------------------------------------------------------------
    // Test tri
    // ------------------------------------------------------------------------

    @Test
    void testTriMain() {

        // Tri avec 2 cartes

        Main mainTri2 = new Main(Co4,Tr6);
        mainTri2.TrieMain();
        Main mainTrié2 = new Main(Tr6, Co4);
        String maintest1 = "" + mainTri2;
        String maintest2 = "" + mainTrié2;
        assertTrue(maintest1.equals(maintest2));

        // Tri avec 3 cartes

        Main mainTri3 = new Main(Pi10, Tr2, CaA);
        mainTri3.TrieMain();
        Main mainTrié3 = new Main(CaA, Pi10, Tr2);
        String maintest3 = "" + mainTri3;
        String maintest4 = "" + mainTrié3;
        assertTrue(maintest3.equals(maintest4));

        // Tri avec 4 cartes

        Main mainTri4 = new Main(Pi8, Pi6, Tr7, Ca2);
        mainTri4.TrieMain();
        Main mainTrié4 = new Main(Pi8, Tr7, Pi6, Ca2);
        String maintest5 = "" + mainTri4;
        String maintest6 = "" + mainTrié4;
        assertTrue(maintest5.equals(maintest6));

        // Tri avec 5 cartes

        Main mainTri5 = new Main(Ca3, Ca4, Pi2, PiA, TrV);
        mainTri5.TrieMain();
        Main mainTrié5 = new Main(PiA, TrV, Ca4, Ca3, Pi2);
        String maintest7 = "" + mainTri5;
        String maintest8 = "" + mainTrié5;
        assertTrue(maintest7.equals(maintest8));
    }


    // ------------------------------------------------------------------------
    // Test Comparaison
    // ------------------------------------------------------------------------



    @Test
    void testComparaison() {

        // Victoire par Comparaison 1 cartes

        // Egalité
        Main mainC1 = new Main(Ca3);
        Main mainC2 = new Main(Tr3);
        mainC1.TestRapid(mainC2);
        assertEquals("Egalite", mainC1.Comparaison(mainC2));
        // Victoire main 2
        Main mainC3 = new Main(Ca2);
        Main mainC4 = new Main(Tr4);
        mainC3.TestRapid(mainC4);
        assertEquals("La main 2 gagne avec la carte la plus élevée: 4Tr", mainC3.Comparaison(mainC4));
        // Victoire main 1
        Main mainC5 = new Main(PiA);
        Main mainC6 = new Main(Co3);
        mainC5.TestRapid(mainC6);
        assertEquals("La main 1 gagne avec la carte la plus élevée: APi", mainC5.Comparaison(mainC6));

        // Victoire par Comparaison 2 cartes

        // Egalité
        Main mainC7 = new Main(Co3, PiA);
        Main mainC8 = new Main(Pi3, TrA);
        mainC7.TestRapid(mainC8);
        assertEquals("Egalite", mainC7.Comparaison(mainC8));
        // Victoire main 2
        Main mainC9 = new Main(Co3, Ca4);
        Main mainC10 = new Main(Pi2, PiA);
        mainC9.TestRapid(mainC10);
        assertEquals("La main 2 gagne avec la carte la plus élevée: APi", mainC9.Comparaison(mainC10));
        // Victoire main 1
        Main mainC11 = new Main(Co3, TrD);
        Main mainC12 = new Main(Pi2, Ca4);
        mainC11.TestRapid(mainC12);
        assertEquals("La main 1 gagne avec la carte la plus élevée: DTr", mainC11.Comparaison(mainC12));

        // Victoire par Comparaison 3 cartes

        // Victoire main 2
        Main mainC13 = new Main(Co3, Ca4, Pi2);
        Main mainC14 = new Main(CaA, TrV, Pi10);
        mainC13.TestRapid(mainC14);
        assertEquals("La main 2 gagne avec la carte la plus élevée: ACa", mainC13.Comparaison(mainC14));
        // Victoire main 1
        Main mainC15 = new Main(PiR, Pi6, Pi10);
        Main mainC16 = new Main(TrR, Tr6, Pi2);
        mainC15.TestRapid(mainC16);
        assertEquals("La main 1 gagne avec la carte la plus élevée: 10Pi", mainC15.Comparaison(mainC16));
        // Egalité
        Main mainC17 = new Main(PiR, Pi6, Pi10);
        Main mainC18 = new Main(TrR, Tr6, Tr10);
        mainC17.TestRapid(mainC18);
        assertEquals("Egalite", mainC17.Comparaison(mainC18));

        // Victoire par Comparaison 4 cartes

        // Victoire main 1
        Main mainC19 = new Main(Co3, Ca4, Pi2, PiA);
        Main mainC20 = new Main(TrV, Pi10, CaD, CoR);
        mainC19.TestRapid(mainC20);
        assertEquals("La main 1 gagne avec la carte la plus élevée: APi", mainC19.Comparaison(mainC20));
        // Victoire main 2
        Main mainC21 = new Main(Ca3, Ca10, PiA, PiD);
        Main mainC22 = new Main(TrA, Pi2, CaD, CoR);
        mainC21.TestRapid(mainC22);
        assertEquals("La main 2 gagne avec la carte la plus élevée: RCo", mainC21.Comparaison(mainC22));
        // Egalité
        Main mainC23 = new Main(Co3, Pi10, PiR, TrV);
        Main mainC24 = new Main(Ca3, Tr10, TrR, PiV);
        mainC23.TestRapid(mainC24);
        assertEquals("Egalite", mainC23.Comparaison(mainC24));

        // Victoire par comparaison 5 cartes

        // Victoire main 1
        Main mainC25 = new Main(Co3, Ca4, Pi2, PiA, TrV);
        Main mainC26 = new Main(Pi10, CaD, CoR, Pi6, Tr6);
        mainC25.TestRapid(mainC26);
        assertEquals("La main 1 gagne avec la carte la plus élevée: APi", mainC25.Comparaison(mainC26));
        // Victoire main 2
        Main mainC27 = new Main(Ca3, Co2, PiD, Pi7, Tr10);
        Main mainC28 = new Main(Co3, Tr5, TrA, Pi4, Ca9);
        mainC27.TestRapid(mainC28);
        assertEquals("La main 2 gagne avec la carte la plus élevée: ATr", mainC27.Comparaison(mainC28));
        // Egalité
        Main mainC29 = new Main(Ca3, Co2, PiD, Pi7, Tr10);
        Main mainC30 = new Main(Co3, Tr2, TrD, Ca7, Ca10);
        mainC29.TestRapid(mainC30);
        assertEquals("Egalite", mainC29.Comparaison(mainC30));


    }

    // ------------------------------------------------------------------------
    // Test Paire
    // ------------------------------------------------------------------------

    @Test
    void testPaire() {

        // Victoire par Paire 2 cartes

        // Victoire main 1
        Main mainP1 = new Main(PiA, TrA);
        Main mainP2 = new Main(CoA, PiR);
        mainP1.TestRapid(mainP2);
        assertEquals("La main 1 gagne avec une paire de A\n", mainP1.Paire(mainP2));
        // Victoire main 2
        Main mainP3 = new Main(Pi3, Tr4);
        Main mainP4 = new Main(Pi2, Tr2);
        mainP3.TestRapid(mainP4);
        assertEquals("La main 2 gagne avec une paire de deux\n", mainP3.Paire(mainP4));
        // Egalité
        Main mainP5 = new Main(Pi3, Tr3);
        Main mainP6 = new Main(Ca3, Co3);
        mainP5.TestRapid(mainP6);
        assertEquals("Egalite", mainP5.Paire(mainP6));

        // Victoire par Paires 3 cartes

        // Victoire main 2
        Main mainP7 = new Main(Pi6, Tr6, Co3);
        Main mainP8 = new Main(PiR, TrR, Ca4);
        mainP7.TestRapid(mainP8);
        assertEquals("La main 2 gagne avec une paire de R\n", mainP7.Paire(mainP8));
        // Victoire main 1 par paire
        Main mainP9 = new Main(Ca6, Co6, Ca4);
        Main mainP10 = new Main(Co2, Pi9, TrA);
        mainP9.TestRapid(mainP10);
        assertEquals("La main 1 gagne avec une paire de six\n", mainP9.Paire(mainP10));
        //Victoire main 1 par paire + carte forte
        Main mainP11 = new Main(Ca6, Co6, Ca4);
        Main mainP12 = new Main(Tr2, Pi6, Tr6);
        mainP11.TestRapid(mainP12);
        assertEquals("La main 1 gagne avec une paire de six et un 4Ca\n", mainP11.Paire(mainP12));
        // Egalité
        Main mainP13 = new Main(Tr4, Tr6, Pi6);
        Main mainP14 = new Main(Co6, Ca6, Pi4);
        mainP13.TestRapid(mainP14);
        assertEquals("Egalite", mainP13.Paire(mainP14));

        // Victoire par Paires 4 cartes

        // Victoire main 1 par paire
        Main mainP15 = new Main(Co3, Ca4, Tr6, Pi6);
        Main mainP16 = new Main(Ca3, Pi10, PiR, TrV);
        mainP15.TestRapid(mainP16);
        assertEquals("La main 1 gagne avec une paire de six\n", mainP15.Paire(mainP16));
        // Victoire main 2
        Main mainP17 = new Main(Co3, Ca4, Tr6, Pi6);
        Main mainP18 = new Main(Ca9, Pi9, PiR, TrV);
        mainP17.TestRapid(mainP18);
        assertEquals("La main 2 gagne avec une paire de neuf\n", mainP17.Paire(mainP18));
        // Victoire main 1 par paire + carte forte 1
        Main mainP19 = new Main(Co3, CaR, Tr9, Co9);
        Main mainP20 = new Main(Ca9, Pi9, PiD, TrV);
        mainP19.TestRapid(mainP20);
        assertEquals("La main 1 gagne avec une paire de neuf et un RCa\n", mainP19.Paire(mainP20));
        // Victoire main 1 par paire + carte forte 2
        Main mainP21 = new Main(Co3, CaR, Tr6, Pi6);
        Main mainP22 = new Main(Ca6, Co6, PiR, Tr2);
        mainP21.TestRapid(mainP22);
        assertEquals("La main 1 gagne avec une paire de six et un 3Co\n", mainP21.Paire(mainP22));
        // Egalité
        Main mainP23 = new Main(Co2, CaR, Tr6, Pi6);
        Main mainP24 = new Main(Ca6, Co6, PiR, Tr2);
        mainP23.TestRapid(mainP24);
        assertEquals("Egalite", mainP23.Paire(mainP24));

        // Victoire par Paires 5 cartes

        // Egalité
        Main mainP25 = new Main(Co2, CaR, Tr6, Pi6, Tr3);
        Main mainP26 = new Main(Ca6, Co6, PiR, Tr2, Pi3);
        mainP25.TestRapid(mainP26);
        assertEquals("Egalite", mainP25.Paire(mainP26));
        // Victoire main 2 par paire
        Main mainP27 = new Main(Co2, CaR, Tr4, Pi6, Tr3);
        Main mainP28 = new Main(Ca6, CoR, PiR, Tr2, Pi3);
        mainP27.TestRapid(mainP28);
        assertEquals("La main 2 gagne avec une paire de R\n", mainP27.Paire(mainP28));
        // Victoire main 1
        Main mainP29 = new Main(Co2, CaV, Tr4, PiV, Tr3);
        Main mainP30 = new Main(Ca6, CoR, Pi5, Tr5, Pi3);
        mainP29.TestRapid(mainP30);
        assertEquals("La main 1 gagne avec une paire de V\n", mainP29.Paire(mainP30));
        // Victoire main 2 par carte forte 1
        Main mainP31 = new Main(Co2, CaV, Tr4, PiV, Tr3);
        Main mainP32 = new Main(CoV, TrV, Pi10, Tr5, Pi3);
        mainP31.TestRapid(mainP32);
        assertEquals("La main 2 gagne avec une paire de V et un 10Pi\n", mainP31.Paire(mainP32));
        // Victoire main 2 par carte forte 2
        Main mainP33 = new Main(Co10, CaV, Tr4, PiV, Tr3);
        Main mainP34 = new Main(CoV, TrV, Pi10, Tr5, Pi3);
        mainP33.TestRapid(mainP34);
        assertEquals("La main 2 gagne avec une paire de V et un 5Tr\n", mainP33.Paire(mainP34));
        // Victoire main 2 par carte forte 3
        Main mainP35 = new Main(Co10, CaV, Pi5, PiV, Tr2);
        Main mainP36 = new Main(CoV, TrV, Pi10, Tr5, Pi3);
        mainP35.TestRapid(mainP36);
        assertEquals("La main 2 gagne avec une paire de V et un 3Pi\n", mainP35.Paire(mainP36));
    }

    // ------------------------------------------------------------------------
    // Test Brelan
    // ------------------------------------------------------------------------

    @Test
    void testBrelan() {

        // Victoire par Brelan 3 cartes

        // Victoire main 1
        Main mainB1 = new Main(Pi6, Tr6, Ca6);
        Main mainB2 = new Main(Co3, Ca4, Pi2);
        mainB1.TestRapid(mainB2);
        assertEquals("La main 1 gagne avec un brelan de six\n", mainB1.Brelan(mainB2));
        // Victoire main 2
        Main mainB3 = new Main(Tr6, Pi2, PiA);
        Main mainB4 = new Main(PiR, TrR, CaR);
        mainB3.TestRapid(mainB4);
        assertEquals("La main 2 gagne avec un brelan de R\n", mainB3.Brelan(mainB4));
        // Victoire main 1 avec deux brelans dans le jeu
        Main mainB5 = new Main(Tr6, Pi6, Ca6);
        Main mainB6 = new Main(PiR, TrR, CaR);
        mainB5.TestRapid(mainB6);
        assertEquals("La main 2 gagne avec un brelan de R\n", mainB5.Brelan(mainB6));

        // Victoire par Brelan 4 cartes

        // Victoire main 1
        Main mainB7 = new Main(Pi6, Tr6, Ca6, Co3);
        Main mainB8 = new Main(Co3, Ca4, Tr6, Pi6);
        mainB7.TestRapid(mainB8);
        assertEquals("La main 1 gagne avec un brelan de six\n", mainB7.Brelan(mainB8));
        // Victoire main 2 par brelan
        Main mainB9 = new Main(PiR, Tr4, CaR, Ca4);
        Main mainB10 = new Main(Co3, Ca6, Tr6, Pi6);
        mainB9.TestRapid(mainB10);
        assertEquals("La main 2 gagne avec un brelan de six\n", mainB9.Brelan(mainB10));
        // Victoire main 2 avec 2 brelans dans le jeu
        Main mainB11 = new Main(Pi4, Tr4, CaR, Ca4);
        Main mainB12 = new Main(Co3, Ca6, Tr6, Pi6);
        mainB11.TestRapid(mainB12);
        assertEquals("La main 2 gagne avec un brelan de six\n", mainB11.Brelan(mainB12));

        // Victoire par Brelan 5 cartes

        // Victoire main 1
        Main mainB13 = new Main(Pi7, Tr7, Ca7, Co3, Tr2);
        Main mainB14 = new Main(Co3, Ca4, Tr6, Pi6, Pi2);
        mainB13.TestRapid(mainB14);
        assertEquals("La main 1 gagne avec un brelan de sept\n", mainB13.Brelan(mainB14));
        // Victoire main 2 par brelan
        Main mainB15 = new Main(PiR, Tr4, CaR, Ca4, Ca8);
        Main mainB16 = new Main(Co3, Ca6, Tr6, Pi6, PiA);
        mainB15.TestRapid(mainB16);
        assertEquals("La main 2 gagne avec un brelan de six\n", mainB15.Brelan(mainB16));
        // Victoire main 2 avec 2 brelans dans le jeu
        Main mainB17 = new Main(Pi4, Tr4, CaR, Ca4, Tr3);
        Main mainB18 = new Main(Co3, CaD, TrD, PiD, PiA);
        mainB17.TestRapid(mainB18);
        assertEquals("La main 2 gagne avec un brelan de D\n", mainB17.Brelan(mainB18));
    }

    // ------------------------------------------------------------------------
    // Test carre
    // ------------------------------------------------------------------------

    @Test
    void testCarre() {

        // Victoire par Carre 4 cartes

        // Victoire main 1
        Main mainCarre1 = new Main(Pi6, Tr6, Ca6, Co6);
        Main mainCarre2 = new Main(Co3, Ca4, Ca4, PiA);
        mainCarre1.TestRapid(mainCarre2);
        assertEquals("La main 1 gagne avec un carre de six\n", mainCarre1.Carre(mainCarre2));
        // Victoire main 2
        Main mainCarre3 = new Main(Ca2, Co2, Tr2, Pi2);
        Main mainCarre4 = new Main(Co3, Ca4, Pi4, PiA);
        mainCarre4.TestRapid(mainCarre3);
        assertEquals("La main 2 gagne avec un carre de deux\n", mainCarre4.Carre(mainCarre3));
        // Victoire main 1 avec 2 carrés dans le jeu
        Main mainCarre5 = new Main(Ca2, Co2, Tr2, Pi2);
        Main mainCarre6 = new Main(Co9, Ca9, Pi9, Tr9);
        mainCarre5.TestRapid(mainCarre6);
        assertEquals("La main 2 gagne avec un carre de neuf\n", mainCarre5.Carre(mainCarre6));
    }


    // ------------------------------------------------------------------------
    // Test Double Paire
    // ------------------------------------------------------------------------

    @Test
    void testDoublePaire() {

        // Victoire par double paire 4 cartes

        // Victoire main 1
        Main mainDP1 = new Main(Pi6, Tr6, Co2, Pi2);
        Main mainDP2 = new Main(Co3, Pi10, PiR, TrV);
        mainDP1.TestRapid(mainDP2);
        assertEquals("La main 1 gagne avec une double paire de six et deux\n", mainDP1.DoublePaire(mainDP2));
        // Victoire main 2
        Main mainDP3 = new Main(Pi6, Tr6, Co3, Pi2);
        Main mainDP4 = new Main(Co10, Pi10, PiR, TrR);
        mainDP3.TestRapid(mainDP4);
        assertEquals("La main 2 gagne avec une double paire de R et dix\n", mainDP3.DoublePaire(mainDP4));
        // Victoire main 2 avec deux doubles paires
        Main mainDP5 = new Main(Pi6, Tr6, Co2, Pi2);
        Main mainDP6 = new Main(Co10, Pi10, PiR, TrR);
        mainDP5.TestRapid(mainDP6);
        assertEquals("La main 2 gagne avec une double paire de R et dix\n", mainDP5.DoublePaire(mainDP6));
        // Egalité
        Main mainDP7 = new Main(Pi6, Tr6, CoR, PiR);
        Main mainDP8 = new Main(Co6, Ca6, CaR, TrR);
        mainDP7.TestRapid(mainDP8);
        assertEquals("Egalité", mainDP7.DoublePaire(mainDP8));

        // Victoire par double paire 5 cartes

        // Victoire main 1
        Main mainDP9 = new Main(PiA, TrA, Co2, Pi2, Pi10);
        Main mainDP10 = new Main(Co10, Pi10, PiR, TrR, Ca7);
        mainDP9.TestRapid(mainDP10);
        assertEquals("La main 1 gagne avec une double paire de A et deux\n", mainDP9.DoublePaire(mainDP10));
        // Victoire main 2
        Main mainDP11 = new Main(PiA, TrA, Co2, Pi2, Pi10);
        Main mainDP12 = new Main(CoA, CaA, PiR, TrR, Ca7);
        mainDP11.TestRapid(mainDP12);
        assertEquals("La main 2 gagne avec une double paire de A et R\n", mainDP11.DoublePaire(mainDP12));
        // Victoire main 2 meme paire + carte forte
        Main mainDP13 = new Main(PiA, TrA, CoR, CaR, Pi10);
        Main mainDP14 = new Main(CoA, CaA, PiR, TrR, CaD);
        mainDP13.TestRapid(mainDP14);
        assertEquals("La main 2 gagne avec une double paire de A, de R et un DCa\n", mainDP13.DoublePaire(mainDP14));
        // Egalité
        Main mainDP15 = new Main(PiA, TrA, CoR, CaR, PiD);
        Main mainDP16 = new Main(CoA, CaA, PiR, TrR, CaD);
        mainDP15.TestRapid(mainDP16);
        assertEquals("Egalité", mainDP15.DoublePaire(mainDP16));

    }

    // ------------------------------------------------------------------------
    // Test Suite
    // ------------------------------------------------------------------------

    @Test
    void testSuite() {

        // Victoire par Suite

        // Victoire main 2
        Main mainS1 = new Main(Co3, Ca4, Pi2, Pi6, Pi5);
        Main mainS2 = new Main(Co3, Ca4, Pi6, Pi5, Tr7);
        mainS1.TestRapid(mainS2);
        assertEquals("La main 2 gagne avec une suite majorée par un : 7Tr", mainS1.Suite(mainS2));
        // Victoire main 1
        Main mainS3 = new Main(Co3, Ca4, Pi2, Pi6, Tr5);
        Main mainS4 = new Main(CoD, CaR, PiA, Pi8, Tr2);
        mainS3.TestRapid(mainS4);
        assertEquals("La main 1 gagne avec une suite majorée par un : 6Pi", mainS3.Suite(mainS4));
        // Victoire main 1 avec la plus grande suite
        Main mainS5 = new Main(Co10, CaV, PiD, PiR, TrA);
        Main mainS6 = new Main(Co3, Ca4, Pi2, Pi6, Tr5);
        mainS5.TestRapid(mainS6);
        assertEquals("La main 1 gagne avec une suite majorée par un : ATr", mainS5.Suite(mainS6));
        // Victoire main 1 avec la plus petite suite
        Main mainS7 = new Main(Co10, CaV, PiD, PiR, Tr3);
        Main mainS8 = new Main(Co3, Ca4, Pi2, PiA, Tr5);
        mainS7.TestRapid(mainS8);
        assertEquals("La main 2 gagne avec une suite majorée par un : 5Tr", mainS7.Suite(mainS8));
        // Victoire main 1 avec la 2e plus petite suite alors que main 2 a la plus petite suite
        Main mainS9 = new Main(Co3, Ca4, Pi2, Pi6, Tr5);
        Main mainS10 = new Main(Co3, Ca4, Pi2, PiA, Tr5);
        mainS9.TestRapid(mainS10);
        assertEquals("La main 1 gagne avec une suite majorée par un : 6Pi", mainS9.Suite(mainS10));
        // Egalité
        Main mainS11 = new Main(Co3, Ca4, Pi2, Pi6, Tr5);
        Main mainS12 = new Main(Ca3, Co4, Tr2, Tr6, Pi5);
        mainS11.TestRapid(mainS12);
        assertEquals("Egalite", mainS11.Suite(mainS12));
    }

    // ------------------------------------------------------------------------
    // Test Flush
    // ------------------------------------------------------------------------

    @Test
    void testFlush() {

        // Victoire par Flush

        // Victoire main 2
        Main mainFlush1 = new Main(Pi2, PiA, Pi10, Tr6, Pi5);
        Main mainFlush2 = new Main(Ca4, Ca3, CaD, CaR, Ca5);
        mainFlush1.TestRapid(mainFlush2);
        assertEquals("La main 2 gagne avec un flush a Ca", mainFlush1.Flush(mainFlush2));
        // Victoire main 1
        Main mainFlush3 = new Main(TrV, Tr6, TrR, Tr2, Tr3);
        Main mainFlush4 = new Main(Pi2, PiA, Pi10, Tr6, Pi5);
        mainFlush3.TestRapid(mainFlush4);
        assertEquals("La main 1 gagne avec un flush a Tr", mainFlush3.Flush(mainFlush4));
        // Victoire main 1 avec 2 couleurs
        Main mainFlush5 = new Main(TrV, Tr6, TrR, Tr2, Tr3);
        Main mainFlush6 = new Main(Pi2, PiA, Pi10, Pi6, Pi5);
        mainFlush5.TestRapid(mainFlush6);
        assertEquals("La main 2 gagne avec un flush a Pi et la carte APi\n", mainFlush5.Flush(mainFlush6));
        Main mainFlush7 = new Main(TrV, Tr6, TrR, Tr2, Tr3);
        Main mainFlush8 = new Main(PiV, Pi6, PiR, Pi2, Pi3);
        mainFlush7.TestRapid(mainFlush8);
        assertEquals("Egalite", mainFlush7.Flush(mainFlush8));
    }

    // ------------------------------------------------------------------------
    // Test Full
    // ------------------------------------------------------------------------

    @Test
    void testFull() {

        // Victoire par Full

        // Victoire main 1
        Main mainFull1 = new Main(Pi10, Pi2, Ca2, Tr10, Co10);
        Main mainFull2 = new Main(Pi6, PiR, CaR, Tr6, Co6);
        mainFull1.TestRapid(mainFull2);
        assertEquals("La main 1 gagne avec un full composé d'un brelan de dix et d'une paire de deux", mainFull1.Full(mainFull2));
        // Victoire main 2
        Main mainFull3 = new Main(Tr2, Pi2, Ca2, Tr10, Co10);
        Main mainFull4 = new Main(Pi4, Pi5, Ca5, Tr4, Co4);
        mainFull3.TestRapid(mainFull4);
        assertEquals("La main 2 gagne avec un full composé d'un brelan de quatre et d'une paire de cinq", mainFull3.Full(mainFull4));
        // Victoire main 2
        Main mainFull5 = new Main(Tr2, Pi2, Ca2, Tr10, Co10);
        Main mainFull6 = new Main(Pi4, Pi5, Ca5, Tr4, Co5);
        mainFull5.TestRapid(mainFull6);
        assertEquals("La main 2 gagne avec un full composé d'un brelan de cinq et d'une paire de quatre", mainFull5.Full(mainFull6));
    }

    // ------------------------------------------------------------------------
    // Test Quinte Flush
    // ------------------------------------------------------------------------

    @Test
    void testQuinteFlush() {

        // Victoire par QuinteFlush

        // Egalité
        Main mainQF1 = new Main(Co6, Co9, Co5, Co8, Co7);
        Main mainQF2 = new Main(Pi6, Pi5, Pi9, Pi7, Pi8);
        mainQF1.TestRapid(mainQF2);
        assertEquals("Egalite", mainQF1.QuinteFlush(mainQF2));
        //Victoire main 1
        Main mainQF3 = new Main(Tr6, Tr7, Tr8, Tr9, Tr10);
        Main mainQF4 = new Main(Tr6, Tr7, Tr8, Tr9, TrV);
        mainQF3.TestRapid(mainQF4);
        assertEquals("La main 1 gagne avec une quinte flush a Tr majorée par un 10Tr\n", mainQF3.QuinteFlush(mainQF4));
        //Victoire main 2
        Main mainQF5 = new Main(Tr6, Tr7, Tr8, Tr9, TrV);
        Main mainQF6 = new Main(Tr6, Tr7, Tr8, Tr9, Tr10);
        mainQF5.TestRapid(mainQF6);
        assertEquals("La main 2 gagne avec une quinte flush a Tr majorée par un 10Tr\n", mainQF5.QuinteFlush(mainQF6));
        //Victoire main 2 avec la plus petite flush
        Main mainQF7 = new Main(Tr6, Tr7, Tr8, Tr9, TrV);
        Main mainQF8 = new Main(Tr5, Tr4, Tr3, Tr2, TrA);
        mainQF7.TestRapid(mainQF8);
        assertEquals("La main 2 gagne avec une quinte flush a Tr majorée par un 5Tr\n", mainQF7.QuinteFlush(mainQF8));
        //Victoire main 2 avec la 2e plus petite flush et la main 1 a la plus petite flush
        Main mainQF9 = new Main(PiA, Pi2, Pi3, Pi4, Pi5);
        Main mainQF10 = new Main(Tr5, Tr4, Tr3, Tr2, Tr6);
        mainQF9.TestRapid(mainQF10);
        assertEquals("La main 2 gagne avec une quinte flush a Tr majorée par un 6Tr\n", mainQF9.QuinteFlush(mainQF10));
    }

}