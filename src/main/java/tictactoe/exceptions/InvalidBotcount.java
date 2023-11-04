package tictactoe.exceptions;

public class InvalidBotcount extends RuntimeException{
    String message;

    public InvalidBotcount(String message) {
        this.message = message;
    }

    public InvalidBotcount(String message, String message1) {
        super(message);
        this.message = message1;
    }
}
