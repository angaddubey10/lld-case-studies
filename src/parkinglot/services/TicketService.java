package parkinglot.services;

import parkinglot.dtos.IssueTicketRequestDto;
import parkinglot.exceptions.GateNotFoundException;
import parkinglot.models.Gate;
import parkinglot.models.Ticket;
import parkinglot.models.Vehicle;
import parkinglot.models.VehicleType;
import parkinglot.repositories.GateRepository;
import parkinglot.repositories.VehicleRepository;

import java.lang.invoke.VarHandle;
import java.util.Date;
import java.util.Optional;

public class TicketService {

    GateRepository gateRepository;
    VehicleRepository vehicleRepository;

    public Ticket issueTicket(VehicleType vehicleType,
                              String vehicleNumber,
                              String vehicleOwnerName,
                              Long gateId) throws GateNotFoundException {

        //Crate a ticket Object
        //Assign a spot
        //Assign a time
        //Save to DB
        //Return created Object.

        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());

        Optional<Gate> gateOptional = gateRepository.findGateById(gateId);

        if(!gateOptional.isPresent()){
            throw new GateNotFoundException();
        }
        Gate gate = gateOptional.get();
        ticket.setGate(gate);
        ticket.setGeneratedBy(gate.getOperator());
        Vehicle savedVehicle;
        Optional<Vehicle> vehicleOptional = vehicleRepository.getVehicleByNumber(vehicleNumber);
        if(!vehicleOptional.isPresent()){
            Vehicle vehicle = new Vehicle();
            vehicle.setNumber(vehicleNumber);
            vehicle.setOwnerName(vehicleOwnerName);
            vehicle.setVehicleType(vehicleType);
            savedVehicle = vehicleRepository.saveVehicle(vehicle);
        }
        else{
            savedVehicle = vehicleOptional.get();
        }
        ticket.setVehicle(savedVehicle);

    }
}
