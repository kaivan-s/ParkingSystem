import model.ParkingSlot;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Queue;

public class ParkingSystem {

    Queue<ParkingSlot> available2WheelerSlots;
    Queue<ParkingSlot> available4WheelerSlots;

    public ParkingSystem(int total2WheelerSlots, int total4WheelerSlots) {
        getSlots(total2WheelerSlots, total4WheelerSlots);
    }

    private void getSlots(int total2WheelerSlots, int total4WheelerSlots) {
        available2WheelerSlots = new LinkedList<>();
        available4WheelerSlots = new LinkedList<>();

        for(int i=1;i<=total2WheelerSlots;i++) {
            available2WheelerSlots.offer(new ParkingSlot(i, 2));
        }
        for(int i=1;i<=total4WheelerSlots;i++) {
            available4WheelerSlots.offer(new ParkingSlot(i, 4));
        }
    }

    public ParkingSlot parkVehicle(int vehicleType) {
        ParkingSlot parkingSlot = null;
        if(vehicleType == 2) parkingSlot =  available2WheelerSlots.isEmpty() ? null : available2WheelerSlots.poll();
        else if (vehicleType == 4) parkingSlot =  available4WheelerSlots.isEmpty() ? null : available4WheelerSlots.poll();
        else {
            throw new IllegalArgumentException("Wrong Vehicle Type");
        }
        if(parkingSlot != null) parkingSlot.setParkingStartTime(LocalDateTime.now());
        return parkingSlot;
    }

    public int calculateFee(ParkingSlot parkingSlot, LocalDateTime exitTime) {
        LocalDateTime entryTime = parkingSlot.getParkingStartTime();
        long durationHours = Duration.between(entryTime ,exitTime).toHours();
        return (int)durationHours * 10;
    }

    public boolean unParkVehicle(ParkingSlot parkingSlot) {
        if(parkingSlot == null) return false;
        int vehicleType = parkingSlot.getVehicleType();
        if(vehicleType == 2) {
            available2WheelerSlots.offer(parkingSlot);
            System.out.println("Total Fees: " + calculateFee(parkingSlot, LocalDateTime.now().plusHours(2)));
        }
        else if(vehicleType == 4) available4WheelerSlots.offer(parkingSlot);
        else {
            throw new IllegalArgumentException("Wrong Vehicle Type");
        }
        return true;
    }

}
