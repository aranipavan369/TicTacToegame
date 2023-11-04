package tictactoe.services.botplayingstrategy;

import tictactoe.exceptions.GameOverException;
import tictactoe.models.*;

import java.util.List;

public class RandomBotPlayingStrategy implements BotplayingStrategy {

    @Override
    public Move makeMove(Board board, Player player) throws GameOverException {
        List<List<Cell>> matrix = board.getBoard();
        for(int i=0;i<matrix.size();i++){
            for(int j=0;j<matrix.size();j++){
                if(matrix.get(i).get(j).getCellstate().equals(Cellstate.EMPTY)){
                    board.getBoard().get(i).get(j).setPlayer(player);
                    board.getBoard().get(i).get(j).setCellstate(Cellstate.FILLED);
                    return new Move(new Cell(i,j,player,Cellstate.FILLED),player);
                }
            }
        }
        throw new GameOverException("No new cells to play with, GAME OVER");
    }
}
