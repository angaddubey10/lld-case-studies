package parkinglot.strategies.slotassignment;

import parkinglot.models.Gate;
import parkinglot.models.ParkingSlot;
import parkinglot.models.VehicleType;

public interface SlotAssignmentStrategy {
    public ParkingSlot getSlot(Gate gate, VehicleType vehicleType);
}
