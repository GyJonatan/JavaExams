package com.example.vatera.model;

import java.util.ArrayList;

public class Hirdető
{
    String email;
    ArrayList<Termek> termeks;

    public Hirdető() {
    }

    public Hirdető(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Termek> getTermeks() {
        return termeks;
    }

    public void setTermeks(ArrayList<Termek> termeks) {
        this.termeks = termeks;
    }
}
