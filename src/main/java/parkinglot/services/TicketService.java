package parkinglot.services;

import parkinglot.exceptions.GateNotFoundException;
import parkinglot.exceptions.ParkingLotNotFoundException;
import parkinglot.models.Ticket;
import parkinglot.models.Vehicle;

import java.time.LocalDateTime;

public interface TicketService {
    Ticket createTicket(Vehicle vehicle, int parkingLotId, int gateId, LocalDateTime entryTime) throws ParkingLotNotFoundException, GateNotFoundException;
}
