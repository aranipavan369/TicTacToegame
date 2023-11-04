package tictactoe.services.botplayingstrategy;

import tictactoe.models.Board;
import tictactoe.models.Move;
import tictactoe.models.Player;

public interface BotplayingStrategy {
    Move makeMove(Board board, Player player);
}
