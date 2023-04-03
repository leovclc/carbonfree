package com.msstudent.ie.carbonfree.data;

import jakarta.persistence.*;
import org.hibernate.id.factory.internal.AutoGenerationTypeStrategy;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cityId;
    private String cityName;

    private int year;

    private double cityEmission;

    public City(long cityId, String cityName, int year, double cityEmission) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.year = year;
        this.cityEmission = cityEmission;
    }

    public City () {

    }

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
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
