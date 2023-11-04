package parkinglot.services.feecalculationstrategy;

public class BillCalculationStrategyFactory {
    public static BillCalculationStrategy getCalculationStrategy(BillCalculationStrategyType billCalculationStrategyType)
    {
        return switch (billCalculationStrategyType){
            case LOWBILL -> new LowBillCalculationStrategy();
            case HIGHBILL -> new HighBillCalculationStrategy();
            case MEDIUMBILL -> new MediumBillCalculationStrategy();
        };

    }
}
