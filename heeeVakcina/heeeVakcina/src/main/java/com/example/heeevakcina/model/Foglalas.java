package com.example.heeevakcina.model;

public class Foglalas {

    public String tajSzam;
    public int eletkor;
    public String vakcina;

    public Foglalas(String tajSzam, int eletkor, String vakcina) {
        this.tajSzam = tajSzam;
        this.eletkor = eletkor;
        this.vakcina = vakcina;
    }

    public String getTajSzam() {
        return tajSzam;
    }

    public void setTajSzam(String tajSzam) {
        this.tajSzam = tajSzam;
    }

    public int getEletkor() {
        return eletkor;
    }

    public void setEletkor(int eletkor) {
        this.eletkor = eletkor;
    }

    public String getVakcina() {
        return vakcina;
    }

    public void setVakcina(String vakcina) {
        this.vakcina = vakcina;
    }
}
