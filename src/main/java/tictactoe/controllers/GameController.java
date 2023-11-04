package tictactoe.controllers;
import tictactoe.models.*;
import tictactoe.services.winningstrategy.WinningStrategies;
import tictactoe.services.winningstrategy.WinningStrategyFactory;

import java.util.List;

public class GameController {
    public Game creategame(int dimension, WinningStrategies winningstrategy, List<Player> players)
    {
        try{
            return Game.builder()
                    .players(players)
                    .dimension(dimension)
                    .winningStrategy(WinningStrategyFactory.getwinningstrategy(winningstrategy,dimension))
                    .build();
        }
        catch(Exception e)
        {
            System.out.println("ERROR: "+e.getMessage());
            System.out.println("could not start the game,something went wrong");
        }
        return null;
    }

    public void displayBoard(Game game){
        game.getCurrentBoard().printBoard();
    }

    public Gamestatus gamestatus(Game game)
    {
        return game.getGamestatus();
    }

    public Move executemove(Game game, Player player)
    {
        Move move=player.makeMove(game.getCurrentBoard());
        game.setNoofsymbols(game.getNoofsymbols()+1);
        updatemoves(game,move);
        updategamestatus(game);
        updateboardstates(game);
        return move;
    }

    public Player checkwinner(Game game,Move lastmove)
    {
        Player player=game.getWinningstrategy().checkwinner(game.getCurrentBoard(),lastmove);
        if(player!=null) {
            game.setGamestatus(Gamestatus.WIN);
            game.setWinner(player);
            return player;
        }
        return null;
    }

    public Board undoMove(Game game, Move lastMove){
        //TODO : write the undo logic here
        game.getCurrentBoard().getBoard().get(lastMove.getCell().getRow())
                .get(lastMove.getCell().getCol()).setCellstate(Cellstate.EMPTY);
        game.getCurrentBoard().getBoard().get(lastMove.getCell().getRow())
                .get(lastMove.getCell().getCol()).setPlayer(null);
        return game.getCurrentBoard();
    }

    public void replayGame(Game game){
        //TODO : write logic for replay
        for(int i=0;i<game.getBoardStates().size();i++) {
            game.getBoardStates().get(i).printBoard();
            System.out.println();
        }
    }

    public void updatemoves(Game game,Move move)
    {
        game.getMoves().add(move);
    }

    public void updategamestatus(Game game)
    {
        int noofsymbols= game.getNoofsymbols();
        int dimesion=game.getCurrentBoard().getSize();
        if(noofsymbols==dimesion*dimesion)
            game.setGamestatus(Gamestatus.DRAW);
    }
    public void updateboardstates(Game game)
    {
        int size=game.getCurrentBoard().getSize();
        Board emptyboard=new Board(size);
        Board copiedboard=new Board(game.getCurrentBoard().getBoard(),size);
        emptyboard.setBoard(copiedboard.getBoard());
        game.getBoardStates().add(emptyboard);
    }

}
