package tictactoe.models;

import tictactoe.exceptions.InvalidBotcount;
import tictactoe.exceptions.Invalidboardsize;
import tictactoe.exceptions.Invalidsymbol;
import tictactoe.services.winningstrategy.winningstrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    public void setGamestatus(Gamestatus gamestatus) {
        this.gamestatus = gamestatus;
    }

    private List<Board> boardStates;
    private List<Player> players;
    private List<Move> moves;

    public List<Board> getBoardStates() {
        return boardStates;
    }

    private Gamestatus gamestatus;
    private Player winner;
    private Board currentBoard;

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    private winningstrategy winningstrategy;

    public tictactoe.services.winningstrategy.winningstrategy getWinningstrategy() {
        return winningstrategy;
    }

    private int noofsymbols;

    public int getNoofsymbols() {
        return noofsymbols;
    }

    public void setNoofsymbols(int noofsymbols) {
        this.noofsymbols = noofsymbols;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public Game(List<Player> players, Board currentBoard, tictactoe.services.winningstrategy.winningstrategy winningstrategy) {
        this.currentBoard = currentBoard;
        this.players = players;
        this.gamestatus =Gamestatus.INPROGRESS;
        this.moves = new ArrayList<Move>();
        this.boardStates = new ArrayList<Board>();
        this.winningstrategy = winningstrategy;
        this.noofsymbols = 0;
    }

    public Gamestatus getGamestatus() {
        return gamestatus;
    }

    public Board getCurrentBoard() {
        return currentBoard;
    }

    public static Builder builder()
    {
        return new Builder();
    }

    public static class Builder{
        private int dimension;
        private List<Player> players;

        private winningstrategy winningstrategy;


        public Builder dimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder players(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder winningStrategy(winningstrategy winningStrategy) {
            this.winningstrategy = winningStrategy;
            return this;
        }

        public boolean validateBotcount()
        {
            int c=0;
            for(Player player:players)
            {
                if(player.getPlayerType().equals(PlayerType.BOT))
                    c++;
            }
            if(c>1)
                throw new InvalidBotcount("bot player cannot be more than one");
            else
                return true;
        }

        public boolean validateboardsize()
        {
            if(dimension<0 || dimension>10)
                throw new Invalidboardsize("invalid board size");
            return true;
        }
        public boolean validatesymbol()
        {
            HashSet<Character> hs=new HashSet<>();
            for(Player player:players)
            {
                hs.add(player.getSymbol());
            }
            if(hs.size()!=players.size())
                throw new Invalidsymbol("symbol already exists");
            return true;
        }
        public void validate()
        {
            validateBotcount();
            validateboardsize();
            validatesymbol();
        }
        public Game build()
        {
            validate();
            return new Game(players,new Board(dimension),winningstrategy);
        }
    }
}
