package resourcebooking;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class bookings {
    private int room;
    private String date;
    private int startTime;
    private int length;
    private ArrayList<String> resources;
    private ArrayList<Integer> refreshmentTimes;
    private ArrayList<String> refreshments;
    private String email;

    public bookings(int room, String date, int startTime, int length, ArrayList<String> resources, ArrayList<Integer> refreshmentTimes, ArrayList<String> refreshments, String email) {
        this.room = room;
        this.date = date;
        this.startTime = startTime;
        this.length = length;
        this.resources = resources;
        this.refreshmentTimes = refreshmentTimes;
        this.refreshments = refreshments;
        this.email = email;
    }

    

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public ArrayList<String> getResources() {
        return resources;
    }

    public void addResources(String a) {
        resources.add(a);
    }

    public ArrayList<Integer> getRefreshmentTimes() {
        return refreshmentTimes;
    }

    public void addRefreshmentTimes(Integer a) {
        refreshmentTimes.add(a);
    }

    public ArrayList<String> getRefreshments() {
        return refreshments;
    }

    public void addRefreshments(String a) {
        refreshments.add(a);
    }
    
    public String email() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString(){
        return (room+" , "+ date+" , "+ startTime+" , "+ length+" , "+ resources+" , "+ refreshmentTimes+" , "+ refreshments+" , "+email);
    }
    
    public void saveBooking(bookings myBooking){
        String folderDirectory = System.getProperty("user.dir") + "\\bookingSaves.txt";
        
        try {
            FileWriter writeToFile = new FileWriter(folderDirectory, true);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            printToFile.println(myBooking.toString());
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
