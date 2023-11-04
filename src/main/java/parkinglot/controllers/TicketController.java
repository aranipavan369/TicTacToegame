package parkinglot.controllers;

import parkinglot.dto.TicketRequestDTO;
import parkinglot.dto.TicketResponseDTO;
import parkinglot.exceptions.GateNotFoundException;
import parkinglot.exceptions.ParkingLotNotFoundException;
import parkinglot.models.Ticket;
import parkinglot.models.Vehicle;
import parkinglot.repository.GateRepository;
import parkinglot.repository.ParkingLotRepository;
import parkinglot.repository.TicketRepository;
import parkinglot.services.TicketService;
import parkinglot.services.TicketServiceImpl;

import java.time.LocalDateTime;

public class TicketController {

    private TicketService ticketService;

    public TicketController(ParkingLotRepository parkingLotRepository, GateRepository gateRepository, TicketRepository ticketRepository) {
        this.ticketService = new TicketServiceImpl(parkingLotRepository, gateRepository, ticketRepository);
    }

    public TicketResponseDTO creqteticket(TicketRequestDTO ticketRequestDTO) throws ParkingLotNotFoundException, GateNotFoundException {
        Vehicle vehicle = new Vehicle(ticketRequestDTO.getNumber(), ticketRequestDTO.getName(), ticketRequestDTO.getColor(), ticketRequestDTO.getVehicleType());
        Ticket ticket = ticketService.createTicket(vehicle,ticketRequestDTO.getParkingLotId(), ticketRequestDTO.getGateId(), LocalDateTime.now());

        TicketResponseDTO ticketResponseDTO = new TicketResponseDTO();
        ticketResponseDTO.setEntryTime(ticket.getEntryTime().toString());
        ticketResponseDTO.setSlotNumber(ticket.getParkingSlot().getSlotnumber());
        ticketResponseDTO.setVehicleNumber(ticket.getVehicle().getNumber());
        return ticketResponseDTO;
    }
}
