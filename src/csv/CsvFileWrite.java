package csv;

import com.demo.Car;
import com.demo.Vehicle;

import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Created by Ignas on 2016-04-21.
 */
public class CsvFileWrite {

    private static final String SEPARATOR = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    private String fileHeader;

    public void writeToCsvFile(String fileName, ArrayList<? extends Vehicle> objectsList){
        if (objectsList.get(0) instanceof Car){
            fileHeader = "id,brand,model,year,seatsNumber";
        }else {
            fileHeader = "brand,model,year";
        }

        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(fileName);

            //CSV file header
            fileWriter.append(fileHeader);
            //Add new line
            fileWriter.append(NEW_LINE_SEPARATOR);

            for (int i = 0; i < objectsList.size(); i++){
                //ID
                if (objectsList.get(0) instanceof Car) {
                    Car car = (Car) objectsList.get(i);

                    fileWriter.append(String.valueOf(car.getId()));
                    fileWriter.append(SEPARATOR);
                }
                //Brand
                String brand = objectsList.get(i).getBrand();
                brand = setQuotationMarks(brand);
                fileWriter.append("\"" + brand + "\"");
                fileWriter.append(SEPARATOR);
                //Model
                String model = objectsList.get(i).getModel();
                model = setQuotationMarks(model);
                fileWriter.append("\"");
                fileWriter.append(model);
                fileWriter.append("\"");
                fileWriter.append(SEPARATOR);
                //Year
                fileWriter.append(String.valueOf(objectsList.get(i).getYear()));

                if (objectsList.get(0) instanceof Car) {
                    //SeatsNumber
                    fileWriter.append(SEPARATOR);
                    fileWriter.append(String.valueOf(objectsList.get(i).getSeatsNumber()));

                }
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("Data saved in file " + fileName + " !");
            fileWriter.flush();
            fileWriter.close();

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static String setQuotationMarks(String word){
        String temp = "";
        for(int i = 0; i < word.length(); ++i){
            if(word.charAt(i) == '"'){
                temp += '"';
            }
            temp+= word.charAt(i);
        }
       return temp;
    }

}
