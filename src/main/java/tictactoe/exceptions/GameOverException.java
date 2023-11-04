package tictactoe.exceptions;

public class GameOverException extends RuntimeException{
    String message;

    public GameOverException(String message) {
        this.message = message;
    }

    public GameOverException(String message, String message1) {
        super(message);
        this.message = message1;
    }
}
