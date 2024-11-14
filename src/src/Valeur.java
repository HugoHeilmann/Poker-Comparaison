package src;

public enum Valeur {
    deux(2), trois(3), quatre(4), cinq(5), six(6), sept(7), huit(8), neuf(9), dix(10), V(11), D(12), R(13),
    A(14);

    private Integer valeur;

    private Valeur(Integer vv) {
        valeur = vv;
    }

    private Valeur() {
        valeur = 0;
    }

    public Integer getValeur() {
        return valeur;
    }
}
