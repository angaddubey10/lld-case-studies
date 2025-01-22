package parkinglot.models;

import java.util.List;

public class ParkingLot extends BaseModel{
    private List<ParkingFloor> parkingFloors;
    private List<Gate> gates;
    private ParkingLotStatus status;
    private SlotAllotmentStrategyType slotAllotmentStrategyType;
    private FeeCalculationStrategyType feeCalculationStrategyType;
    private String address;

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public ParkingLotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingLotStatus status) {
        this.status = status;
    }

    public SlotAllotmentStrategyType getSlotAllotmentStrategyType() {
        return slotAllotmentStrategyType;
    }

    public void setSlotAllotmentStrategyType(SlotAllotmentStrategyType slotAllotmentStrategyType) {
        this.slotAllotmentStrategyType = slotAllotmentStrategyType;
    }

    public FeeCalculationStrategyType getFeeCalculationStrategyType() {
        return feeCalculationStrategyType;
    }

    public void setFeeCalculationStrategyType(FeeCalculationStrategyType feeCalculationStrategyType) {
        this.feeCalculationStrategyType = feeCalculationStrategyType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
