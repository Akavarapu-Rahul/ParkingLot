package exception;

public class NoParkingSlotAvailableException extends Exception {
    public NoParkingSlotAvailableException() {
    }

    public NoParkingSlotAvailableException(String message) {
        super(message);
    }
}
