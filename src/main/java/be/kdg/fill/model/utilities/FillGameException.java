

package be.kdg.fill.model.utilities;
/**Eige exception klasse
 */
public class FillGameException extends RuntimeException {
    public FillGameException() {
        super();
    }

    public FillGameException(String message) {
        super(message);
    }

    public FillGameException(String message, Throwable cause) {
        super(message, cause);
    }

    public FillGameException(Throwable cause) {
        super(cause);
    }

    public FillGameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
