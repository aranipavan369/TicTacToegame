package parkinglot.services;

import parkinglot.exceptions.TicketNotFoundException;
import parkinglot.models.Bill;
import parkinglot.models.Ticket;

public interface BillService {
    Bill createBill(String vehiclenumber) throws TicketNotFoundException;
}
