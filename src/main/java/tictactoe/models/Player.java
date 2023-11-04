package tictactoe.models;

import tictactoe.exceptions.GameOverException;

import java.util.Scanner;

public class Player {
    private int id;
    private String name;
    private char symbol;
    private PlayerType playerType;

    public Player(int id,String name, char symbol, PlayerType playerType) {
        this.id=id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public Move makeMove(Board board)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the row for the move:"+this.name);
        int row=sc.nextInt();
        System.out.println("Enter the col for the move:"+this.name);
        int col=sc.nextInt();
        if(row<0 || row>=board.getSize() || col<0 || col>=board.getSize() || board.getBoard().get(row).get(col).getPlayer()!=null)
        {
            throw new GameOverException("Invalid entry or Field");
        }
        Cell cell=new Cell(row,col,this,Cellstate.FILLED);
        board.getBoard().get(row).get(col).setCellstate(Cellstate.FILLED);
        board.getBoard().get(row).get(col).setPlayer(this);
        return new Move(cell,this);

    }
}
