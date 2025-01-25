package parkinglot.repositories;

import parkinglot.models.Gate;
import parkinglot.models.ParkingLot;

import java.util.Optional;

public class ParkingLotRepository {
    public Optional<ParkingLot> getParkingLotForGate(Gate gate){
        return Optional.empty();
    }
}
