package com.example.galeriajunior;

public class Pracownik {
    private String imie;
    private String stanowisko;
    private int staz;

    public Pracownik(String imie, String stanowisko, int staz) {
        this.imie = imie;
        this.stanowisko = stanowisko;
        this.staz = staz;
    }


    public String getImie() {
        return imie;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public int getStaz() {
        return staz;
    }
}
