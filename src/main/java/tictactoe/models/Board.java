package tictactoe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> board;
    private int size;

    public Board(int size)
    {
        this.size=size;
        this.board=new ArrayList<>();
        for(int i=0;i<size;i++)
        {
            this.board.add(new ArrayList<>());
            for(int j=0;j<size;j++)
            {
                this.board.get(i).add(new Cell(i,j));
            }
        }
    }

    public Board(List<List<Cell>> board, int size) {
        this.size = size;
        this.board=new ArrayList<>();
        for(int i=0;i<size;i++)
        {
            List<Cell> row=new ArrayList<>();
            for(int j=0;j<size;j++)
            {
                Cell originalcell=board.get(i).get(j);
                Cell copiedcell=new Cell(originalcell);
                row.add(copiedcell);
            }
            this.board.add(row);
        }
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public int getSize() {
        return size;
    }
    public void printBoard()
    {
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
                board.get(i).get(j).display();
            System.out.println();
        }
    }
}
