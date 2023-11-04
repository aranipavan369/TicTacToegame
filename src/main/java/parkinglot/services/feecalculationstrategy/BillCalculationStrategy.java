package parkinglot.services.feecalculationstrategy;

import parkinglot.models.Ticket;

import java.time.LocalDateTime;

public interface BillCalculationStrategy {
    double CalucateBillAmount(Ticket ticket, LocalDateTime exittime);
}
