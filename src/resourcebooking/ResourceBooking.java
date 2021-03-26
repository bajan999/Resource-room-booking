package resourcebooking;

import java.util.ArrayList;
import java.util.Scanner;
import static resourcebooking.fileReading.*;

public class ResourceBooking {

    public static Scanner input = new Scanner(System.in);
    public static String email;

    public static void login() {
        boolean valid = false;

        while (valid == false) {
            System.out.println("type your email address");
            email = input.next();
            if (email.contains("@") & email.contains(".")&email.length()>4) {
                valid = true;           //basic email verification
            }
        }
    }

    public static void mainMenu() {
        boolean repeat = true;
        while (repeat == true) {

            System.out.println("what do you want to do?\nother)exit\n1)book a room\n2)view catering schedule\n3)view cleaning schedule");
            String menuChoice = input.next();
            if (menuChoice.equals("1")) {
                bookRoom();
            } else if (menuChoice.equals("2")) {
                ArrayList<String>cateringTimes=readCateringTimes();
                for (int i = 0; i <= cateringTimes.size()/3; i++) {
                    System.out.println(cateringTimes.get(0)+" - "+cateringTimes.get(1)+cateringTimes.get(2));
                    for (int j = 0; j < 3; j++) {
                        cateringTimes.remove(0);
                    }
                }
            } else if (menuChoice.equals("3")) {
                ArrayList<String>cleanerTimes=readCleanTimes();
                for (int i = 0; i <= cleanerTimes.size()/3; i++) {
                    System.out.print(cleanerTimes.get(0)+" - ");
                    System.out.println(Integer.parseInt(cleanerTimes.get(1))+Integer.parseInt(cleanerTimes.get(2))-1);
                    for (int j = 0; j < 3; j++) {
                        cleanerTimes.remove(0);
                    }
                }
                
            } else {
                System.out.println("Goodbye");
                repeat = false;
            }
        }
    }
    
    public static void bookRoom(){
        System.out.println("Which room do you want to book?\nRoom 1 can only fit 2 people in it, \nroom 2 = 4 people, \nroom 3 = 8 people, \nroom 4 = 15 people, \nroom 5 = 50 people. \nRoom 4 is the only room with disabled access for wheelchairs. \nType the number you want.");
        int room=-1;
        while (room>5|room<1){
            room=input.nextInt();
        }
        System.out.println("what hour are you booking from? (24 hr format)");
        int start=-1;
        while (start>24|start<0){
            start=input.nextInt();
        }
        System.out.println("How many hours are you booking for?");
        int length=-1;
        while (length<1){
            length=input.nextInt()+1;   //+1 for cleaning time
        }
        System.out.println("What year are you booking");
        int year=0;
        while (year<2020){
            year=input.nextInt();
        }
        System.out.println("What month are you booking (e.g. 01)");
        int month=0;
        while (month<1|month>12){
            month=input.nextInt();
        }
        System.out.println("What day are you booking");
        int day=0;
        while (day<1|day>31){
            day=input.nextInt();
        }
        String date=(Integer.toString(year)+"/"+Integer.toString(month)+"/"+Integer.toString(day));
        System.out.println("How many resources will you need?");
        int resourceAmount=input.nextInt();
        System.out.println("What do you want in the room? -one at a time e.g. projector/pens");
        ArrayList<String> resources=new ArrayList<>();
        for (int i = 0; i < resourceAmount; i++) {
            resources.add(input.next());
        }
        System.out.println("How many times will you want refreshments?");
        ArrayList<String> refreshments=new ArrayList<>();
        ArrayList<Integer> refreshmentTimes=new ArrayList<>();
        int refreshmentAmounts=input.nextInt();
        for (int i = 0; i < refreshmentAmounts; i++) {
            System.out.println("What refreshment do you want?");
            input.nextLine();
            refreshments.add(input.nextLine());
            System.out.println("What hour do you want it at?");
            refreshmentTimes.add(input.nextInt());
        }
        bookings newBooking=new bookings(room, date, start, length, resources, refreshmentTimes, refreshments, email);
        newBooking.saveBooking(newBooking);
    }                                               //sets up booking object and puts it in a text file

    public static void main(String[] args) {
        login();
        mainMenu();
    }

}
