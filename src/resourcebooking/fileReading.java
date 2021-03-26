package resourcebooking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class fileReading {
    
    public static ArrayList<String> readCleanTimes() {
        ArrayList<String>cleanerTimes=new ArrayList<>();
        String folderDirectory = System.getProperty("user.dir") + "\\bookingSaves.txt";
        String lineFromFile;
        try {
            BufferedReader read = new BufferedReader(new FileReader(folderDirectory));
            while ((lineFromFile = read.readLine()) != null) {
                String[] bookingDetails = lineFromFile.split(" , ");
                cleanerTimes.add(bookingDetails[1]);
                cleanerTimes.add(bookingDetails[2]);
                cleanerTimes.add(bookingDetails[3]);
            }
            read.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        
        return cleanerTimes;
    }
    
    public static ArrayList<String> readCateringTimes() {
        ArrayList<String>cateringTimes=new ArrayList<>();
        String folderDirectory = System.getProperty("user.dir") + "\\bookingSaves.txt";
        String lineFromFile;
        try {
            BufferedReader read = new BufferedReader(new FileReader(folderDirectory));
            while ((lineFromFile = read.readLine()) != null) {
                String[] caterDetails = lineFromFile.split(" , ");
                
                cateringTimes.add(caterDetails[1]);
                cateringTimes.add(caterDetails[5]);
                cateringTimes.add(caterDetails[6]);
            }
            read.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        
        return cateringTimes;
    }
}
