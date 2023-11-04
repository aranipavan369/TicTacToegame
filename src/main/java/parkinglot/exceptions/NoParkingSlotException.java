package parkinglot.exceptions;

public class NoParkingSlotException extends RuntimeException{

    public NoParkingSlotException(String message) {
        super(message);
    }
}
