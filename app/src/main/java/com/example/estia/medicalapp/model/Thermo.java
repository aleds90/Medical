package com.example.estia.medicalapp.model;

import java.util.ArrayList;

public class Thermo {

    private int id;
    private int value;

    public Thermo(){}

    public Thermo(int value){
        this.value = value;
    }

    public static ArrayList<Thermo> generateThermo() {
        ArrayList<Thermo> thermos = new ArrayList<>();
        Thermo thermo = new Thermo(36);
        Thermo thermo1 = new Thermo(37);
        Thermo thermo2 = new Thermo(38);
        Thermo thermo3 = new Thermo(38);
        Thermo thermo4 = new Thermo(37);
        Thermo thermo5 = new Thermo(36);

        thermos.add(thermo);
        thermos.add(thermo1);
        thermos.add(thermo2);
        thermos.add(thermo3);
        thermos.add(thermo4);
        thermos.add(thermo5);

        return thermos;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
