package com.example.heeevakcina.model;

import org.springframework.web.context.annotation.ApplicationScope;

import java.util.ArrayList;

@ApplicationScope
public class ElojegyzesMenedzser {

    private static ArrayList<Vakcina> vakcinak;
    private static ArrayList<Foglalas> foglalasok;
    private static ElojegyzesMenedzser instance;

    public ElojegyzesMenedzser() {

        vakcinak =new ArrayList<>();
        foglalasok=new ArrayList<>();
        vakcinak.add(new Vakcina("Szputnyik",10));
        vakcinak.add(new Vakcina("Pfizer",2));
        vakcinak.add(new Vakcina("Astra",45));
        vakcinak.add(new Vakcina("Kínai",30));

    }

    public static ElojegyzesMenedzser getInstance()
    {
        if (instance==null)
        {
            instance=new ElojegyzesMenedzser();
        }
        return instance;
    }

    public ArrayList<Vakcina> getVakcinak() {
        return vakcinak;
    }

    public ArrayList<Foglalas> getFoglalasok() {
        return foglalasok;
    }

    public void AddFoglalas(Foglalas foglalas)
    {
        foglalasok.add(foglalas);
    }

    public void RemoveFoglalas(Foglalas foglalas)
    {
        foglalasok.remove(foglalas);
    }

    public Foglalas FindByTaj(String tajszam)
    {
        return foglalasok.stream().filter(t -> t.getTajSzam().equals(tajszam)).findFirst().orElse(null);
    }
    public Vakcina FindByVakcina(String vakcina)
    {
        return vakcinak.stream().filter(v -> v.getNev().equals(vakcina)).findFirst().orElse(null);
    }

}
