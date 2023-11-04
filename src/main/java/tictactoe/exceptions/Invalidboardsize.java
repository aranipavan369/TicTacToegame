package tictactoe.exceptions;

public class Invalidboardsize extends RuntimeException{
    String message;

    public Invalidboardsize(String message) {
        this.message = message;
    }

    public Invalidboardsize(String message, String message1) {
        super(message);
        this.message = message1;
    }
}
