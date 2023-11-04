package parkinglot.services.feecalculationstrategy;

import parkinglot.models.Ticket;
import parkinglot.models.Vehicle;
import parkinglot.models.constants.VehicleType;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LowBillCalculationStrategy implements BillCalculationStrategy{
    private static final int PER_HOUR_CHARGE_2_WHEELER = 50;
    private static final int PER_HOUR_CHARGE_4_WHEELER = 100;

    private static final double INCREMENT_FACTOR = 0.1;

    @Override
    public double CalucateBillAmount(Ticket ticket, LocalDateTime exittime) {
        LocalDateTime entrytime=ticket.getEntryTime();
        Vehicle vehicle= ticket.getVehicle();
        long totaltime= ChronoUnit.HOURS.between(entrytime,exittime);
        double cost=switch (vehicle.getVehicleType()){
            case BIKE -> calculatebikecost(totaltime);
            case CAR -> calculatecarcost(totaltime);
        };
        return cost;
    }
    private double calculatebikecost(long totaltime)
    {
        double baseamount=totaltime*PER_HOUR_CHARGE_2_WHEELER;
        double bikefee=baseamount+baseamount*(INCREMENT_FACTOR*(totaltime-1));
        return bikefee;
    }
    private double calculatecarcost(long totaltime)
    {
        double baseamount=totaltime*PER_HOUR_CHARGE_4_WHEELER;
        double carfee=baseamount+baseamount*(INCREMENT_FACTOR*(totaltime-1));
        return carfee;
    }
}
//totalhours=3   fee=totalhours*perhourcharge+perhourcharge*(totalhors-1)*Incremetfactor
//                   3*10+10*2*0.1=30
