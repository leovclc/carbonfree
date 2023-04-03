package com.msstudent.ie.carbonfree.business;

public class DisplayCity {

    private long cityId;
    private String cityName;

    private int year;

    private double cityEmission;

    public DisplayCity() {
    }

    public DisplayCity( String cityName, int year, double cityEmission) {
        this.cityName = cityName;

        this.year = year;
        this.cityEmission = cityEmission;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    public long getCityId() {
        return cityId;
    }
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getCityEmission() {
        return cityEmission;
    }

    public void setCityEmission(double cityEmission) {
        this.cityEmission = cityEmission;
    }
}
