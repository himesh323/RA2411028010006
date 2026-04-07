/**
 * Room - Abstract representation of a hotel room.
 * Defines common attributes and behavior shared by all room types.
 *
 * @author SreesailamMouryaVeer
 * @version 2.0
 */
public abstract class Room {
    private String roomType;
    private int numberOfBeds;
    private int sizeInSqFt;
    private double pricePerNight;

    public Room(String roomType, int numberOfBeds, int sizeInSqFt, double pricePerNight) {
        this.roomType = roomType;
        this.numberOfBeds = numberOfBeds;
        this.sizeInSqFt = sizeInSqFt;
        this.pricePerNight = pricePerNight;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public int getSizeInSqFt() {
        return sizeInSqFt;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void displayRoomDetails() {
        System.out.println("Room Type      : " + roomType);
        System.out.println("Beds           : " + numberOfBeds);
        System.out.println("Size (sq. ft.) : " + sizeInSqFt);
        System.out.println("Price/Night    : Rs. " + pricePerNight);
    }
}
