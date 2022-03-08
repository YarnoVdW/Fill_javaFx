package be.kdg.applicatienaam.model.bord;

public class FillFxException extends Exception {
    public FillFxException() {
    }

    public FillFxException(String message) {
        super(message);
    }

    public FillFxException(String message, Throwable cause) {
        super(message, cause);
    }

    public FillFxException(Throwable cause) {
        super(cause);
    }
}
