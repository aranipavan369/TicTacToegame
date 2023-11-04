package tictactoe.services.winningstrategy;

public class WinningStrategyFactory {
    public static orderonewinningstrategy getwinningstrategy(WinningStrategies winningStrategies,int dimension)
    {
        //if(winningStrategies==WinningStrategies.ORDERONEWINNINGSTRATEGY)
        return new orderonewinningstrategy(dimension);
    }
}
