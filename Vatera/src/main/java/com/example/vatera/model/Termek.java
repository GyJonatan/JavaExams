package com.example.vatera.model;

import java.util.ArrayList;

public class Termek
{
    String Name;
    String KeyWord;
    String Foglalas;
    int Price;
    static ArrayList<String> keywordArray;

    public Termek() {
    }

    public int getHash() {
        return getName().length()*getPrice()*getKeyWord().length();
    }

    public void setHash()
    {
        getHash();
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getKeyWord() {
        return KeyWord;
    }

    public void setKeyWord(String keyWord) {
        KeyWord = keyWord;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public static ArrayList<String> getKeywordArray() {
        return keywordArray;
    }

    public static void setKeywordArray(ArrayList<String> keywordArray) {
        Termek.keywordArray = keywordArray;
    }

    public String getFoglalas() {
        return Foglalas;
    }

    public void setFoglalas(String foglalas) {
        Foglalas = foglalas;
    }
}
