package tictactoe.exceptions;

public class Invalidsymbol extends RuntimeException{
    String message;

    public Invalidsymbol(String message) {
        this.message = message;
    }

    public Invalidsymbol(String message, String message1) {
        super(message);
        this.message = message1;
    }
}
