package com.example.heeevakcina.model;

public class Vakcina {

    public String nev;
    public int darab;

    public Vakcina(String nev, int darab) {
        this.nev = nev;
        this.darab = darab;
    }

    public String getNev() {
        return nev;
    }

    public int getDarab() {
        return darab;
    }

    public void setDarab(int darab) {
        this.darab = darab;
    }
}
