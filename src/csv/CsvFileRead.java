package csv;

import com.demo.Bike;
import com.demo.Car;
import com.demo.Vehicle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by Ignas on 2016-04-21.
 */
public class CsvFileRead {
    private static final String SEPARATOR = ",";

    private static final int ID =0;
    private static final int MODEL = 1;
    private static final int BRAND = 2;
    private static final int YEAR = 3;
    private static final int SEATS_NUMBER = 4;

    public void readCsvFile(String fileName, ArrayList<? extends Vehicle> objectsList){
        File file = new File(fileName);
        if (file.exists()) {
            try {
                String line;
                BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
                String header = fileReader.readLine();
                while ((line = fileReader.readLine()) != null) {
                    String[]tokens = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                    removeFirstAndLastQuote(tokens);
                    if (tokens.length > 0){
                        if(header.equals("id,brand,model,year,seatsNumber")) {
                            tokens[MODEL] = removeExtraQuotes(tokens[MODEL]);
                            tokens[BRAND] = removeExtraQuotes(tokens[BRAND]);
                            Car car = new Car(Integer.parseInt(tokens[ID]), tokens[MODEL], tokens[BRAND], Integer.parseInt(tokens[YEAR]), Integer.parseInt(tokens[SEATS_NUMBER]));
                            System.out.println(car);
                            ((ArrayList<Car>) objectsList).add(car);
                        }else{
                            tokens[0] = removeExtraQuotes(tokens[0]);
                            tokens[1] = removeExtraQuotes(tokens[1]);
                            Bike bike = new Bike(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
                            ((ArrayList<Bike>)objectsList).add(bike);
                        }
                    }
                }
                fileReader.close();
            } catch (Exception e) {
                e.printStackTrace();
              }
        }
        else {
            System.out.println("Cant find file");
        }
    }

    private void removeFirstAndLastQuote(String[] tokens) {
        for(int i = 0; i < tokens.length; ++i){
            if(tokens[i].startsWith("\"") && tokens[i].endsWith("\"")){
                tokens[i] = tokens[i].substring(1, tokens[i].length()-1);
            }
        }
    }

    private String removeExtraQuotes(String word){
        for(int i = 0; i < word.length(); ++i){
            if(word.charAt(i) == '"' && word.charAt(i+1) == '"'){
                word = word.substring(0, i) +  word.substring(i+1, word.length());
            }
        }
        return word;
    }
}
