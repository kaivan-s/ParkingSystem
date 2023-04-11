package model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ParkingSlot {

    private int slotNumber;
    private int vehicleType;
    private LocalDateTime parkingStartTime;

    public ParkingSlot(int slotNumber, int vehicleType) {
        this.slotNumber = slotNumber;
        this.vehicleType = vehicleType;
    }

    public LocalDateTime getParkingStartTime() {
        return parkingStartTime;
    }

    public void setParkingStartTime(LocalDateTime parkingStartTime) {
        this.parkingStartTime = parkingStartTime;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public int getVehicleType() {
        return vehicleType;
    }
}
