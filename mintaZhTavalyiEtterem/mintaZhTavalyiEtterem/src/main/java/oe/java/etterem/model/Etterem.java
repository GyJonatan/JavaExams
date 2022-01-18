package oe.java.etterem.model;

public class Etterem {
    String[] napok;
    String[] idopontok;
    String[][] foglalasok;



    public Etterem() {
        napok = new String[] {"Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek"};
        idopontok = new String[] {"18-19", "19-20", "20-21"};
        foglalasok = new String[napok.length][idopontok.length];
    }

    public String[] getNapok() {
        return napok;
    }

    public String[] getIdopontok() {
        return idopontok;
    }

    public String[][] getFoglalasok() {
        return foglalasok;
    }

    public void setFoglalasok(int i, int j, String ertek) {
        foglalasok[i][j] = ertek;
    }
}
