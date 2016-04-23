package com.demo;

import csv.CsvFileRead;
import csv.CsvFileWrite;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        CsvFileWrite csvWrite = new CsvFileWrite();
        CsvFileRead csvRead = new CsvFileRead();
        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Bike> bikes = new ArrayList<>();

        Car car1 = new Car("Toyota, \"2\"", "\"Avensis\"", 2016, 4);
        Car car2 = new Car("Opel", "Ascona", 1995);
        Car car3 = new Car("Party", "Car", 2000, 8);
        Car car4 = new Car("Power \"Awesome\" Car", "A;B;C", 2001,2);
        Car car5 = new Car("Toyota; \"\"2\"\"", "Avensis", 19, 4);
        Car car6 = new Car(",,;,", ",,,,,,", 9999);

        Bike bike1 = new Bike("BMX", "360", 2005);
        Bike bike2 = new Bike("Dviratis", "Ereliukas", 1990);
        Bike bike3 = new Bike(";Betkoks;Pavadinimas",",;,;,;,;,;;,;,", 1897);

        ArrayList<Car> carsDemo = new ArrayList<>();
        ArrayList<Bike> bikesDemo = new ArrayList<>();

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);
        bikes.add(bike1);
        bikes.add(bike2);
        bikes.add(bike3);

        System.out.println("Demo Created");

        csvWrite.writeToCsvFile("cars.csv", cars);
        csvWrite.writeToCsvFile("bikes.csv", bikes);

        csvRead.readCsvFile("cars.csv", carsDemo);
        csvRead.readCsvFile("bikes.csv", bikesDemo);
        System.out.println("----");
        System.out.println("Loaded from cars.csv");
        System.out.println("----");
        carsDemo.forEach(System.out::println);
        System.out.println("----");
        System.out.println("----");
        System.out.println("Loaded from bikes.csv");
        System.out.println("----");
        bikesDemo.forEach(System.out::println);
        System.out.println("----");

        saveAllData("CarsList", cars);
        saveAllData("BikesList", bikes);
        System.out.println("_____________________");
        getBuildingList("CarsList").forEach(System.out::println);
        System.out.println("_____________________");
        getBuildingList("BikesList").forEach(System.out::println);
        System.out.println("_____________________");
    }

    private static void saveAllData(String fileName, ArrayList<? extends Vehicle> objectsList) {
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(objectsList);
            out.close();
            fileOut.close();
            System.out.println("Serialized data was saved in " + fileName + ".ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    private static ArrayList<Vehicle> getBuildingList(String fileName) {
        ArrayList<Vehicle> list = new ArrayList<>();
        File f = new File(fileName + ".ser");
        if (f.exists()) try {
            FileInputStream fileIn = new FileInputStream(fileName + ".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            list = (ArrayList<Vehicle>) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Data Loaded Successfully");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
