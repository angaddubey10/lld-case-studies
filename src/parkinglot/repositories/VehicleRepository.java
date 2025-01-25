package parkinglot.repositories;

import parkinglot.models.Vehicle;
import parkinglot.models.VehicleType;

import java.util.Optional;

public class VehicleRepository {
    public Optional<Vehicle> getVehicleByNumber(String number){
        return Optional.empty();
    }

    public Vehicle saveVehicle(Vehicle vehicle){ // **return** - never void, boolean - can work, best - Same type as it will contain id as well
        return null;
    }
}
