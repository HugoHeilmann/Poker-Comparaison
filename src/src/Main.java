package src;

public class Main {
    private Carte main[];
    private int evalMain[];

    public Main(Carte carte) {
        this.main = new Carte[1];
        this.main[0] = carte;
    }

    public Main(Carte carte1, Carte carte2) {
        this.main = new Carte[2];
        this.main[0] = carte1;
        this.main[1] = carte2;
    }

    public Main(Carte carte1, Carte carte2, Carte carte3) {
        this.main = new Carte[3];
        this.main[0] = carte1;
        this.main[1] = carte2;
        this.main[2] = carte3;
    }

    public Main(Carte carte1, Carte carte2, Carte carte3, Carte carte4) {
        this.main = new Carte[4];
        this.main[0] = carte1;
        this.main[1] = carte2;
        this.main[2] = carte3;
        this.main[3] = carte4;
    }

    public Main(Carte carte1, Carte carte2, Carte carte3, Carte carte4, Carte carte5) {
        this.main = new Carte[5];
        this.main[0] = carte1;
        this.main[1] = carte2;
        this.main[2] = carte3;
        this.main[3] = carte4;
        this.main[4] = carte5;
    }
    // ----------------- Detection erreurs == avoir deux mêmes cartes ou taille de mains différentes ----------------- //
    public String DetectorError(Main m) {
        if (this.main.length != m.main.length) {
            return "Taille de main différentes !!";
        }
        for (int i = 0; i < this.main.length; i++) {
            for (int j = 0; j < m.main.length; j++) {
                if (this.main[i].equal(m.main[j])) {
                    return "Il y a 2 cartes identiques !!";
                }
                if (i != j && this.main[i].equal(this.main[j])) {
                    return "Il y a 2 cartes identiques !!";
                }
                if (i != j && m.main[i].equal(m.main[j])) {
                    return "Il y a 2 cartes identiques !!";
                }
            }

        }
        return "";
    }

    public void TrieMain() {// on tri la main des cartes les plus fortes au plus faibles
        Carte echange;
        for (int i = 0; i < this.main.length; i++) {
            for (int j = i+1; j < this.main.length; j++) {
                if (this.main[i].compareTo(this.main[j]) == -1) {
                    echange = this.main[i];
                    this.main[i] = this.main[j];
                    this.main[j] = echange;
                }
            }
        }
    }

    public void EvaluationMain() {// on note dans un tableau le d'occurence de chaque valeur ex : [1,2,2,1,1] avec la valeur de la carte 2 et 3 qui sont les mêmes
        this.TrieMain();
        int longueur = this.main.length;
        this.evalMain = new int[longueur];
        int compteur = 1;
        for (int i = 0; i < longueur; i++) {
            if (i + 1 <= longueur - 1 && this.main[i].getValeur() == this.main[i + 1].getValeur()) {
                compteur += 1;
            } else {
                for (int j = 0; j < compteur; j++) {
                    this.evalMain[i - j] = compteur;
                }
                compteur = 1;
            }
        }
    }

    public int[] getEvalMain() {
        return this.evalMain;
    }

    // affiche toutes les cartes de la main
    public String AfficheMain() {
        String result = "";
        for (int i = 0; i < this.main.length; i++) {
            result += this.main[i] + " ";
        }
        return result;
    }
    // Méthode qui renvoit le type de victoire : paire,carré,full, ... en considérant deux mains
    public String TypeOfVictory(Main m) {
        this.EvaluationMain();
        m.EvaluationMain();

        int compteurThis = 0;
        int compteurM = 0;
        int compteurPaireThis = 0;
        int compteurPaireM = 0;
        int tailleMain = this.main.length;
        String result = "";
        /////////////////////////////////////////////////////////////
        // on note dans les compteurs de chaque main si elle possède une paire, un brelan ou un carré (la plus haute valeur écrasera une plus faible
        for (int i = 0; i < tailleMain; i++) {
            if (compteurThis < this.getEvalMain()[i]) {
                compteurThis = this.getEvalMain()[i];
            }
            if (compteurM < m.getEvalMain()[i]) {
                compteurM = m.getEvalMain()[i];
            }

            if (this.getEvalMain()[i] == 2) {
                compteurPaireThis += 1;
            }
            if (m.getEvalMain()[i] == 2) {
                compteurPaireM += 1;
            }
        }
        /////////////////////////////////////////////////////////////
        // On regarde les types de victoire pour un jeu à 5 cartes
        if(tailleMain==5) {
            if (compteurThis == 1 || compteurM == 1) {// on regarde si on a une victoire par QuinteFlush donc pas de doublon ou plus de valeur de carte dans au moins une main
                if (compteurThis == 1) {// on regarde pour la main This
                    if (this.main[0].getCouleur() == this.main[1].getCouleur()
                            && this.main[1].getCouleur() == this.main[2].getCouleur()
                            && this.main[2].getCouleur() == this.main[3].getCouleur()
                            && this.main[3].getCouleur() == this.main[4].getCouleur()) {
                        result = "Couleur"; // on a donc une couleur pour la main This
                    }
                    if (this.main[0].getValeur().getValeur() == this.main[4].getValeur().getValeur() + 4) {
                        result += "Suite"; // on regarde ensuite si on a une suite
                    } else if (this.main[0].getValeur().getValeur() == 14 && this.main[1].getValeur().getValeur() == 5) {
                        result += "Suite"; // on regarde ensuite si on a une suite avec un as au début
                    } else {
                        result += " "; // éviter d'avoir une couleur pour This, une suite pour m et d'obtenir "CouleurSuite" qui veut dire QuinteFlush. Dans ce cas là on obtient "src.Couleur Suite"
                    }
                    if (result.equals("CouleurSuite")){
                        return "QuinteFlush";
                    }
                }

                if (compteurM == 1) {
                    if (m.main[0].getCouleur() == m.main[1].getCouleur()
                            && m.main[1].getCouleur() == m.main[2].getCouleur()
                            && m.main[2].getCouleur() == m.main[3].getCouleur()
                            && m.main[3].getCouleur() == m.main[4].getCouleur()) {
                        result = "Couleur"; // on a donc une couleur pour la main M
                    }
                    if (m.main[0].getValeur().getValeur() == m.main[4].getValeur().getValeur() + 4) {
                        result += "Suite"; // on regarde ensuite si on a une suite
                    } else if (m.main[0].getValeur().getValeur() == 14 && m.main[1].getValeur().getValeur() == 5) {
                        result += "Suite"; // on regarde ensuite si on a une suite avec un as au début
                    }
                } // si on a une ou deux quinteFlush cela signifie que result = CouleurSuite || CouleurSuiteSuite (si on a seulement une suite à la main This et une quinteFlush à la main m)
                if (result.equals("CouleurSuite") || result.equals("CouleurSuiteSuite")) {
                    return "QuinteFlush";
                }
            }

            if (Math.max(compteurThis, compteurM) == 4) {
                return "Carre"; // la victoire par Carré est dans l'ordre, juste après
            }

            // si on a une brelan et une paire on gagne par Full dans une main ou l'autre
            if (compteurThis == 3 && compteurPaireThis == 2) {
                return "Full";
            }
            if (compteurM == 3 && compteurPaireM == 2) {
                return "Full";
            }

            if (compteurThis == 1 || compteurM == 1) {
                // sinon on peut gagner par couleur avec result = "Couleur" ou " Couleur " ou Couleur Suite (Couleur main 2 / Couleur main 1 / Couleur main 1 + suite main 2)
                if (result.equals("Couleur") || result.equals("Couleur ") || result.equals("Couleur Suite")) {
                    return "Couleur";
                }
                // enfin on peut gagner par suite avec result = "SuiteSuite" ou " Suite" (avec 1 ou 2 suites)
                if (result.equals("SuiteSuite") || result.equals(" Suite") || result.equals("Suite")) {
                    return "Suite";
                }
            }
        }
        // On regarde les types de victoire pour tout les autres types de jeu
        switch (Math.max(compteurThis,compteurM)) {
            case 4:
                return "Carre";
            case 3:
                return "Brelan";
            case 2:
                if (compteurPaireThis == 4 || compteurPaireM == 4) {return "DoublePaire";}
                else {return "Paire";}
            default:
                return "Comparaison"; // dernier type de victoire possible si aucune autre n'est valide
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // ------------------------------               --- Méthodes Victoires ---               ------------------------------ //
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // méthode uniquement appelée pour les tests : elle permet de trier et faire le tableau.
    // // Utile pour ne pas appeler Game si on connaît le type de victoire (donc pour les tests)
    public void TestRapid(Main m){
        this.EvaluationMain();
        m.EvaluationMain();
    }

    public String Comparaison(Main m) {
        for (int i = 0 ; i< this.main.length;i++){
            if (this.main[i].compareTo(m.main[i]) > 0) {
                return "La main 1 gagne avec la carte la plus élevée: " + this.main[i];
            } else if (this.main[i].compareTo(m.main[i]) < 0) {
                return "La main 2 gagne avec la carte la plus élevée: " + m.main[i];
            }
        }
        return "Egalite";
    }

    public String Paire(Main m) {
        Carte cartePaireMainThis = this.main[0];
        Carte cartePaireMainM = m.main[0];

        boolean paireMainThis = false;
        boolean paireMainM = false;
        //////////////////////////////////////////////////////////////////
        // on regarde si on a 1 ou 2 paires
        for (int i = 0; i < this.main.length; i++) {
            if (this.evalMain[i] == 2) {
                paireMainThis = true;
                cartePaireMainThis = this.main[i];
            }
            if (m.evalMain[i] == 2) {
                paireMainM = true;
                cartePaireMainM = m.main[i];
            }
        }
        //////////////////////////////////////////////////////////////////

        if (paireMainThis && !paireMainM){
            return "La main 1 gagne avec une paire de " + cartePaireMainThis.getValeur() + "\n";
        }
        else if (!paireMainThis && paireMainM){
            return "La main 2 gagne avec une paire de " + cartePaireMainM.getValeur() + "\n";
        }
        else {
            if (this.main.length==2) {return "Egalite";}
            if (cartePaireMainThis.compareTo(cartePaireMainM) == 1) {
                return "La main 1 gagne avec une paire de " + cartePaireMainThis.getValeur() + "\n";
            } else if (cartePaireMainThis.compareTo(cartePaireMainM) == -1) {
                return "La main 2 gagne avec une paire de " + cartePaireMainM.getValeur() + "\n";
            } else {
                for (int i=0; i<this.main.length; i++) {
                    if (this.main[i].compareTo(m.main[i]) == 1) {
                        return "La main 1 gagne avec une paire de " + cartePaireMainThis.getValeur() + " et un " + this.main[i] + "\n";}
                    else if (this.main[i].compareTo(m.main[i]) == -1) {
                        return "La main 2 gagne avec une paire de " + cartePaireMainM.getValeur() + " et un " + m.main[i] + "\n";}
                }
                return "Egalite";
            }
        }
    }

    public String Brelan(Main m) {
        boolean brelanMainThis = false;
        boolean brelanMainM = false;
        // si la méthode a été lancée, c'est que les mains ont été triées et qu'il y a au moins 3 cartes dans les mains donc pas de problèmes
        // comme un brelan c'est 3 cartes à valeurs identiques, si on a un jeu trié, quel que soit sa taille la valeur d'une des cartes du brelan est à la place 2
        // => [carte0,carte1,carte2,carte3,carte4]
        // evalMain = [3,3,3] | [1,3,3,3] ou [3,3,3,1] | [1,1,3,3,3] ou [1,3,3,3,1] ou [3,3,3,1,1]
        if (this.evalMain[2] == 3) {
            brelanMainThis = true;
        }
        if (m.evalMain[2] == 3) {
            brelanMainM = true;
        }

        if (brelanMainThis && !brelanMainM) {
            return "La main 1 gagne avec un brelan de " + this.main[2].getValeur() + "\n";
        } else if (!brelanMainThis && brelanMainM) {
            return "La main 2 gagne avec un brelan de " + m.main[2].getValeur() + "\n";
        } else {
            if (this.main[2].compareTo(m.main[2]) > 0) {
                return "La main 1 gagne avec un brelan de " + this.main[2].getValeur() + "\n";
            } else {
                return "La main 2 gagne avec un brelan de " + m.main[2].getValeur() + "\n";
            }
        }
    }

    public String Carre(Main m) {
        boolean carreMainThis = false;
        boolean carreMainM = false;
        // si la méthode a été lancée, c'est que les mains ont été triées et qu'il y a au moins 4 cartes dans les mains donc pas de problèmes
        // comme un carré c'est 4 cartes à valeurs identiques, si on a un jeu trié, quel que soit sa taille la valeur d'une des cartes du carré est à la place 1,2 ou 3
        // => [carte0,carte1,carte2,carte3,carte4]
        // evalMain = [4,4,4,4] ou [1,4,4,4,4] ou [4,4,4,4,1]
        if (this.evalMain[1] == 4) {
            carreMainThis = true;
        }
        if (m.evalMain[1] == 4) {
            carreMainM = true;
        }

        if (carreMainThis && carreMainM) {
            if (this.main[1].compareTo(m.main[1]) == 1) {
                return "La main 1 gagne avec un carre de " + this.main[1].getValeur() + "\n";
            } else {
                return "La main 2 gagne avec un carre de " + m.main[1].getValeur() + "\n";
            }
        } else if (carreMainThis) {
            return "La main 1 gagne avec un carre de " + this.main[1].getValeur() + "\n";
        } else if (carreMainM) {
            return "La main 2 gagne avec un carre de " + m.main[1].getValeur() + "\n";
        }
        return "";
    }

    public String DoublePaire(Main m) {
        boolean doublePaireMainThis = false;
        boolean doublePaireMainM = false;
        // si la méthode a été lancée, c'est que les mains ont été triées et qu'il y a au moins 4 cartes dans les mains donc pas de problèmes
        // première paire = position 1
        // deuxième paire = position 3
        // => [carte0,carte1,carte2,carte3,carte4]
        // evalMain = [2,2,2,2] | [1,2,2,2,2] ou [2,2,1,2,2] ou [2,2,2,2,1]

        //////////////////////////////////////////////////////////////////
        // on regarde si les mains ont une double paire
        if(this.evalMain[1] == 2 && this.evalMain[3] == 2){
            doublePaireMainThis = true;
        }
        if(m.evalMain[1] == 2 && m.evalMain[3] == 2){
            doublePaireMainM = true;
        }
        //////////////////////////////////////////////////////////////////

        // on teste la victoire simple si une seule des mains à une double paire
        if(doublePaireMainThis && !doublePaireMainM){
            return "La main 1 gagne avec une double paire de " + this.main[1].getValeur() + " et " + this.main[3].getValeur() + "\n";
        }
        else if (!doublePaireMainThis && doublePaireMainM){
            return "La main 2 gagne avec une double paire de " + m.main[1].getValeur() + " et " + m.main[3].getValeur() + "\n";
        }
        else {//sinon on compare la paire 1
            int testPaire1 = this.main[1].compareTo(m.main[1]);
            if(testPaire1 == 1){
                return "La main 1 gagne avec une double paire de " + this.main[1].getValeur() + " et " + this.main[3].getValeur() + "\n";
            }
            else if (testPaire1 == -1){
                return "La main 2 gagne avec une double paire de " + m.main[1].getValeur() + " et " + m.main[3].getValeur() + "\n";
            }
            else { // puis la paire 2
                int testPaire2 = this.main[3].compareTo(m.main[3]);
                if(testPaire2 == 1){
                    return "La main 1 gagne avec une double paire de " + this.main[1].getValeur() + " et " + this.main[3].getValeur() + "\n";
                }
                else if (testPaire2 == -1){
                    return "La main 2 gagne avec une double paire de " + m.main[1].getValeur() + " et " + m.main[3].getValeur() + "\n";
                }
                else { //puis l'autre carte qui n'appartient pas à une paire
                    if(this.main.length==4){ return "Egalité";}

                    Carte carteNonPaireThis = null;
                    Carte carteNonPaireM = null;
                    for(int i = 0; i<this.main.length; i++){
                        if(this.evalMain[i]==1){carteNonPaireThis = this.main[i];}
                        if(m.evalMain[i]==1){carteNonPaireM = m.main[i];}
                    }
                    if (carteNonPaireThis.compareTo(carteNonPaireM) == 1){
                        return "La main 1 gagne avec une double paire de " + this.main[1].getValeur() + ", de " + this.main[3].getValeur() + " et un " + carteNonPaireThis +"\n";
                    }
                    else if (carteNonPaireThis.compareTo(carteNonPaireM) == -1){
                        return "La main 2 gagne avec une double paire de " + m.main[1].getValeur() + ", de " + m.main[3].getValeur() + " et un " + carteNonPaireM +"\n";
                    }
                    return "Egalité";
                }
            }
        }
    }

    public String Suite(Main m) {
        // si la méthode a été lancée, c'est que les mains ont été triées et qu'il y a 5 cartes dans les mains donc pas de problèmes
        // => [carte0,carte1,carte2,carte3,carte4]

        boolean SuiteThis = true;
        boolean SuiteM = true;
        //////////////////////////////////////////////////////////////////
        // on regarde s'il y a une ou deux suites
        if (this.main[0].getValeur().getValeur() != this.main[4].getValeur().getValeur() +4) {
                SuiteThis = false;
        }
        if(this.main[0].getValeur().getValeur()==14 && this.main[1].getValeur().getValeur()==5 && this.main[2].getValeur().getValeur()==4 && this.main[3].getValeur().getValeur()==3 && this.main[4].getValeur().getValeur()==2){
            SuiteThis = true; // on regarde ensuite si on a une suite avec un as au début
            this.main[0]=this.main[1];
        }

        if (m.main[0].getValeur().getValeur() != m.main[4].getValeur().getValeur() +4) {
            SuiteM = false;
        }
        if(m.main[0].getValeur().getValeur()==14 && m.main[1].getValeur().getValeur()==5 && m.main[2].getValeur().getValeur()==4 && m.main[3].getValeur().getValeur()==3 && m.main[4].getValeur().getValeur()==2){
            SuiteM = true; // on regarde ensuite si on a une suite avec un as au début
            m.main[0]=m.main[1];
        }
        //////////////////////////////////////////////////////////////////

        if ((SuiteThis) && (!SuiteM)) {
            return "La main 1 gagne avec une suite majorée par un : " + this.main[0];
        } else if ((!SuiteThis) && (SuiteM)) {
            return "La main 2 gagne avec une suite majorée par un : " + m.main[0];
        } else {
            if (this.main[0].compareTo(m.main[0]) > 0) { // si on deux suites on compare la première carte
                if(this.main[0].getValeur().getValeur()==14 && this.main[1].getValeur().getValeur()==5){
                    return "La main 2 gagne avec une suite majorée par un : " + m.main[0];
                }
                return "La main 1 gagne avec une suite majorée par un : " + this.main[0];
            } else if (this.main[0].compareTo(m.main[0]) < 0) {
                if(m.main[0].getValeur().getValeur()==14 && m.main[1].getValeur().getValeur()==5){
                    return "La main 1 gagne avec une suite majorée par un : " + this.main[0];
                }
                return "La main 2 gagne avec une suite majorée par un : " + m.main[0];
            } else {
                return "Egalite";
            }
        }
    }

    public String Flush(Main m) {
        // si la méthode a été lancée, c'est que les mains ont été triées et qu'il y a 5 cartes dans les mains donc pas de problèmes
        // => [carte0,carte1,carte2,carte3,carte4]
        boolean FlushThis = true;
        boolean FlushM = true;
        //////////////////////////////////////////////////////////////////
        // on regarde s'il y a une ou deux flush
        for (int i=0; i<this.main.length;i++) {
            if (i != this.main.length -1) {
                if (this.main[i].getCouleur() != this.main[i+1].getCouleur()) {
                    FlushThis = false;
                }
                if (m.main[i].getCouleur() != m.main[i+1].getCouleur()) {
                    FlushM = false;
                }
            }
        }
        //////////////////////////////////////////////////////////////////

        if ((FlushThis) && (!FlushM)) {
            return "La main 1 gagne avec un flush a " + this.main[0].getCouleur();
        } else if ((!FlushThis) && (FlushM)) {
            return "La main 2 gagne avec un flush a " + m.main[0].getCouleur();
        } else {// si on deux couleurs on compare la première carte
            for (int i = 0 ; i< this.main.length;i++){
                if (this.main[i].compareTo(m.main[i]) > 0) {
                    return "La main 1 gagne avec un flush a " + this.main[0].getCouleur() + " et la carte " + this.main[i] + "\n";
                } else if (this.main[i].compareTo(m.main[i]) < 0) {
                    return "La main 2 gagne avec un flush a " + m.main[0].getCouleur() + " et la carte " + m.main[i] + "\n";
                }
            }
            return "Egalite";
        }
    }

    public String Full(Main m) {
        // si la méthode a été lancée, c'est que les mains ont été triées et qu'il y a 5 cartes dans les mains donc pas de problèmes
        // => [carte0,carte1,carte2,carte3,carte4]
        // evalMain = [2,2,3,3,3] ou [3,3,3,2,2] donc la position du brelan est forcèment la carte2
        boolean FullThis = false;
        boolean FullM = false;

        boolean PairAtFirstThis = false; // pour savoir si la paire est avant ou après le brelan ( voir commentaire précédent ) cela permet de ne pas avoir à la recherche plus tard
        boolean PairAtFirstM = false;
        //////////////////////////////////////////////////////////////////
        // on regarde s'il y a un ou deux full
        if (this.evalMain[0] == 2) {
                PairAtFirstThis = true;
        }
        if (this.evalMain[2] == 3) {
            FullThis = true;
        }

        if (m.evalMain[0] == 2) {
            PairAtFirstM = true;
        }
        if (m.evalMain[2] == 3) {
            FullM = true;
        }
        //////////////////////////////////////////////////////////////////
        if ((!FullThis) && (!FullM)) {
            return "";
        } else if ((FullThis) && (!FullM)) {
            if (PairAtFirstThis) {
                return "La main 1 gagne avec un full composé d'un brelan de " + this.main[2].getValeur()
                        + " et d'une paire de " + this.main[0].getValeur();
            } else {
                return "La main 1 gagne avec un full composé d'un brelan de " + this.main[0].getValeur()
                        + " et d'une paire de " + this.main[3].getValeur();
            }
        } else if ((!FullThis) && (FullM)) {
            if (PairAtFirstM) {
                return "La main 2 gagne avec un full composé d'un brelan de " + m.main[2].getValeur()
                        + " et d'une paire de " + m.main[0].getValeur();
            } else {
                return "La main 2 gagne avec un full composé d'un brelan de " + m.main[0].getValeur()
                        + " et d'une paire de " + m.main[3].getValeur();
            }
        } else {
            if (this.main[2].compareTo(m.main[2]) > 0) {
                if (PairAtFirstThis) {
                    return "La main 1 gagne avec un full composé d'un brelan de " + this.main[2].getValeur()
                            + " et d'une paire de " + this.main[0].getValeur();
                } else {
                    return "La main 1 gagne avec un full composé d'un brelan de " + this.main[0].getValeur()
                            + " et d'une paire de " + this.main[3].getValeur();
                }
            } else {
                if (PairAtFirstM) {
                    return "La main 2 gagne avec un full composé d'un brelan de " + m.main[2].getValeur()
                            + " et d'une paire de " + m.main[0].getValeur();
                } else {
                    return "La main 2 gagne avec un full composé d'un brelan de " + m.main[0].getValeur()
                            + " et d'une paire de " + m.main[3].getValeur();
                }
            }
        }
    }

    public String QuinteFlush(Main m) {
        boolean QuinteFlushThis = true;
        boolean QuinteFlushM = true;
        //////////////////////////////////////////////////////////////////
        // on regarde si on a bien suite et couleur pour savoir si on a 1 ou 2 quinteFlush
        for (int i=0; i<5;i++) {
            if (i != 4) {
                if (this.main[i].getCouleur() != this.main[i+1].getCouleur()) {
                    QuinteFlushThis = false;
                }
                if (m.main[i].getCouleur() != m.main[i+1].getCouleur()) {
                    QuinteFlushM = false;
                }
            }
        }
        for (int i=0; i<5;i++) {
            if (i != 4) {
                if (this.main[i].getValeur().getValeur() != this.main[i+1].getValeur().getValeur()+1) {
                    QuinteFlushThis = false;
                    if(this.main[0].getValeur().getValeur()==14 && this.main[1].getValeur().getValeur()==5 && this.main[2].getValeur().getValeur()==4 && this.main[3].getValeur().getValeur()==3 && this.main[4].getValeur().getValeur()==2){
                        QuinteFlushThis = true;
                        this.main[0]=this.main[1];
                    }
                }
                if (m.main[i].getValeur().getValeur() != m.main[i+1].getValeur().getValeur()+1) {
                    QuinteFlushM = false;
                    if(m.main[0].getValeur().getValeur()==14 && m.main[1].getValeur().getValeur()==5 && m.main[2].getValeur().getValeur()==4 && m.main[3].getValeur().getValeur()==3 && m.main[4].getValeur().getValeur()==2){
                        QuinteFlushM = true;
                        m.main[0]=m.main[1];
                    }

                }
            }
        }


        //////////////////////////////////////////////////////////////////

        if (QuinteFlushThis && !QuinteFlushM) {
            return "La main 1 gagne avec une quinte flush a " + this.main[0].getCouleur() + " majorée par un " + this.main[0] + "\n";
        } else if (!QuinteFlushThis && QuinteFlushM) {
            return "La main 2 gagne avec une quinte flush a " + m.main[0].getCouleur() + " majorée par un " + m.main[0] + "\n";
        } else {
            if (this.main[0].compareTo(m.main[0]) > 0) {
                if(this.main[0].getValeur().getValeur()==14 && this.main[1].getValeur().getValeur()==5){
                    return "La main 2 gagne avec une quinte flush a " + m.main[0].getCouleur() + " majorée par un " + m.main[0] + "\n";
                }
                return "La main 1 gagne avec une quinte flush a " + this.main[0].getCouleur() + " majorée par un " + this.main[0] + "\n";
            } else if (this.main[0].compareTo(m.main[0]) < 0) {
                if(m.main[0].getValeur().getValeur()==14 && m.main[1].getValeur().getValeur()==5){
                    return "La main 1 gagne avec une quinte flush a " + this.main[1].getCouleur() + " majorée par un " + this.main[1] + "\n";
                }
                return "La main 2 gagne avec une quinte flush a " + m.main[0].getCouleur() + " majorée par un " + m.main[0] + "\n";
            } else {
                return "Egalite";
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // ------------------------------               --- Fin Méthodes Victoires ---               ------------------------------ //
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // méthode qui réalise la partie en détectant s'il y a des erreurs puis affiche les mains, ensuite lance la bonne méthode de victoire grâce à TypeOfVictory
    public String Game(Main m) {
        String error = this.DetectorError(m);
        if (error != "") {
            return error;
        }
        String result = "Main 1: " + this.AfficheMain() + "\n" + "Main 2: " + m.AfficheMain() + "\n";
        String victory = this.TypeOfVictory(m);

        if (victory == "QuinteFlush") {
            return result + this.QuinteFlush(m);
        }

        else if (victory == "Carre") {
            return result + this.Carre(m);
        }

        else if (victory == "Full") {
            return result + this.Full(m);
        }

        else if (victory == "Couleur") {
            return result + this.Flush(m);
        }

        else if (victory == "Suite") {
            return result + this.Suite(m);
        }

        else if (victory == "Brelan") {
            return result + this.Brelan(m);
        }

        else if (victory == "DoublePaire") {
            return result + this.DoublePaire(m);
        }

        else if (victory == "Paire") {
            return result + this.Paire(m);
        }
        return result + this.Comparaison(m);
    }

    public String toString() {
        String result = "[";
        for (int i = 0; i < this.main.length; i++) {
            result += this.main[i];
            if (i != this.main.length - 1) {
                result += ",";
            }
        }
        result += "]";
        return result;
    }
}