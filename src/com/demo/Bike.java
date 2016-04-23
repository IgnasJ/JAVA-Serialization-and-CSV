package com.demo;

/**
 * Created by Ignas on 2016-04-21.
 */
public class Bike extends Vehicle{
    /**
     * Bike class constructor
     *
     * @param brand Name of manufacturer
     * @param model Name of specific model
     * @param year  Year of manufacture
     */
    public Bike(String brand, String model, int year) {
        super(brand, model, year);
    }

    @Override
    public int getSeatsNumber() {
        return 1;
    }

    @Override
    public String toString() {
        return getBrand() + " " + getModel() + " " + getYear();
    }
}
