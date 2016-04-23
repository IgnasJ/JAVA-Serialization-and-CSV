package com.demo;

/**
 * Created by Ignas on 2016-04-21.
 */
public class Car extends Vehicle {
    private static int total;
    private int id;
    private int seatsNumber = 5;
    /**
     * Car class constructor
     *
     * @param brand Name of manufacturer
     * @param model Name of specific model
     * @param year  Year of manufacture
     */
    public Car(String brand, String model, int year) {
        super(brand, model, year);
        setId(++total);
    }

    public Car(String brand, String model, int year, int seatsNumber) {
        super(brand, model, year);
        setSeatsNumber(seatsNumber);
        setId(++total);
    }

    public Car(int id, String brand, String model, int year, int seatsNumber){
        super(brand, model, year);
        setId(id);
        setSeatsNumber(seatsNumber);
    }

    @Override
    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    @Override
    public String toString() {
        return getId() + " " + getBrand() + " " + getModel() + " " + getYear() + " " + getSeatsNumber();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
