package hotelBooking;

public class Hotel {
    private String name;
    private int totalRooms;
    private int bookedRooms;
    private double roomPrice;
    private double totalEarnings;

    public Hotel(String name, int totalRooms, double roomPrice) {
        this.name = name;
        this.totalRooms = totalRooms;
        this.roomPrice = roomPrice;
        this.bookedRooms = 0;
        this.totalEarnings = 0.0;
    }

    public boolean bookRoom() {
        if(bookedRooms < totalRooms) {
            bookedRooms++;
            totalEarnings += roomPrice;
            
            return true;
        } 
        else {
            System.out.println("No rooms available at " + name);
            
            return false;
        }
    }

    public int getAvailableRooms() {
        return totalRooms - bookedRooms;
    }

    public double getTotalEarnings() {
        return totalEarnings;
    }

    public String getName() {
        return name;
    }

    public int getBookedRooms() {
        return bookedRooms;
    }
    
    public double getRoomPrice() {
    	return roomPrice;
    }

}
