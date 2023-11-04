package parkinglot.services;

import parkinglot.exceptions.TicketNotFoundException;
import parkinglot.models.Bill;
import parkinglot.models.Payment;
import parkinglot.models.Ticket;
import parkinglot.models.constants.PaymentMode;
import parkinglot.models.constants.PaymentStatus;
import parkinglot.repository.TicketRepository;
import parkinglot.services.feecalculationstrategy.BillCalculationStrategyFactory;
import parkinglot.services.feecalculationstrategy.BillCalculationStrategyType;

import java.time.LocalDateTime;

public class BillServiceImpl implements BillService{
    private TicketRepository ticketRepository;

    public BillServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Bill createBill(String vehiclenumber) throws TicketNotFoundException {
        Ticket ticket=ticketRepository.getByVehicleNumber(vehiclenumber);
        double amount= BillCalculationStrategyFactory.getCalculationStrategy(BillCalculationStrategyType.LOWBILL)
                .CalucateBillAmount(ticket, LocalDateTime.now());
        Bill bill=new Bill();
        bill.setAmouunt(amount);
        bill.setExitTime(LocalDateTime.now());
        Payment payment=new Payment();
        payment.setAmount(amount);
        payment.setPaymentMode(PaymentMode.ONLINE);
        payment.setPaymentStatus(PaymentStatus.PAID);
        bill.setPayment(payment);
        bill.setTicket(ticket);
        return bill;

    }
}
