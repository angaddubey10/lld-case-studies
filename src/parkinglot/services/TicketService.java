package parkinglot.services;

import parkinglot.dtos.IssueTicketRequestDto;
import parkinglot.exceptions.GateNotFoundException;
import parkinglot.models.Gate;
import parkinglot.models.Ticket;
import parkinglot.models.Vehicle;
import parkinglot.models.VehicleType;
import parkinglot.repositories.GateRepository;

import java.util.Date;
import java.util.Optional;

public class TicketService {

    GateRepository gateRepository;

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

        Optional<Gate> gateOp = gateRepository.findGateById(gateId);

        if(!gateOp.isPresent()){
            throw new GateNotFoundException();
        }
        Gate gate = gateOp.get();
        gate.getGateNumber();
        ticket.setGate(gate);
        ticket.setGeneratedBy(gate.getOperator());

        Vehicle vehicle =

    }
}
