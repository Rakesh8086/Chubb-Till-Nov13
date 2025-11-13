package hotelBooking;
import java.util.*;

public class Booking {
    private ArrayList<Hotel> hotels;

    public Booking() {
        hotels = new ArrayList<>();
        hotels.add(new Hotel("AAA", 20, 1000));
        hotels.add(new Hotel("BBB", 20, 2000));
        hotels.add(new Hotel("CCC", 20, 3000));
        hotels.add(new Hotel("DDD", 20, 4000));
        hotels.add(new Hotel("EEE", 1, 5000));
    }

    public void showHotels() {
        System.out.println("Available Hotels: ");
        for(int i=0;i<hotels.size();i++) {
            Hotel h = hotels.get(i);
            System.out.println("Hotel " + (i+1) + ": " + h.getName());
            System.out.println("Available Rooms: " + h.getAvailableRooms());
            System.out.println("Room Price: " + h.getRoomPrice());
            System.out.println("---------");
        }
    }

    public boolean bookHotel(int choice) {
        if(choice < 1 || choice > hotels.size()) {
            System.out.println("Invalid choice.");
            return false;
        }
        Hotel selected = hotels.get(choice - 1);
        
        return selected.bookRoom();
    }

    public void showSummary() {
        System.out.println("SUMMARY");
        for(int i=0;i<hotels.size();i++) {
            Hotel h = hotels.get(i);
            System.out.println("Hotel " + (i+1) + ": " + h.getName());
            System.out.println("Booked : " + h.getBookedRooms());
            System.out.println("Available : " + h.getAvailableRooms());
            System.out.println("Earnings : " + h.getTotalEarnings());
            System.out.println("-----------");
        }
    }
}
