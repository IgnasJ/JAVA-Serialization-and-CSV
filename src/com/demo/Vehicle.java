package com.demo;

import java.io.Serializable;

/**
 * Created by Ignas on 2016-04-21.
 */
public abstract class Vehicle implements Serializable{
    private String brand;
    private String model;
    private int year;

    /**
     * Vehicle class constructor
     * @param brand Name of manufacturer
     * @param model Name of specific model
     * @param year Year of manufacture
     */
    public Vehicle(String brand, String model, int year) {
        setModel(model);
        setBrand(brand);
        setYear(year);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public abstract int getSeatsNumber();

}
