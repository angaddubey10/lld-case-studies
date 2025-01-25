package parkinglot;

import parkinglot.controllers.TicketController;
import parkinglot.repositories.GateRepository;
import parkinglot.repositories.ParkingLotRepository;
import parkinglot.repositories.TicketRepository;
import parkinglot.repositories.VehicleRepository;
import parkinglot.services.TicketService;

public class ParkingLotApplication {
    public static void main(String[] args) {
        // There's an order for Creating Objects, as we need certain objects to create another objects.
        // We use topological order(Topological Sorting) to create objects, the last nodes will get created first and so on in reverse order
        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        TicketService ticketService = new TicketService(
                gateRepository,
                vehicleRepository,
                parkingLotRepository,
                ticketRepository
        );

        TicketController ticketController = new TicketController(
                ticketService
        );

        System.out.println("Server Listening at Port 9000");
    }
}
