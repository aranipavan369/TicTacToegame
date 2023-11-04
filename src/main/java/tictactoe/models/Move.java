package tictactoe.models;

public class Move {
    private Cell cell;
    private Player currenplayer;

    public Move(Cell cell, Player currenplayer) {
        this.cell = cell;
        this.currenplayer = currenplayer;
    }

    public Cell getCell() {
        return cell;
    }

    public Player getCurrenplayer() {
        return currenplayer;
    }
}
