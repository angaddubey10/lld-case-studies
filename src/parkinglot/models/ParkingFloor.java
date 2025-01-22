package parkinglot.models;

import java.util.List;

public class ParkingFloor extends BaseModel{
    private List<ParkingSlot> parkingSlots;
    private ParkingFloorStatus parkingFloorStatus;
    private int floorNumber;
}
