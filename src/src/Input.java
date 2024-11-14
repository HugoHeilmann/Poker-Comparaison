package src;

import java.util.Scanner;

public class Input {

    private static Valeur assigneValeur(String s){
        Valeur valeur;
        switch (s){
            case "2": valeur = Valeur.deux;break;
            case "3": valeur = Valeur.trois;break;
            case "4": valeur = Valeur.quatre;break;
            case "5": valeur = Valeur.cinq;break;
            case "6": valeur = Valeur.six;break;
            case "7": valeur = Valeur.sept;break;
            case "8": valeur = Valeur.huit;break;
            case "9": valeur = Valeur.neuf;break;
            case "10": valeur = Valeur.dix;break;
            case "V": valeur = Valeur.V;break;
            case "D": valeur = Valeur.D;break;
            case "R": valeur = Valeur.R;break;
            case "A": valeur = Valeur.A;break;
            default: valeur = null;
        }
        return valeur;
    }

    private static Couleur assigneCouleur(String s){
        Couleur couleur;
        switch (s){
            case "Co": couleur = Couleur.Co;break;
            case "Ca": couleur = Couleur.Ca;break;
            case "Tr": couleur = Couleur.Tr;break;
            case "Pi": couleur = Couleur.Pi;break;
            default: couleur = null;
        }
        return couleur;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Main main1 = null;
        Main main2 = null;
        Valeur valeur = null;
        Couleur couleur = null;


        for (int i=0;i<2;i++){
            boolean correcte = false;
            String cartes[] = null;

            Carte carte1 = null;
            Carte carte2 = null;
            Carte carte3 = null;
            Carte carte4 = null;
            Carte carte5 = null;

            while (!correcte){
                correcte = true;
                String val = "";
                String col = "";

                if(i==0){System.out.print("Entrez la première main : ");}
                else if(i==1){System.out.print("Entrez la seconde main : ");}

                String chaineSaisie = scanner.nextLine();
                if (chaineSaisie.length()>=3 && chaineSaisie.length()<=4){
                    cartes = new String[1];
                    cartes[0] = chaineSaisie;
                }
                else if (chaineSaisie.length()>=7 && chaineSaisie.length()<=24 && chaineSaisie.contains(" ")){
                    if (chaineSaisie.length()>=7 && chaineSaisie.length()<=9){cartes = new String[2];}
                    else if (chaineSaisie.length()>=11 && chaineSaisie.length()<=14){cartes = new String[3];}
                    else if ((chaineSaisie.length()>=15 && chaineSaisie.length()<19) || (chaineSaisie.length()==19 && chaineSaisie.substring(chaineSaisie.length()-5,chaineSaisie.length()-4).equals(" "))){cartes = new String[4];}
                    else if (chaineSaisie.length()>=19 && chaineSaisie.length()<=24){cartes = new String[5];}
                    else {correcte = false;}

                    int debutCarte = 0;
                    int indiceCartes = 0;
                    for (int j=0;j<chaineSaisie.length(); j++) {
                        if (chaineSaisie.substring(j, j + 1).equals(" ")) {
                            cartes[indiceCartes] = chaineSaisie.substring(debutCarte, j);
                            debutCarte = j + 1;
                            indiceCartes++;
                        }
                        if (indiceCartes==cartes.length){break;}
                    }
                    if (indiceCartes<cartes.length) {
                        cartes[indiceCartes] = chaineSaisie.substring(debutCarte, chaineSaisie.length());
                    }
                }
                else {correcte = false;}
                if(correcte) {
                    for (int j = 0; j < cartes.length; j++) {
                        if (cartes[j].length() >= 3 && cartes[j].length() <= 4) {
                            val = (String) cartes[j].subSequence(0, cartes[j].length() - 2);
                            col = (String) cartes[j].subSequence(cartes[j].length() - 2, cartes[j].length());
                        } else {
                            correcte = false;
                        }
                        if ("2345678910VDRA".contains(val) && "CoCaTrPi".contains(col)) {
                            valeur = assigneValeur(val);
                            couleur = assigneCouleur(col);
                            if (valeur != null && couleur != null) {
                                if (j == 0) {carte1 = new Carte(valeur, couleur);}
                                if (j == 1) {carte2 = new Carte(valeur, couleur);}
                                if (j == 2) {carte3 = new Carte(valeur, couleur);}
                                if (j == 3) {carte4 = new Carte(valeur, couleur);}
                                if (j == 4) {carte5 = new Carte(valeur, couleur);}
                            }
                            else {correcte = false;}
                        }
                        else {correcte = false;}
                    }

                    if (cartes.length == 1) {
                        if (i == 0) {main1 = new Main(carte1);}
                        if (i == 1) {main2 = new Main(carte1);}
                    }
                    else if (cartes.length == 2) {
                        if (i == 0) {main1 = new Main(carte1, carte2);}
                        if (i == 1) {main2 = new Main(carte1, carte2);}
                    }
                    else if (cartes.length == 3) {
                        if (i == 0) {main1 = new Main(carte1, carte2, carte3);}
                        if (i == 1) {main2 = new Main(carte1, carte2, carte3);}
                    }
                    else if (cartes.length == 4){
                        if (i == 0) {main1 = new Main(carte1, carte2, carte3,carte4);}
                        if (i == 1) {main2 = new Main(carte1, carte2, carte3,carte4);}
                    }
                    else if (cartes.length == 5){
                        if (i == 0) {main1 = new Main(carte1, carte2, carte3,carte4,carte5);}
                        if (i == 1) {main2 = new Main(carte1, carte2, carte3,carte4,carte5);}
                    }
                }
                if (!correcte) {
                    System.out.println("Main non conforme");
                }
            }
        }
        System.out.println(main1.Game(main2));
    }
}
