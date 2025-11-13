package hotelBooking;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Booking b = new Booking();

        System.out.println("Hotel Booking System");

        boolean flag = true;

        while(flag) {
        	b.showHotels();
            System.out.print("Select a hotel by number: ");
            int choice = sc.nextInt();

            boolean booked = b.bookHotel(choice);
            if(booked) {
                System.out.println("Room has been booked");
            }

            System.out.print("Do you want to book another room? (yes/no): ");
            sc.nextLine();
            String again = sc.nextLine();

            if(again.equals("no")) {
            	flag = false;
            }
        }

        b.showSummary();
        sc.close();
    }
}
