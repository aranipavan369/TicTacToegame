package parkinglot.services.feecalculationstrategy;

import parkinglot.models.Ticket;

import java.time.LocalDateTime;

public class MediumBillCalculationStrategy implements BillCalculationStrategy{
    @Override
    public double CalucateBillAmount(Ticket ticket, LocalDateTime exittime) {
        return 0;
    }
}
