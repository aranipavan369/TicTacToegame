package tictactoe.services.botplayingstrategy;

public class BotPlayingStrategyFactory {
    public static RandomBotPlayingStrategy getBotPlayingStrategy(){
        return new RandomBotPlayingStrategy();
    }
}
