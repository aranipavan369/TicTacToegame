package parkinglot.services.slotallocationstrategy;

import parkinglot.services.feecalculationstrategy.HighBillCalculationStrategy;
import parkinglot.services.feecalculationstrategy.LowBillCalculationStrategy;
import parkinglot.services.feecalculationstrategy.MediumBillCalculationStrategy;

public class SlotAllocationStrategyFactory {
    public static SlotAllocationStrategy getSlotAllocationStrategy(SlotAllocationStrategyType slotAllocationStrategyType) {
        return switch(slotAllocationStrategyType){
            case NEAREST -> new NearestSlotAllocationStrategy();
            case FARTHEST -> new FarthestSlotAllocationStrategy();
        };

    }
}
