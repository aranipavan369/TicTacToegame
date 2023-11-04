package tictactoe.models;

public class Cell {
    private int row;
    private int col;
    private Player player;
    private Cellstate cellstate;

    public Cell(int row,int col)
    {
        this.row=row;
        this.col=col;
    }

    public Cell(int row, int col, Player player, Cellstate cellstate) {
        this.row = row;
        this.col = col;
        this.player = player;
        this.cellstate = cellstate;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setCellstate(Cellstate cellstate) {
        this.cellstate = cellstate;
    }

    public Cell(Cell originalcell)
    {
        this.row=originalcell.getRow();
        this.col=originalcell.getCol();
        this.player=originalcell.getPlayer();
        this.cellstate=originalcell.getCellstate();
    }

    public void display()
    {
        if(player==null)
            System.out.print("|"+" "+"|"+" ");
        else
            System.out.print("|"+player.getSymbol()+"|"+" ");
    }
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Player getPlayer() {
        return player;
    }

    public Cellstate getCellstate() {
        return cellstate;
    }
}
