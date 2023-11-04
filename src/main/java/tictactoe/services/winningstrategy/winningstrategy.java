package tictactoe.services.winningstrategy;

import tictactoe.models.Board;
import tictactoe.models.Move;
import tictactoe.models.Player;

public interface winningstrategy {
    Player checkwinner(Board board, Move lastMove);
}
