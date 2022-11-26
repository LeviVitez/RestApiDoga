package com.example.varosok;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City {
    @SerializedName("id")
    private int id;
    @Expose
    @SerializedName("nev")
    private String nev;
    @Expose
    @SerializedName("Orszag")
    private String orszag;
    @Expose
    @SerializedName("Lakossag")
    private int lakossag;

    public City(int id, String nev, String orszag, int lakossag) {
        this.id = id;
        this.nev = nev;
        this.orszag = orszag;
        this.lakossag = lakossag;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNev() {
        return nev;
    }
    public void setNev(String nev) {
        this.nev = nev;
    }
    public String getOrszag() {
        return orszag;
    }
    public void setOrszag(String orszag) {
        this.orszag = orszag;
    }
    public int getLakossag() {
        return lakossag;
    }
    public void setLakossag(int lakossag) {
        this.lakossag = lakossag;
    }
}