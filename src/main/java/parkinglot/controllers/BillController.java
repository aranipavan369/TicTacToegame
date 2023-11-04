package parkinglot.controllers;

import parkinglot.dto.BillResponseDTO;
import parkinglot.dto.TicketRequestDTO;
import parkinglot.dto.TicketResponseDTO;
import parkinglot.exceptions.TicketNotFoundException;
import parkinglot.models.Bill;
import parkinglot.models.Ticket;
import parkinglot.models.Vehicle;
import parkinglot.repository.TicketRepository;
import parkinglot.services.BillService;
import parkinglot.services.BillServiceImpl;

public class BillController {
    private BillService billService;

    public BillController(TicketRepository ticketRepository) {
        this.billService = new BillServiceImpl(ticketRepository);
    }
    public BillResponseDTO createBill(TicketRequestDTO ticketRequestDTO) throws TicketNotFoundException {
        Bill bill=billService.createBill(ticketRequestDTO.getNumber());
        BillResponseDTO billResponseDTO=new BillResponseDTO();
        billResponseDTO.setAmouunt(bill.getAmouunt());
        billResponseDTO.setVehicleNumber(ticketRequestDTO.getNumber());
        return billResponseDTO;
    }
}
