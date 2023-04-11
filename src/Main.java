import model.ParkingSlot;

public class Main {
    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(3, 10);

        ParkingSlot slot1 = parkingSystem.parkVehicle(2);
        System.out.println("2 wheeler - " + slot1.getSlotNumber());

        ParkingSlot slot2 = parkingSystem.parkVehicle(2);
        System.out.println("2 wheeler - " + slot2.getSlotNumber());

        ParkingSlot slot3 = parkingSystem.parkVehicle(2);
        System.out.println("2 wheeler - " + slot3.getSlotNumber());

//        ParkingSlot slot2 = parkingSystem.parkVehicle(4);
//        System.out.println("4 wheeler" + slot2.getSlotNumber());

        boolean release2 = parkingSystem.unParkVehicle(slot2);

        ParkingSlot slot4 = parkingSystem.parkVehicle(2);
        System.out.println("2 wheeler - " + slot4.getSlotNumber());

    }
}