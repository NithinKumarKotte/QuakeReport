package com.example.android.quakereport;

/**
 * Created by Nithin on 05/04/2018.
 */

public class EQParameters {
    private double mag;
    private String city;
    private String date;
    private String url;



    public EQParameters(double mag, String city, String date, String url) {
        this.mag = mag;
        this.city = city;
        this.date = date;
        this.url=url;

    }

    public double getMag() {
        return mag;
    }

    public String getCity() {
        return city;
    }

    public String getDate() {
        return date;
    }

    public String getUrl() {
        return url;
    }
}
