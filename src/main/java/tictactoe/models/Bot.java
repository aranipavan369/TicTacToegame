package tictactoe.models;

import tictactoe.services.botplayingstrategy.BotplayingStrategy;
import tictactoe.services.botplayingstrategy.BotPlayingStrategyFactory;

public class Bot extends Player{
    private Botdifficultylevel botdifficultylevel;

    public Bot(int id,String name, char symbol, PlayerType playerType,Botdifficultylevel botdifficultylevel) {
        super(id,name, symbol, playerType);
        this.botdifficultylevel=botdifficultylevel;
    }

    public Move makeMove(Board board)
    {
        BotplayingStrategy botplayingStrategy=BotPlayingStrategyFactory.getBotPlayingStrategy();
        return botplayingStrategy.makeMove(board,this);
    }
}
